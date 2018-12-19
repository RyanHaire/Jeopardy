package com.prog32758;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Servlet to handle question selection from game-board.jsp
 * 
 */
@WebServlet("/QuestionServlet")
public class PickQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PickQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String questionVal = request.getParameter("question");
		HttpSession session = request.getSession();
		
		if(request.getParameterMap().containsKey("bid")) {
			Player player = (Player) request.getSession().getAttribute("player");
			Question question = (Question)request.getSession().getAttribute("currentQuestion");
			
			int score = player.getScore();
			int bid = Integer.parseInt(request.getParameter("bid"));
			
			if (request.getParameter("bid").equals("")) {
				bid = 0; 
			} else if(score < 1000 && bid <= 1000 && bid >= 0) {
				int newVal = question.getValue() + bid;
				question.setValue(newVal);
			} else if(score > 1000 && bid <= score && bid >= 0) {
				// bid can be maximum of score
				int newVal = question.getValue() + bid;
				question.setValue(newVal);
			} else {
				// bid isnt correct
			}
			ServletUtil.redirect("question-select.jsp", response);
			return;
		}
		
		/* 
		 * questions.get(0) - questions.get(4) = Sports Category
		 * questions.get(5) - questions.get(9) = Video Games Category
		 * questions.get(10) - questions.get(14) = Movies Category
		 * questions.get(15) - questions.get(19) = Dogs Category
		 * questions.get(20) - questions.get(24) = Beers Category  
		 * */
		QuestionFactory questions = (QuestionFactory) request.getSession().getAttribute("questionFactory");
		Question question = null;
		// switch through categories to check which one was selected
		switch(category) {
			case "sports":
				// switch through values to get the question related to the value 
				switch(questionVal) {
					case "200":
						updateQuestion(question, questions, session, 0, response, request);					
						break;
					case "400":
						updateQuestion(question, questions, session, 1, response, request);
						break;
					case "600":
						updateQuestion(question, questions, session, 2, response, request);
						break;
					case "800":
						updateQuestion(question, questions, session, 3, response, request);
						break;
					case "1000":
						updateQuestion(question, questions, session, 4, response, request);
						break;
				}
				break;
			case "video games":
				// switch through values to get the question related to the value 
				switch(questionVal) {
					case "200":
						updateQuestion(question, questions, session, 5, response, request);
						break;
					case "400":
						updateQuestion(question, questions, session, 6, response, request);
						break;
					case "600":
						updateQuestion(question, questions, session, 7, response, request);
						break;
					case "800":
						updateQuestion(question, questions, session, 8, response, request);
						break;
					case "1000":
						updateQuestion(question, questions, session, 9, response, request);
						break;
				}
				break;
			case "movies":
				// switch through values to get the question related to the value 
				switch(questionVal) {
					case "200":
						updateQuestion(question, questions, session, 10, response, request);
						break;
					case "400":
						updateQuestion(question, questions, session, 11, response, request);
						break;
					case "600":
						updateQuestion(question, questions, session, 12, response, request);
						break;
					case "800":
						updateQuestion(question, questions, session, 13, response, request);
						break;
					case "1000":
						updateQuestion(question, questions, session, 14, response, request);
						break;
				}
				break;
			case "dogs":
				// switch through values to get the question related to the value 
				switch(questionVal) {
					case "200":
						updateQuestion(question, questions, session, 15, response, request);
						break;
					case "400":
						updateQuestion(question, questions, session, 16, response, request);
						break;
					case "600":
						updateQuestion(question, questions, session, 17, response, request);
						break;
					case "800":
						updateQuestion(question, questions, session, 18, response, request);
						break;
					case "1000":
						updateQuestion(question, questions, session, 19, response, request);
						break;
				}
				break;
			case "beers":
				// switch through values to get the question related to the value 
				switch(questionVal) {
					case "200":
						updateQuestion(question, questions, session, 20, response, request);
						break;
					case "400":
						updateQuestion(question, questions, session, 21, response, request);
						break;
					case "600":
						updateQuestion(question, questions, session, 22, response, request);
						break;
					case "800":
						updateQuestion(question, questions, session, 23, response, request);
						break;
					case "1000":
						updateQuestion(question, questions, session, 24, response, request);
						break;
				}
		}
	}
	
	private void updateQuestion(Question question, QuestionFactory questions, HttpSession session, 
		int questionIndex, HttpServletResponse response, HttpServletRequest request) {
		
		// set question to answered in question object
		question = questions.getQuestions().get(questionIndex);
		question.setAnswered(true);
		Player player = (Player)session.getAttribute("player");
		player.increaseQuestionsAnsweredCount();
		session.setAttribute("currentQuestion", question);
		
		if (question.isDailyDouble()) {
			ServletUtil.redirect("daily-double.jsp", response);
		} else {
			ServletUtil.redirect("question-select.jsp", response);
		}
		
		return;
	}


}
