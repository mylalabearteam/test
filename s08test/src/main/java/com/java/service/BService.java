package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.dto.Board;
import com.java.dto.Comment;

public interface BService {

	List<Board> selectAll();

	Board selectOne(int bno);

	void insertOne(Board board);

	void updateOne(Board board);

	void deleteOne(int bno);

	List<Comment> selectComAll(int bno);

	Comment insertCom(Comment cb);

	Page<Board> findAll(Pageable pageable);

	Board selectPrev(int bno);

	Board selectNext(int bno);

	
	
	
	
	


}
