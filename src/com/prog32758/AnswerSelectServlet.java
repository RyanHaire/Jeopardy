package com.prog32758;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
 * 
 * Servlet to handle answer select by user on question-select.jsp
 * 
 * 
 */
@WebServlet("/AnswerSelectServlet")
public class AnswerSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnswerSelectServlet() {
        super();
    }

    /*
     * 
     * doGet to handle question-select.jsp form request
     *
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// get session from request so i can get session attributes
		HttpSession session = request.getSession();
		
		// get player session attribute
		Player player = (Player)session.getAttribute("player");
		
		// get question session attribute for current question from question-select.jsp
		Question question = (Question)session.getAttribute("currentQuestion");
		
		// check if user skipped question
		if (request.getParameterMap().containsKey("skipForm")) {
			// redirect to game-board.jsp
			ServletUtil.redirect("game-board.jsp", response);
			return;
		}
		
		// get user answer from form parameter
		String userAnswer = request.getParameter("userAnswer");
		
		// correct answer from question sessiona attribute
		String correctAnswer = question.getCorrectAnswer();
		
		// question value of current question being processed
		int questionValue = question.getValue();
		
		// check if player is correct
		if (userAnswer.equals(correctAnswer)) {
			// increase player winnings with question value
			player.increaseScore(questionValue);
			
			// create modal body message for correct answer
			String modalBody = "You won $" + question.getValue();
			
			// session attribute to hold boolean value stating if player got the question correct
			session.setAttribute("userCorrectBool", true);
			
			// session attribute to hold modal header string value for correct answer
			session.setAttribute("modalHeader", "YOU ARE CORRECT!");
			
			// session attribute to hold modal body string value of how much money player won
			session.setAttribute("modalBody", modalBody);
		} else {
			// if player answer isn't equal to correct answer
			// decrease player winnings by question value
			player.decreaseScore(questionValue);
			
			
			// create modal body message for incorrect answer
			String modalBody = "You lost $" + question.getValue();	
			
			// session attribute to hold boolean value stating if player got the question incorrect
			session.setAttribute("userCorrectBool", false);
			
			// session attribute to hold modal header string value for incorrect answer
			session.setAttribute("modalHeader", "YOU ARE INCORRECT!");
			
			// session attribute to hold modal body string value of how much money player lost
			session.setAttribute("modalBody", modalBody);
		}
		
		// value of how many questions the player has answered so far
		int questionCount = player.getQuestionsAnsweredCount();
	
		// check if player has answered all the questions
		if (questionCount == 25) {
			
			// redirect to player-wins.jsp when game is over
			ServletUtil.redirect("player-wins.jsp", response);
		} else {
			
			//redirect to game-board.jsp if player has more questions to answer
			ServletUtil.redirect("game-board.jsp", response);
		}
		
	}


}
