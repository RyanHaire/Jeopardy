package com.prog32758;


/*
 * 
 * Question class to hold necessary question values 
 */
public class Question {
	private String category;
	private String question;
	private int value;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String correctAnswer;
	private boolean isAnswered = false;
	private boolean isDailyDouble = false;
	
	public boolean isDailyDouble() {
		return isDailyDouble;
	}

	public void setDailyDouble(boolean isDailyDouble) {
		this.isDailyDouble = isDailyDouble;
	}

	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public Question() {
		
	}
	
	public Question(String category, int value, String question, String a1, String a2, 
			String a3, String a4, String correctAnswer) {
		this.question = question;
		this.category = category;
		this.value = value;
		this.answer1 = a1;
		this.answer2 = a2;
		this.answer3 = a3;
		this.answer4 = a4;
		this.correctAnswer = correctAnswer;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
	
