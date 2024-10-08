package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {

	@Autowired
	HttpSession session;
	@Autowired
	MService mService;
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	@PostMapping("/login")
	public String dologin(Member member, Model model) {	
		Member mem = mService.selectLogin(member);
		if (mem == null) {	
			model.addAttribute("result",2);
		}
		if (mem != null) {
			System.out.println(mem.getId()+mem.getPw()+mem.getName());	
			model.addAttribute("result",1);
			session.setAttribute("sessionId", mem.getId());
			session.setAttribute("sessionName", mem.getName());
		}
		return "/member/login";
	}
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "/index";
	}
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	@PostMapping("/join")
	public String dojoin(Member member, String[] hobby) {
		System.out.println(member.getId());
		System.out.println(Arrays.toString(hobby));
		String hb="";
		for(int i = 0 ; i < hobby.length; i++) {
			if(i==0) hb += hobby[i];
			else hb += ", "+hobby[i];
		}
		member.setHobbys(hb);
		mService.insertOne(member);
		return "redirect:/index";
	}
	@GetMapping("/updateInfo")
	public String updateInfo(Model model) {
		String id = (String)session.getAttribute("sessionId");
		Member mem = mService.selectById(id);
		model.addAttribute("member", mem);
		return "member/updateInfo";
	}
	@PostMapping("/updateInfo")
	public String doupdateInfo(Member member, String[] hobby) {
		String hb="";
		for(int i = 0 ; i < hobby.length; i++) {
			if(i==0) hb += hobby[i];
			else hb += ", "+hobby[i];
		}
		member.setHobbys(hb);
		mService.updateOne(member);
		return "redirect:/index";
	}
	@GetMapping("/mlist")
	public String mlist(Model model) {
		List<Member> memberList = mService.selectAll();
		model.addAttribute("memberList",memberList);
		return "member/mlist";
	}
	
}
