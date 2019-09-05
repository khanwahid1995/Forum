/**
 * 
 */
package com.example.easynotes.model;

/**
 * @author WAHID
 *
 */
public class SaveReplyPayload {

	private Integer userId;
	
	private Integer questionId;
	
	private Integer parentReplyId;
	
	private String reply;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getParentReplyId() {
		return parentReplyId;
	}

	public void setParentReplyId(Integer parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "SaveReplyPayload [userId=" + userId + ", questionId=" + questionId + ", parentReplyId=" + parentReplyId
				+ ", reply=" + reply + "]";
	}
	
	
	
}
