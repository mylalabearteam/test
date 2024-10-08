package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.ResponseDto;
import com.java.dto.TodoDto;
import com.java.dto.UserDto;
import com.java.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired UserService uservice;
	
	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody UserDto dto){
		System.out.println("signup");
		
		try {
			if(dto == null || dto.getPassword() == null) {
				throw new RuntimeException("잘못입력하셨습니다.");
			}
			uservice.insertOne(dto);
			UserDto user = uservice.selectOne(dto); 
			return ResponseEntity.ok().body(user);
		}catch (Exception e) {
			ResponseDto response = 
					ResponseDto.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserDto dto){
		System.out.println("login");
		try {
			UserDto user = uservice.selectOne(dto);
			if(user == null) {
				throw new RuntimeException("잘못입력하셨습니다.");
			}
			return ResponseEntity.ok().body(user);
		}catch (Exception e) {
			ResponseDto response = 
					ResponseDto.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
}
