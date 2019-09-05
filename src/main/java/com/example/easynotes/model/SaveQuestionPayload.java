/**
 * 
 */
package com.example.easynotes.model;

/**
 * @author WAHID
 *
 */
public class SaveQuestionPayload {
	
	private String question;
	
	private Integer userId;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SaveQuestionPayload [question=" + question + ", userId=" + userId + "]";
	}
	
	

}
