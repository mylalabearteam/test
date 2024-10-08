package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.UserDto;

@Mapper
public interface UserMapper {

	void insertOne(UserDto dto);

	UserDto selectOne(UserDto dto);

}
