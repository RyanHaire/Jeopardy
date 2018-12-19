<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.prog32758.Player" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Daily Double</title>
</head>
<body class="daily-double-page">
	<% Player player =  (Player)request.getSession().getAttribute("player");%>
	<% int maxBid = player.getScore() > 1000 ? player.getScore() : 1000; %>
	<h1 class="daily-double-header">DAILY DOUBLE!</h1>
	<div class="bid-container">
		<h2 class="daily-double-min">Min Bid: 0</h2>
		<h2 class="daily-double-max">Max Bid: $<%=maxBid%></h2>
	</div>
	<p class="daily-double-note">Enter the amount you want to bid below: </p>
	<form action="question" class="bid-form">
		<label for="bid" class="daily-double-input-label">Bid Amount</label>
		<input class="daily-double-bid-input" id="bid" type="number" max="<%=maxBid%>" min="0" placeholder="Bid Amount" name="bid" required>
		<input class="daily-double-submit-btn" type="submit" value="Bid">
	</form>
</body>
</html>