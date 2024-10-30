package board.service;

import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;

public interface BoardService {

	void write(Map<String, String> map);

	List<BoardDTO> getBoardList(int startNum, int endNum);

	BoardDTO getBoardseq(int seq);

}