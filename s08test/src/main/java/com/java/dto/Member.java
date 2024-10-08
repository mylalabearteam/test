package com.java.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity // @Entity가 붙은 클래스는 JPA가 관리하는 클래스
//@Table(name="MemberDto")
public class Member {
	
	@Id // @id 를 사용하여 기본키(PK)로 지정
	@Column(name="id")
	private String id;
	
	@Column(nullable=false, length=30)
	private String pw;
	
	@Column(nullable=false, length=30)
	private String name;
	
	private String phone;
	
	private String gender;
	
	private String hobbys;
	
	@OneToMany(mappedBy = "member",
			fetch = FetchType.EAGER,cascade = CascadeType.REMOVE) 
	@JsonIgnoreProperties({"member"}) // 무한루프 방지
	private List<Board> boardLists;
	
	
	}
