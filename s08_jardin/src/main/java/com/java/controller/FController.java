package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/ordercheck")
	public String ordercheck() {
		return "ordercheck";
	}
	@RequestMapping("/order")
	public String order() {
		return "order";
	}
	@GetMapping("/modimem")
	public String modimem(Model model,String cpw) {
		model.addAttribute("cpw",cpw);
		return "modimem";
	}
	@PostMapping("/modimem")
	public String domodimem(Model model,String cpw) {
		model.addAttribute("cpw",cpw);
		return "redirect:/";
	}
	@RequestMapping("/changepw")
	public String changepw(Model model) {
		model.addAttribute("oldpw","1111");
		return "changepw";
	}
	@GetMapping("/change")
	public String change(Model model,String cpw) {
		model.addAttribute("cpw",cpw);
		return "change";
	}
}
