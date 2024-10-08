package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.TodoDto;
import com.java.mapper.TodoMapper;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired TodoMapper mapper;
	
	@Override
	public List<TodoDto> selectAll() {
		List<TodoDto> list = mapper.selectAll();
		return list;
	}

	@Override
	public void insertOne(TodoDto dto) {
		mapper.insertOne(dto);
		
	}

	@Override
	public void deleteOne(TodoDto dto) {
		mapper.deleteOne(dto);
		
	}

	@Override
	public void updateOne(TodoDto dto) {
		mapper.updateOne(dto);
		
	}

}
