package com.java.service;

import java.util.List;

import com.java.dto.Member;

public interface MService {

	Member selectLogin(Member member);

	void insertOne(Member member);

	Member selectById(String id);

	void updateOne(Member member);

	List<Member> selectAll();

}
