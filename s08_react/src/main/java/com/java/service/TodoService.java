package com.java.service;

import java.util.List;

import com.java.dto.TodoDto;

public interface TodoService {

	List<TodoDto> selectAll();

	void insertOne(TodoDto dto);

	void deleteOne(TodoDto dto);

	void updateOne(TodoDto dto);

}
