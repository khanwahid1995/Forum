/**
 * 
 */
package com.example.easynotes.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WAHID
 *
 */
public class QuestionRepliesReponse {
	
	private String question;
	
	private String userDispayName;
	
	private Date createdAt;
	
	private List<UserReplyResponse> replies ;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUserDispayName() {
		return userDispayName;
	}

	public void setUserDispayName(String userDispayName) {
		this.userDispayName = userDispayName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<UserReplyResponse> getReplies() {
		return replies;
	}

	public void setReplies(List<UserReplyResponse> list) {
		this.replies = list;
	}

	@Override
	public String toString() {
		return "QuestionRepliesReponse [question=" + question + ", userDispayName=" + userDispayName + ", createdAt="
				+ createdAt + ", replies=" + replies + "]";
	}

	public QuestionRepliesReponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
