package com.java.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;
import com.java.dto.Comment;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired
	BService boardService;
	
	@RequestMapping("/blist")
	
	public String blist(@PageableDefault(page=0,size=10)
	@SortDefault.SortDefaults({@SortDefault(sort="btop",direction=Sort.Direction.DESC),
	@SortDefault(sort="bgroup",direction=Sort.Direction.DESC),
	@SortDefault(sort="bstep",direction=Sort.Direction.ASC)
	}) Pageable pageable, Model model) {
		//List<Board> list = boardService.selectAll();
		//model.addAttribute("list",list);
		Page<Board> list = boardService.findAll(pageable);
		//List<BoardVo> list2 = list.getContent(); //페이지 정보없이 List만 가져오기
		int nowPage = list.getPageable().getPageNumber()+1; //현재페이지는 0부터 시작이여서 +1
		int maxPage = list.getTotalPages()-1; //마지막 페이지
		int startPage = ((nowPage-1)/10)*10 + 1;
		int endPage = Math.min(startPage+10-1,list.getTotalPages()-1);
		model.addAttribute("list",list);
		model.addAttribute("nowPage",nowPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "board/blist";
	}
	
	@RequestMapping("/bview")
	public String bview(int bno, Model model) {
		Board board = boardService.selectOne(bno);
		model.addAttribute("board",board);
		
		
		List<Comment> comlist = boardService.selectComAll(bno);
		System.out.println("comlistsize"+comlist.size());
		model.addAttribute("comlist",comlist);
		
		// prev
		Board prev = boardService.selectPrev(bno);
		model.addAttribute("prev",prev);
		// next
		Board next = boardService.selectNext(bno);
		model.addAttribute("next",next);
		
		
		return "board/bview";
	}
	
	@GetMapping("/bwrite")
	public String bwrite() {
		return "board/bwrite";
	}
	@PostMapping("/bwrite")
	public String dobwrite(Board board,@RequestPart MultipartFile file) throws Exception {
		
		board.setBfile("");
		if(!file.isEmpty()) { //file.isEmpty()
			String originFileName = file.getOriginalFilename(); //파일이름
			UUID uuid = UUID.randomUUID();
			String uploadFileName = String.format("%s_%s", uuid.toString(),originFileName);
			String fileSaveUrl = "";//"C:/upload/";
			File f = new File(fileSaveUrl+uploadFileName); // /upload/122465414_a.jpg
			file.transferTo(f);
			//변경된 파일이름을 boardVo객체 저장
			board.setBfile(uploadFileName);
		}//if
		
		boardService.insertOne(board);
	
		return "redirect:/board/blist";
	}
	
	@GetMapping("/bmodi")
	public String bmodi(int bno, Model model) {
		Board board = boardService.selectOne(bno);
		model.addAttribute("board",board);
		return "board/bmodi";
	}
	
	@PostMapping("/bmodi")
	public String dobmodi(Board board,@RequestPart MultipartFile file) throws Exception {
		
		
		if(!file.isEmpty()) { //file.isEmpty()
			String originFileName = file.getOriginalFilename(); //파일이름
			UUID uuid = UUID.randomUUID();
			String uploadFileName = String.format("%s_%s", uuid.toString(),originFileName);
			String fileSaveUrl = "";//"C:/upload/";
			File f = new File(fileSaveUrl+uploadFileName); // /upload/122465414_a.jpg
			file.transferTo(f);
			//변경된 파일이름을 boardVo객체 저장
			board.setBfile(uploadFileName);
		}//if
		
		boardService.updateOne(board);
	
		return "redirect:/board/blist";
	}

	
	@GetMapping("/bdelete")
	public String bdelete(int bno) {
		boardService.deleteOne(bno);
		return "redirect:/board/blist";
	}
	
	
	@RequestMapping("/insertComm")
	@ResponseBody
	public Comment incomm(Comment cb) {
		System.out.println(cb.getMember().getId());
		Comment comment = boardService.insertCom(cb);
		return comment;
	}
	

}