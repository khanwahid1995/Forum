/**
 * 
 */
package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.entities.ReplyUser;

/**
 * @author WAHID
 *
 */
@Repository
public interface ReplyUserRepository extends JpaRepository<ReplyUser, Integer> {

}
