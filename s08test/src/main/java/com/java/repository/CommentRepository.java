package com.java.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.Board;
import com.java.dto.Comment;
import com.java.dto.Member;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query(value = "SELECT * FROM commentboard WHERE bno=?",nativeQuery = true)
	List<Comment> findAllByBno(int bno);
	

}
