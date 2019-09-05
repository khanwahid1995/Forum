/**
 * 
 */
package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.entities.QuestionUser;

/**
 * @author WAHID
 *
 */
@Repository
public interface QuestionUserRepository extends JpaRepository<QuestionUser, Integer> {

}
