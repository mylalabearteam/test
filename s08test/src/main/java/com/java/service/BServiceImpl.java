package com.java.service;
import java.sql.Timestamp;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Board;
import com.java.dto.Comment;
import com.java.dto.Member;
import com.java.repository.BoardRepository;
import com.java.repository.CommentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



@Service
public class BServiceImpl implements BService {

	@Autowired BoardRepository bRepository;
	@Autowired CommentRepository cRepository;
	
	@PersistenceContext // 영속성 컨텍스트
	private EntityManager entityManager; // 엔티티 관리
	
	
	@Override
	public Page<Board> findAll(Pageable pageable) {
		Page<Board> list = bRepository.findAll(pageable);
		return list;
	}

	@Override
	public Board selectPrev(int bno) {
		//이전글
		Board prev = bRepository.boardPrev(bno);
		if(prev!=null) System.out.println("boardPrev : "+prev.getBno());
		return prev;
	}


	@Override
	public Board selectNext(int bno) {
		Board next = bRepository.boardNext(bno);
		if(next!=null) System.out.println("boardPrev : "+next.getBno());
		return next;
	}


	
	// ---------------------------------------
	@Override
	public List<Board> selectAll() {
		Sort sort = Sort.by(
				Sort.Order.desc("bgroup"),
				Sort.Order.asc("bstep")
				);
	//	Sort sort = Sort.by(Sort.Direction.ASC, "bno");
		List<Board> list = bRepository.findAll(sort);
		return list;
	}
	
	@Transactional
	@Override
	public Board selectOne(int bno) {
		//게시글 1개 가져오기
		Board board = bRepository.findById(bno).get();
		//조회수 1증가
		board.setBhit(board.getBhit()+1);
		return board;
	}

	@Transactional
	@Override
	public void insertOne(Board board) {
		try {
			// 객체를 저장한 상태(영속)-1차 캐시저장
			entityManager.persist(board); //시퀀스 파일 가져오기
			System.out.println("entityManager.persist : "+ board.getBno());
			board.setBgroup(board.getBno());
			board.setBdate(new Timestamp(System.currentTimeMillis()));
			bRepository.save(board); //em.commit()
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	@Transactional
	@Override
	public void updateOne(Board board) {
		try {
			
			
			
			board.setBdate(new Timestamp(System.currentTimeMillis()));
			bRepository.save(board); //em.commit()
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOne(int bno) {
		bRepository.deleteById(bno);
		
	}

	@Override
	public List<Comment> selectComAll(int bno) {
		List<Comment> list = cRepository.findAllByBno(bno);
		return list;
	}

	@Transactional
	@Override
	public Comment insertCom(Comment cb) {
		try {
			cb.setCdate(new Timestamp(System.currentTimeMillis()));
			cRepository.save(cb); //em.commit()
		} catch (Exception e) {
			e.printStackTrace();
		}
		Comment com = cRepository.findById(cb.getCno()).orElse(null);
		return com;
	}


	
	

}