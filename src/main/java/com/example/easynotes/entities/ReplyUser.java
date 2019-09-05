/**
 * 
 */
package com.example.easynotes.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author WAHID
 *
 */
@Entity
@Table(name = "reply_user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ReplyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "reply")
	private String reply;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "modified_at")
	private Date modifiedAt;

	@Column(name = "created_at")
	private Date createdAt;

	public Integer getId() {
		return id;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ReplyUser [id=" + id + ", reply=" + reply + ", userId=" + userId + ", modifiedAt=" + modifiedAt
				+ ", createdAt=" + createdAt + "]";
	}

	public ReplyUser() {
		super();
	}
	
	
	
	

}
