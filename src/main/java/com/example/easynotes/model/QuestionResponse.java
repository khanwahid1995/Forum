/**
 * 
 */
package com.example.easynotes.model;

import java.util.Date;

/**
 * @author WAHID
 *
 */
public class QuestionResponse {
	
	private Integer questionId;
	
	private String question;
	
	private String userDisplayName;
	
	private Date createdAt;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}



	@Override
	public String toString() {
		return "QuestionResponse [questionId=" + questionId + ", question=" + question + ", userDisplayName="
				+ userDisplayName + ", createdAt=" + createdAt + "]";
	}

	public QuestionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
