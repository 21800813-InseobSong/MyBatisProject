package com.my.mybatis.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public int insertBoard(BoardVO vo) {
		return boardDAO.insertBoard(vo);
	}

	@Override
	public int deleteBoard(int id) {
		return boardDAO.deleteBoard(id);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		System.out.println(vo.getFilename());
		return boardDAO.updateBoard(vo);
	}

	@Override
	public BoardVO getBoard(int seq) {
		return boardDAO.getBoard(seq);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	@Override
	public List<BoardVO> getCategoryBoard(String category){
		return boardDAO.getCategoryBoard(category);
	}
	
	@Override
	public List<BoardVO> searchContent(String item){
		return boardDAO.searchContent(item);
	}

}
