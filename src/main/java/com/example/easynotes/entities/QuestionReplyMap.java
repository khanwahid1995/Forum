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
@Table(name = "question_reply_map")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class QuestionReplyMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="qust_id")
	private Integer questionId;
	
	@Column(name="parent_reply_id")
	private Integer parentReplyId;
	
	@Column(name="reply_id")
	private Integer replyId;
	
	@Column(name="created_at")
	private Date createdAt;

	public Integer getId() {
		return id;
	}


	public Integer getQustId() {
		return questionId;
	}

	public void setQustId(Integer qustId) {
		this.questionId = qustId;
	}

	public Integer getParentReplyId() {
		return parentReplyId;
	}

	public void setParentReplyId(Integer parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "QuestionReplyMap [id=" + id + ", qustId=" + questionId + ", parentReplyId=" + parentReplyId + ", replyId="
				+ replyId + ", createdAt=" + createdAt + "]";
	}


	public QuestionReplyMap() {
		super();
	}
	
	
	
	
	
	
}
