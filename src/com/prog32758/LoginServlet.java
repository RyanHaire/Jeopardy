package com.prog32758;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Servlet to handle login from login-page.html
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// get playerName from player input in login.html
		String playerName = request.getParameter("playerName");
		
		// create an instance of a player class for user with user name input 
		Player player = new Player(playerName);
		
		// create instance of QuestionFactory class so questions are created
		QuestionFactory questionFactory = QuestionFactory.getInstance();
			
		// session attribute object so i can add initial session attributes at start of game
		HttpSession session = request.getSession();
		
		// add inital player object to session as an attribute
		session.setAttribute("player", player);
		
		// add inital questionfactory object to session as an attribute
		session.setAttribute("questionFactory", questionFactory);
		
		// 
		Random random = new Random();
		int dailyDoubleQuestionIndex1 = random.nextInt(25);
		int dailyDoubleQuestionIndex2 = random.nextInt(25);
		
		while(dailyDoubleQuestionIndex2 == dailyDoubleQuestionIndex1) {
			dailyDoubleQuestionIndex2 = random.nextInt(25);
		}
		
		questionFactory.getQuestions().get(dailyDoubleQuestionIndex1).setDailyDouble(true);
		questionFactory.getQuestions().get(dailyDoubleQuestionIndex2).setDailyDouble(true);

		ServletUtil.redirect("game-board.jsp", response);
		
	}

	

}
