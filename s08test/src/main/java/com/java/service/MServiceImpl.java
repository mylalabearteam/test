package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.repository.MRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class MServiceImpl implements MService {

	@Autowired HttpSession session;
	@Autowired MRepository memberRepository; 
	
	@Override
	public Member selectLogin(Member mem) {
		System.out.println(mem.getId() + mem.getPw());
		
		//Member member = memberRepository.selectLogin(mem.getId(), mem.getPw());
		Member member = memberRepository.findById(mem.getId()).orElse(null);
		
		if(member.getPw().equals(mem.getPw()) ) {
			return member;
		}
		
		return null;
	}

	@Override
	public List<Member> selectAll() {
		List<Member>  mlist = memberRepository.findAll();
		return mlist;
	}

	@Override
	public void insertOne(Member member) {
		memberRepository.save(member);
		
	}

	@Override
	public Member selectById(String id) {
		//Member member = memberRepository.selectById(id);
		Member member = memberRepository.findById(id).orElseThrow();
		System.out.println(member);
		return member;
	}

	@Override
	public void updateOne(Member member) {
		try {
			memberRepository.save(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
