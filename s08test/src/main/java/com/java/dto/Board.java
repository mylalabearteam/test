package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder //부분생성자
@AllArgsConstructor //전체생성자
@NoArgsConstructor //기본생성자
@Data //getter,setter
@DynamicInsert
@Entity
@SequenceGenerator( //오라클 시퀀스 사용
name = "board_seq_generator", //시퀀스 제너레이터 이름
sequenceName = "board_seq", //시퀀스 이름
initialValue = 1, //시작값
allocationSize = 1 //메모리를 통한 할당범위
)
//@Table(name="BoardDto")
public class Board {
	@Id 
	@GeneratedValue(strategy =
	GenerationType.SEQUENCE,
	generator = "board_seq_generator")
	private int bno;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private Member member;
	//private String id;
	
	@Column(nullable = false)
	private String btitle;
	private String bcontent;
	@CreationTimestamp //시간이 자동으로 입력
	private Timestamp bdate;
	@ColumnDefault("0")
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bfile;
	@ColumnDefault("0")
	private int btop;
	
	@OneToMany(mappedBy = "board",
		fetch = FetchType.EAGER,cascade = CascadeType.REMOVE) 
	@JsonIgnoreProperties({"board"}) // 무한루프 방지
	@OrderBy("cno desc") // cno 역순정렬
	private List<Comment> comments;


}