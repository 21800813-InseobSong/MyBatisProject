package com.my.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
