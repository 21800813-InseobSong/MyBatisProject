package com.my.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.mybatis.board.BoardVO;
import com.my.mybatis.board.BoardService;
import com.my.mybatis.board.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Autowired
	BoardServiceImpl boardService;
	
	@RequestMapping(value = "board/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list", boardService.getBoardList());
		return "board/view";
	}
	
	@RequestMapping(value = "/board/add", method = RequestMethod.GET)
	public String addPost() {
		return "board/addpostform";
	}
	
	@RequestMapping(value="board/addok", method=RequestMethod.POST)
	public String addPostOK(BoardVO vo) {
		int i = boardService.insertBoard(vo);
		if(i==0)
			System.out.println("데이터 추가 실패");
		else
			System.out.println("데이터 추가 성공!!");
		return "redirect:list";
	}
	
	@RequestMapping(value="board/editform/{id}", method=RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("boardVO", boardVO);
		return "board/editform";
	}
	
	@RequestMapping(value="board/editok", method=RequestMethod.POST)
	public String editPostOK(BoardVO vo) {
		int i = boardService.updateBoard(vo);
		System.out.println(vo.getSeq() + " " + vo.getContent());
		if(i==0)
			System.out.println("데이터 수정 실패");
		else
			System.out.println("데이터 수정 성공!!");
		return "redirect:list";
	}
	
	@RequestMapping(value="board/deleteok/{id}", method=RequestMethod.GET)
	public String deletePost(@PathVariable("id") int id, Model model) {
		int i = boardService.deleteBoard(id);
		if(i==0)
			System.out.println("데이터 삭제 실패");
		else
			System.out.println("데이터 삭제 성공!!");
		return "redirect:../list";
	}
	
	@RequestMapping(value = "/board/life", method = RequestMethod.GET)
	public String getLifeList(Model model) {
		model.addAttribute("list", boardService.getCategoryBoard("life"));
		return "board/view";
	}
	
	@RequestMapping(value = "/board/study", method = RequestMethod.GET)
	public String getStudyList(Model model) {
		model.addAttribute("list", boardService.getCategoryBoard("study"));
		return "board/view";
	}
	
	@RequestMapping(value = "/board/travel", method = RequestMethod.GET)
	public String getTravelList(Model model) {
		model.addAttribute("list", boardService.getCategoryBoard("travel"));
		return "board/view";
	}
}
