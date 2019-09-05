/**
 * 
 */
package com.example.easynotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.OutputDto;
import com.example.easynotes.model.SaveQuestionPayload;
import com.example.easynotes.model.SaveReplyPayload;
import com.example.easynotes.service.ForumService;

/**
 * @author WAHID
 *
 */
@RestController
@RequestMapping("/forum")
public class ForumController {
	
	@Value("${isCacheAble}")
	private boolean isCacheAble;

	@Autowired
	ForumService forumService;

	@PostMapping("/save-question")
	public ResponseEntity<OutputDto> saveQuestion(@RequestBody SaveQuestionPayload saveQuestionPayload) {
		try {
			return forumService.saveQuestion(saveQuestionPayload);
		} catch (Exception e) {
			return new ResponseEntity<OutputDto>(new OutputDto("Something went wrong , plesae try again later", null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/save-reply")
	public ResponseEntity<OutputDto> saveReply(@RequestBody SaveReplyPayload saveReplyPayload) {
		try {
			ResponseEntity<OutputDto> response= forumService.saveReply(saveReplyPayload);
			if(isCacheAble) {
				new Thread(() -> forumService.updateCache(saveReplyPayload.getQuestionId())).start();
			}
			return response;
		} catch (Exception e) {
			return new ResponseEntity<OutputDto>(new OutputDto("Something went wrong , plesae try again later", null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-question-replies/{questionId}")
	public ResponseEntity<OutputDto> getQuestionAndReplies(@PathVariable("questionId") Integer questionId) {
		try {
			return forumService.getQuestionAndReplies(questionId);
		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<OutputDto>(new OutputDto(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-all-questions")
	public ResponseEntity<OutputDto> getAllQuestion( @RequestParam(value = "limit", required = false) Integer limit) {
		try {
			return forumService.getAllQuestions(limit);
		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<OutputDto>(new OutputDto(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-cached-question-replies/{questionId}")
	public ResponseEntity<OutputDto> getCachedQuestionAndReplies(@PathVariable("questionId") Integer questionId) {
		try {
			return forumService.getCachedQuestionAndReplies(questionId);
		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<OutputDto>(new OutputDto(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
