/**
 * 
 */
package com.example.easynotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.easynotes.entities.QuestionReplyMap;

/**
 * @author WAHID
 *
 */
@Repository
public interface QuestionReplyMapRepository extends JpaRepository<QuestionReplyMap, Integer> {

	Optional<List<Integer>> findParentReplyIdByQuestionId(Integer questionId);

	@Query(value = "select replyId from QuestionReplyMap where questionId=:questionId and parentReplyId=:parentReplyId")
	Optional<List<Integer>> findReplyIdByQuestionIdAndParentReplyId(Integer questionId, Integer parentReplyId);

	Optional<Long> countByParentReplyId(Integer child);

	@Query(value = "select replyId from QuestionReplyMap where parentReplyId=:parentReplyId")
	Optional<List<Integer>> findReplyIdByParentReplyId(Integer parentReplyId);

}
