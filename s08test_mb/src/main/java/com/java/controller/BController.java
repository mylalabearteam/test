package com.java.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Page;
import com.java.service.BService;

@Controller
public class BController {

	@Autowired BService bservice;
	@GetMapping("/board/blist")
	public String blist(Model model, Page pageDto) {
		
		System.out.println("BoardController page : "+pageDto.getPage());
		
		HashMap<String, Object> map = bservice.selectAllBoard(pageDto);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("pageDto",map.get("pageDto"));
		
		return "board/blist";
		
	}
	@RequestMapping("/board/bview")
	public String eventRead(int ebno, Model model, Page pageDto) {
		System.out.println("ebno :"+ebno);
		HashMap<String, Object> map = bservice.selectOneBoard(ebno, pageDto);
		model.addAttribute("list", map.get("bdto"));
		model.addAttribute("prev", map.get("prev"));
		model.addAttribute("next", map.get("next"));
		return "board/bview";
	}
}
