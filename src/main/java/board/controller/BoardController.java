package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.service.BoardService;
import user.bean.UserDTO;

@Controller
@RequestMapping(value="board")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials="true")
public class BoardController {
	
	@Autowired
	private BoardDTO boardDTO;
	
	@Autowired
	private BoardPaging boardPaging;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "write")
	@ResponseBody
	public String write(@RequestParam("subject") String subject, 
			@RequestParam("content") String content,
			@RequestParam("loginId") String id,
			@RequestParam("email") String email,
			@RequestParam("author") String name) {
		System.out.println(name);
	    Map<String, String> map = new HashMap<>();
	    map.put("id", id);
	    map.put("content",content );
	    map.put("subject",subject);
	    map.put("name",name);
	    map.put("email",email);
	  
	    boardService.write(map);

	    return "	글작성이 성공하였습니다";
	}
	
	@GetMapping(value = "list")
	@ResponseBody
	public List<BoardDTO> list(@RequestParam("startNum") int startNum, 
	                            @RequestParam("endNum") int endNum) {
	    
	    List<BoardDTO> boardList = boardService.getBoardList(startNum, endNum);
	    
	    return boardList;
	}
	
	
	@GetMapping(value = "detail")
	@ResponseBody
	public BoardDTO list(@RequestParam("seq") int seq) {
	    BoardDTO boardDTO = boardService.getBoardseq(seq);
	
	    return boardDTO;
	}
}
