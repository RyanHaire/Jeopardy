package com.prog32758;

import java.io.Serializable;


/*
 * Player object with necessary player values
 * 
 */
public class Player implements Serializable {
	
	private static final long serialVersionUID = -4014088667563712456L;
	private String name;
	private int score = 0;
	private int questionsAnsweredCount = 0;
	
	public Player() {
		
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void increaseScore(int value) {
		this.score += value;
	}
	
	public void decreaseScore(int value) {
		this.score -= value; 
	}
	
	public int getQuestionsAnsweredCount() {
		return this.questionsAnsweredCount;
	}
	
	public void increaseQuestionsAnsweredCount() {
		this.questionsAnsweredCount += 1;
	}
}

