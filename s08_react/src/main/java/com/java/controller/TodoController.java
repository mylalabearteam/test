package com.java.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.ResponseDto;
import com.java.dto.TodoDto;
import com.java.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	@Autowired TodoService service;
	@GetMapping
	public ResponseEntity<Object> index() {
		System.out.println("Get mapping");
		List<TodoDto> entities = service.selectAll();
		ResponseDto<TodoDto> response = 
				ResponseDto.<TodoDto>builder().data(entities).build();
		return ResponseEntity.ok().body(response);
	}
/*	@PostMapping
	public ResponseEntity<Object> todopost(){
		List<TodoDto> entities = service.selectAll();
		try {
			ResponseDto<TodoDto> response = 
					ResponseDto.<TodoDto>builder().data(entities).build();
			System.out.println(ResponseEntity.ok().body(response));
			return ResponseEntity.ok().body(response);
		}catch (Exception e) { e.printStackTrace(); }
		return null;
	}
*/	
/*	@PostMapping
	public ResponseEntity<Object> createTodo(@RequestBody TodoDto dto){
		System.out.println("post mapping");
		System.out.println(dto.getTitle());
		List<TodoDto> entities = service.selectAll();
		//System.out.println(entities.get(0));
		
		ResponseDto<TodoDto> response = 
				ResponseDto.<TodoDto>builder().data(entities).build();
		return ResponseEntity.ok().body(response);
		
	}
	*/
	@PostMapping
	public ResponseEntity<Object> createTodo(@RequestBody TodoDto dto){
		System.out.println("post mapping");
		System.out.println(dto);
		dto.setUserId("aaa");
		dto.setDone(false);
		service.insertOne(dto);
		try {
			List<TodoDto> entities = service.selectAll();
			ResponseDto<TodoDto> response = 
					ResponseDto.<TodoDto>builder().data(entities).build();
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			// 예외가 발생할 경우 dto 대신 에러메세지 넣기 
			String error = e.getMessage();
			ResponseDto<TodoDto> response = 
					ResponseDto.<TodoDto>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deleteTodo(@RequestBody TodoDto dto){
		System.out.println("delete mapping");
		System.out.println(dto);
		service.deleteOne(dto);
		try {
			List<TodoDto> entities = service.selectAll();
			ResponseDto<TodoDto> response = 
					ResponseDto.<TodoDto>builder().data(entities).build();
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			// 예외가 발생할 경우 dto 대신 에러메세지 넣기 
			String error = e.getMessage();
			ResponseDto<TodoDto> response = 
					ResponseDto.<TodoDto>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateTodo(@RequestBody TodoDto dto){
		System.out.println("update mapping");
		System.out.println(dto);
		service.updateOne(dto);
		try {
			List<TodoDto> entities = service.selectAll();
			ResponseDto<TodoDto> response = 
					ResponseDto.<TodoDto>builder().data(entities).build();
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			// 예외가 발생할 경우 dto 대신 에러메세지 넣기 
			String error = e.getMessage();
			ResponseDto<TodoDto> response = 
					ResponseDto.<TodoDto>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
}
