package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.UserDto;
import com.java.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserMapper umapper;
	@Override
	public void insertOne(UserDto dto) {
		umapper.insertOne(dto);
		
	}
	@Override
	public UserDto selectOne(UserDto dto) {
		UserDto user = umapper.selectOne(dto);
		return user;
	}

}
