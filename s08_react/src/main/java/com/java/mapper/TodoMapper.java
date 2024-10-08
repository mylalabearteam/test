package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.TodoDto;

@Mapper
public interface TodoMapper {

	List<TodoDto> selectAll();

	void insertOne(TodoDto dto);

	void deleteOne(TodoDto dto);

	void updateOne(TodoDto dto);

}
