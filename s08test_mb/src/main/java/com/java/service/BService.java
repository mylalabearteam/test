package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.dto.Board;
import com.java.dto.Page;

public interface BService {

	HashMap<String, Object> selectAllBoard(Page pageDto);

	HashMap<String, Object> selectOneBoard(int ebno, Page pageDto);

}
