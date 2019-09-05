/**
 * 
 */
package com.example.easynotes.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.easynotes.entities.QuestionReplyMap;
import com.example.easynotes.entities.QuestionUser;
import com.example.easynotes.entities.ReplyUser;
import com.example.easynotes.entities.User;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.OutputDto;
import com.example.easynotes.model.QuestionRepliesReponse;
import com.example.easynotes.model.QuestionResponse;
import com.example.easynotes.model.SaveQuestionPayload;
import com.example.easynotes.model.SaveReplyPayload;
import com.example.easynotes.model.UserReplyResponse;
import com.example.easynotes.repository.QuestionReplyMapRepository;
import com.example.easynotes.repository.QuestionUserRepository;
import com.example.easynotes.repository.ReplyUserRepository;
import com.example.easynotes.repository.UserRepository;
import com.example.easynotes.service.ForumService;

/**
 * @author WAHID
 *
 */
@Service
public class ForumServiceImpl implements ForumService {
	
	@Value("${isCacheAble}")
	private boolean isCacheAble;

	@Autowired
	QuestionUserRepository questionUserRepo;

	@Autowired
	ReplyUserRepository replyUserRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	QuestionReplyMapRepository questionReplyMapRepository;

	private Map<Integer, QuestionRepliesReponse> cached = new HashMap<>();

