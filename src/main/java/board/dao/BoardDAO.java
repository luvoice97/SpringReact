package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import board.bean.BoardDTO;

@Mapper
public interface BoardDAO {

	void write(Map<String, String> map);

	List<BoardDTO> selectList(Map<String, Integer> map);

	void refUpdate();

	BoardDTO getBoardseq(int seq);

}
