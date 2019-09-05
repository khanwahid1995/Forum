/**
 * 
 */
package com.example.easynotes.model;

import java.util.Date;
import java.util.List;

/**
 * @author WAHID
 *
 */
public class UserReplyResponse {
	
	private String reply;
	
	private String userDisplayName;
	
	private Date createdAt;
	
	private List<UserReplyResponse> replies;

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
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

	public List<UserReplyResponse> getReplies() {
		return replies;
	}

	public void setReplies(List<UserReplyResponse> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "UserReplyResponse [reply=" + reply + ", userDisplayName=" + userDisplayName + ", createdAt=" + createdAt
				+ ", replies=" + replies + "]";
	}

	public UserReplyResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
