package com.java.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.Board;


public interface BoardRepository extends JpaRepository<Board, Integer> {

	@Query(value = "SELECT * FROM board WHERE bno = "
			+ "(SELECT prev_bno FROM "
			+ "(SELECT bno, LAG(bno, 1, -1) "
			+ "OVER(order by btop desc,bgroup desc,bstep asc) "
			+ "AS prev_bno FROM board) B WHERE bno = ?)", nativeQuery = true)
	Board boardPrev(int bno);

	@Query(value = "SELECT * FROM board WHERE bno = "
			+ "(SELECT next_bno FROM "
			+ "(SELECT bno, LEAD(bno, 1, -1) "
			+ "OVER(order by btop desc,bgroup desc,bstep asc) "
			+ "AS next_bno FROM board) B WHERE bno = ?)", nativeQuery = true)
	Board boardNext(int bno);
	

}