	@Override
	public ResponseEntity<OutputDto> saveQuestion(SaveQuestionPayload saveQuestionPayload) {

		QuestionUser questionUser = new QuestionUser();
		questionUser.setQuestion(saveQuestionPayload.getQuestion());
		questionUser.setUserId(saveQuestionPayload.getUserId());
		questionUser.setCreatedAt(new Date());

		questionUserRepo.save(questionUser);

		return new ResponseEntity<OutputDto>(HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<OutputDto> saveReply(SaveReplyPayload saveReplyPayload) {

		ReplyUser replyUser = new ReplyUser();
		replyUser.setReply(saveReplyPayload.getReply());
		replyUser.setUserId(saveReplyPayload.getUserId());
		replyUser.setCreatedAt(new Date());

		replyUserRepository.save(replyUser);

		QuestionReplyMap questionReplyMap = new QuestionReplyMap();
		questionReplyMap.setQustId(saveReplyPayload.getQuestionId());
		questionReplyMap.setParentReplyId(
				saveReplyPayload.getParentReplyId() == null ? 0 : saveReplyPayload.getParentReplyId());
		questionReplyMap.setReplyId(replyUser.getId());
		questionReplyMap.setCreatedAt(new Date());

		questionReplyMapRepository.save(questionReplyMap);

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<OutputDto> getQuestionAndReplies(Integer questionId) {

		Map<Integer, String> userIdAndDisplayName = new HashMap<>();

		QuestionRepliesReponse questionReplies = new QuestionRepliesReponse();

		QuestionUser questionUser = questionUserRepo.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question", "id", questionId));

		if (!userIdAndDisplayName.containsKey(questionUser.getUserId())) {
			User user = userRepository.findById(questionUser.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("User", "user", questionUser.getUserId()));
			userIdAndDisplayName.put(questionUser.getUserId(), user.getDisplayName());
		}

		questionReplies.setQuestion(questionUser.getQuestion());
		questionReplies.setUserDispayName(userIdAndDisplayName.get(questionUser.getUserId()));
		questionReplies.setCreatedAt(questionUser.getCreatedAt());
		questionReplies.setReplies(buildReplies(questionId, userIdAndDisplayName));

		// List<Map<String,Object>> replies =buildReplies(questionId);

		return new ResponseEntity<OutputDto>(new OutputDto(null, questionReplies), HttpStatus.OK);

	}

	private List<UserReplyResponse> buildReplies(Integer questionId, Map<Integer, String> userIdAndDisplayName) {

		List<UserReplyResponse> replies = new ArrayList<>();

		List<Integer> firstChilds = getFirtRepliesForQuestionId(questionId);

		for (Integer firstChild : firstChilds) {
			replies.add(getBranchingReplies(firstChild, userIdAndDisplayName));
		}

		return replies;
	}

	private UserReplyResponse getBranchingReplies(Integer child, Map<Integer, String> userIdAndDisplayName) {
		UserReplyResponse userReply = new UserReplyResponse();
		ReplyUser replyUser = replyUserRepository.findById(child).get();
		if (!userIdAndDisplayName.containsKey(replyUser.getUserId())) {
			User user = userRepository.findById(replyUser.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("User", "user", replyUser.getUserId()));
			userIdAndDisplayName.put(replyUser.getUserId(), user.getDisplayName());
		}
		if (isParentReply(child)) {
			System.out.println("sd");
			List<Integer> innerChilds = getchildsforReplyId(child);
			List<UserReplyResponse> replies = new ArrayList<>();
			for (Integer childTemp : innerChilds) {
				replies.add(getBranchingReplies(childTemp, userIdAndDisplayName));
			}
			userReply.setUserDisplayName(userIdAndDisplayName.get(replyUser.getUserId()));
			userReply.setReply(replyUser.getReply());
			userReply.setCreatedAt(replyUser.getCreatedAt());
			userReply.setReplies(replies);
			return userReply;
		} else {
			System.out.println("as");
			userReply.setUserDisplayName(userIdAndDisplayName.get(replyUser.getUserId()));
			userReply.setReply(replyUser.getReply());
			userReply.setCreatedAt(replyUser.getCreatedAt());
			userReply.setReplies(new ArrayList<>());
			return userReply;
		}
	}

	private List<Integer> getchildsforReplyId(Integer child) {
		Optional<List<Integer>> childsOp = questionReplyMapRepository.findReplyIdByParentReplyId(child);
		return childsOp.isPresent() ? childsOp.get() : new ArrayList<>();
	}

	private boolean isParentReply(Integer child) {
		Optional<Long> op = questionReplyMapRepository.countByParentReplyId(child);
		if (op.isPresent())
			return op.get().intValue() > 0;
		return false;
	}

	private List<Integer> getFirtRepliesForQuestionId(Integer questionId) {
		Optional<List<Integer>> firstChildsOp = questionReplyMapRepository
				.findReplyIdByQuestionIdAndParentReplyId(questionId, 0);
		return firstChildsOp.isPresent() ? firstChildsOp.get() : new ArrayList<>();
	}

	@Override
	public ResponseEntity<OutputDto> getAllQuestions(Integer limit) {
		Pageable top = null;
		limit = limit == null ? 100 : limit;
		Page<QuestionUser> questionUserOp = questionUserRepo
				.findAll(PageRequest.of(0, limit, Sort.by(Direction.DESC, "createdAt")));
		List<QuestionResponse> response = new ArrayList<>();
		Iterator<QuestionUser> iterator = questionUserOp.iterator();
		while (iterator.hasNext()) {
			QuestionUser questionUser = iterator.next();
			QuestionResponse temp = new QuestionResponse();
			temp.setQuestion(questionUser.getQuestion());
			temp.setQuestionId(questionUser.getId());
			temp.setUserDisplayName(getDisplayName(questionUser.getUserId()));
			temp.setCreatedAt(questionUser.getCreatedAt());
			response.add(temp);
		}

		return new ResponseEntity<OutputDto>(new OutputDto(null, response), HttpStatus.OK);
	}

	private String getDisplayName(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user", userId));
		return user.getDisplayName();
	}

	@Override
	public ResponseEntity<OutputDto> getCachedQuestionAndReplies(Integer questionId) {
		if (isCacheAble && !cached.containsKey(questionId)) {
			cached.put(questionId, (QuestionRepliesReponse) getQuestionAndReplies(questionId).getBody().getData());
		}
		return new ResponseEntity<OutputDto>(new OutputDto(null, cached.get(questionId)), HttpStatus.OK);
	}

	@Override
	public void updateCache(Integer questionId) {
		cached.put(questionId, (QuestionRepliesReponse) getQuestionAndReplies(questionId).getBody().getData());
	}

}
