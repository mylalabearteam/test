package com.java.dto;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicInsert
@Entity
@SequenceGenerator( //오라클 시퀀스 사용
name = "comment_seq_generator", //시퀀스 제너레이터 이름
sequenceName = "comment_seq", //시퀀스 이름
initialValue = 1, //시작값
allocationSize = 1 //메모리를 통한 할당범위
)
@Table(name="CommentBoard")
public class Comment {
	@Id 
	@GeneratedValue(strategy =
	GenerationType.SEQUENCE,
	generator = "comment_seq_generator")
	private int cno;
	@ManyToOne
	@JoinColumn(name = "bno")
	private Board board;
	@ManyToOne
	@JoinColumn(name ="id")
	private Member member;
	
	private String cpw;
	private String ccontent;
	@CreationTimestamp //시간이 자동으로 입력
	private Timestamp cdate;
}
