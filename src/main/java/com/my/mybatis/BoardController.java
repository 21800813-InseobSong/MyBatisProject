package com.my.mybatis;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String addPostOK(BoardVO vo, HttpServletRequest request) throws IOException {
		String fileName = null;
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);
			UUID uuid = UUID.randomUUID();
			fileName = uuid + "." + ext;
			String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload");
			uploadFile.transferTo(new File(saveDir+ "/" + fileName));
		}
		vo.setFilename(fileName);
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
	public String editPostOK(BoardVO vo, MultipartHttpServletRequest request) {
		MultipartFile mf = request.getFile("uploadFile");
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload");
		if(!mf.isEmpty()) {
			String fileName = null;
			String originalFileName = mf.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);
			UUID uuid = UUID.randomUUID();
			fileName = uuid + "." + ext;
			File uploadFile = new File(saveDir + "/" + fileName);
			try {
				mf.transferTo(uploadFile);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			vo.setFilename(fileName);
		}
		int i = boardService.updateBoard(vo);
		System.out.println(vo.getSeq() + " " + vo.getContent() + " " + vo.getFilename());
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
	
	@RequestMapping(value = "board/search", method = RequestMethod.GET)
	public String searchItem(HttpServletRequest httpServletRequest, Model model) {
		String item = httpServletRequest.getParameter("item");
		model.addAttribute("list", boardService.searchContent(item));
		return "board/result";
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
