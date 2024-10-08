package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;
import com.java.dto.Page;

@Mapper
public interface BMapper {

	ArrayList<Board> selectAllBoard(Page pageDto);

	int selectListCount();

	Board selectOneBoard(int ebno);

	Board selectPrevBoard(int ebno);

	Board selectNextBoard(int ebno);

	
}
