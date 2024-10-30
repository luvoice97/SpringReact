package board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

import board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO; 

	@Override
	public void write(Map<String, String> map) {
		boardDAO.write(map);
		boardDAO.refUpdate();
	}

	@Override
	public List<BoardDTO> getBoardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<BoardDTO> list = boardDAO.selectList( map);
		return list;
	}

	@Override
	public BoardDTO getBoardseq(int seq) {
		BoardDTO boardDTO = boardDAO.getBoardseq(seq);
		return boardDTO;
	}

}
