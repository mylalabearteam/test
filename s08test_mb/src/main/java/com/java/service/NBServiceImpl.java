package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.NoticeBoard;
import com.java.mapper.NBMapper;
import com.java.mapper.UMapper;

@Service
public class NBServiceImpl implements NBService {

	@Autowired NBMapper nbmapper;
	@Autowired UMapper umapper;
	@Override
	public ArrayList<NoticeBoard> selectAll() {
		ArrayList<NoticeBoard> list = nbmapper.selectAll();
		
		return list;
	}

}
