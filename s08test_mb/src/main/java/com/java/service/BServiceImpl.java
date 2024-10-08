package com.java.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.dto.Page;
import com.java.mapper.BMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BMapper bmapper;

	@Override
	public HashMap<String, Object> selectOneBoard(int bno, Page pageDto) {
	
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Board bdto = bmapper.selectOneBoard(bno);
		Board prev = bmapper.selectPrevBoard(bno);
		Board next = bmapper.selectNextBoard(bno);
		
		map.put("bdto", bdto);
		map.put("prev", prev);
		map.put("next", next);
		
		return map;
	}
	

	@Override
	public HashMap<String, Object> selectAllBoard(Page pageDto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		pageDto = pageMethod(pageDto);
		ArrayList<Board> list = bmapper.selectAllBoard(pageDto);
		map.put("list", list);
		map.put("pageDto", pageDto);
		return map;
	}

	

	public Page pageMethod(Page pageDto) {
		
		//전체게시글 수-142,현재페이지,최대페이지,시작페이지,끝페이지 1-시작,2,3,4,5-현재,6,7,8,9,10-끝  15-최대
		//시작번호,끝나는번호 1-10,11-20,21-30
		//전체게시글 수 저장
		pageDto.setListCount(bmapper.selectListCount());
		// 최대 넘버링페이지
		pageDto.setMaxPage((int)Math.ceil((double)pageDto.getListCount()/10));
		// 시작 넘버링페이지
		pageDto.setStartPage((int)((pageDto.getPage()-1)/10)*10 + 1);
		// 끝 넘버링페이지
		pageDto.setEndPage(pageDto.getStartPage()+10-1);
		// 시작번호
		pageDto.setStartRow((pageDto.getPage()-1)*10+1);
		// 끝나는번호
		pageDto.setEndRow(pageDto.getStartRow()+10-1);
		
		System.out.println(pageDto.getListCount());
		System.out.println(pageDto.getEndPage());
		System.out.println(pageDto.getMaxPage());
		
		return pageDto;
	}
	

}
