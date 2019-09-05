/**
 * 
 */
package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.entities.User;

/**
 * @author WAHID
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
