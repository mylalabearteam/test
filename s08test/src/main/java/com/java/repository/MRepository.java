package com.java.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.Member;

public interface MRepository extends JpaRepository<Member, String> {
	
	@Query(value = "SELECT * FROM MEMBER WHERE ID=? AND PW=?",nativeQuery = true)
	Member selectLogin(String id, String pw);

}
