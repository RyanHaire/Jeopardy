<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.prog32758.Question" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jeopardy</title>
<link rel="stylesheet" href="styles/styles.css" type="text/css">
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
</head>
<body class="question-select-page">
		<script type="text/javascript">
			$(function(e) {
				$('#answer-submit-btn').click(function(e) {
					if (!$("input[name='userAnswer']:checked").val()) {
						e.preventDefault();
						alert('Please select an answer or skip the question.');
					 	return false;
					}
				});
			});
		</script>
		<h2 class="question-page-category">Category:${currentQuestion.getCategory()}</h2>
		<h1 class="question">${currentQuestion.getQuestion()}</h1>
		<c:if test="${currentQuestion.isDailyDouble()}">
			<p class="question-value">Daily Double Question Value is now $${currentQuestion.getValue()}</p>
		</c:if>
		<form action="answer" class="answer-form">
			<p class="answer-note">What is...</p>
			<div class="answer-grid">
				<div class="row">
					<!-- first answer -->
					<span class="row-item">
						<input class="answer-radio-btn" type="radio" name="userAnswer" value="${currentQuestion.getAnswer1()}"/>
						${currentQuestion.getAnswer1()}
					</span>
					<!-- second answer -->
					<span class="row-item">
						<input class="answer-radio-btn" type="radio" name="userAnswer" value="${currentQuestion.getAnswer2()}"/>
						${currentQuestion.getAnswer2()}
					</span>
				</div>
				<div class="row">
				<!-- third answer -->
					<span class="row-item">
						<input class="answer-radio-btn" type="radio" name="userAnswer" value="${currentQuestion.getAnswer3()}"/>
						${currentQuestion.getAnswer3()}
					</span>
					<!-- fourth answer -->
					<span class="row-item">
						<input class="answer-radio-btn" type="radio" name="userAnswer" value="${currentQuestion.getAnswer4()}"/>
						${currentQuestion.getAnswer4()}
					</span>
				</div>
			</div>
			<button id="answer-submit-btn" class="answer-submit-btn" type="submit">Answer</button>
		</form>
		<form action="answer">
			<input type="hidden" name="skipForm" value="true">
			<button class="answer-skip-btn" type="submit">Skip Question</button>
		</form>
</body>
</html>