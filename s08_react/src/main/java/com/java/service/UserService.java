package com.java.service;

import com.java.dto.UserDto;

public interface UserService {

	void insertOne(UserDto dto);

	UserDto selectOne(UserDto dto);
	

}
