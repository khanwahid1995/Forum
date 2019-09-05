/**
 * 
 */
package com.example.easynotes.service;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.example.easynotes.model.OutputDto;
import com.example.easynotes.model.SaveQuestionPayload;
import com.example.easynotes.model.SaveReplyPayload;

/**
 * @author WAHID
 *
 */
public interface ForumService {

	@Transactional(rollbackFor = Exception.class)
	ResponseEntity<OutputDto> saveQuestion(SaveQuestionPayload saveQuestionPayload);

	@Transactional(rollbackFor = Exception.class)
	ResponseEntity<OutputDto> saveReply(SaveReplyPayload saveReplyPayload);

	@Transactional(rollbackFor = Exception.class)
	ResponseEntity<OutputDto> getQuestionAndReplies(Integer questionId);

	@Transactional(rollbackFor = Exception.class)
	ResponseEntity<OutputDto> getAllQuestions(Integer limit);

	ResponseEntity<OutputDto> getCachedQuestionAndReplies(Integer questionId);

	void updateCache(Integer questionId);
	
	

}
