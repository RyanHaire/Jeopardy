<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.prog32758.QuestionFactory" %>
<%@ page import="com.prog32758.Question" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sheridan Jeopardy - Game Board</title>
<link rel="stylesheet" href="styles/styles.css" type="text/css">
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script
  src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"
  integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E="
  crossorigin="anonymous"></script>
</head>
<body class="game-board-page">
	<c:if test="${sessionScope.userCorrectBool != null}">
		<c:set var="modalHeader" value='${sessionScope["modalHeader"]}'/>
		<c:set var="modalBody" value='${sessionScope["modalBody"]}'/>
		<c:set var="userCorrectBool" value='${sessionScope["userCorrectBool"]}'/>
		<script type="text/javascript">
			// display player won money, correct answer
			var userCorrectBool = "${userCorrectBool}";
			var autoOpen = false;
			
			var dialogClassIncorrect = "custom-ui-widget-header-incorrect";
			var dialogClassCorrect = "custom-ui-widget-header-correct";
			var dialogClass = "";
			
			if (userCorrectBool === "true") {
				dialogClass = dialogClassCorrect;
			} else if (userCorrectBool === "false") {
				dialogClass = dialogClassIncorrect;
			}
			if (userCorrectBool != null) {
				autoOpen = true;
				$(function() {
					$( "#modal" ).dialog({
						autoOpen: autoOpen,
						minWidth: 400,
						minHeight: 'auto',
						dialogClass: dialogClass,
						position: {
							my: "center center",
						    at: "center center"
						}
				     });
				});
			}
		</script>
		<div id="modal">
			<h2><c:out value="${modalHeader}"/></h2>
			<p><c:out value="${modalBody}"/></p>
		</div>
		<c:remove var="modalHeader" scope="session"/>
		<c:remove var="modalBody" scope="session"/>
		<c:remove var="userCorrectBool" scope="session"/>
	</c:if>
	<div class="game-board-header">
		<p class="player-name">Player: ${player.getName()}<p>
		<p class="winnings">Winnings: $ ${player.getScore()}</p>
	</div>
	
	<% 
		QuestionFactory questionFactory = (QuestionFactory) request.getSession().getAttribute("questionFactory");
		ArrayList<Question> sportsQuestions = questionFactory.getSportsCategory();
		ArrayList<Question> videoGamesQuestions = questionFactory.getVideoGamesCategory();
		ArrayList<Question> movieQuestions = questionFactory.getMoviesCategory();
		ArrayList<Question> dogQuestions = questionFactory.getDogsCategory();
		ArrayList<Question> beersQuestions = questionFactory.getBeersCategory();
	%>
	<div class="container">
		<div class="column">
			<h1 class="category-title">Sports</h1>
			<% for(Question q: sportsQuestions) { 
					if (q.isAnswered()) { %>
						<a class="category-question-link-disabled" href="question?category=sports&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<%  	} else { %>
						<a class="category-question-link" href="question?category=sports&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<% 		} 
				}
			%>
		</div>
		<div class="column">
			<h1 class="category-title">Video Games</h1>
			<% for(Question q: videoGamesQuestions) { 
					if (q.isAnswered()) { %>
						<a class="category-question-link-disabled" href="question?category=video%20games&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<%  	} else { %>
						<a class="category-question-link" href="question?category=video%20games&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<% 		} 
				}
			%>
		</div>
		<div class="column">
			<h1 class="category-title">Dogs</h1>
			<% for(Question q: dogQuestions) { 
					if (q.isAnswered()) { %>
						<a class="category-question-link-disabled" href="question?category=dogs&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<%  	} else { %>
						<a class="category-question-link" href="question?category=dogs&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<% 		} 
				}
			%>
		</div>
		<div class="column">
			<h1 class="category-title">Movies</h1>
			<% for(Question q: movieQuestions) { 
					if (q.isAnswered()) { %>
						<a class="category-question-link-disabled" href="question?category=movies&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<%  	} else { %>
						<a class="category-question-link" href="question?category=movies&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<% 		} 
				}
			%>
		</div>
		<div class="column">
			<h1 class="category-title">Beers</h1>
			<% for(Question q: beersQuestions) { 
					if (q.isAnswered()) { %>
						<a class="category-question-link-disabled" href="question?category=beers&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<%  	} else { %>
						<a class="category-question-link" href="question?category=beers&question=<%=q.getValue()%>">$<%=q.getValue()%></a>
			<% 		} 
				}
			%>
		</div>
	</div>
</body>
</html>