package dorres.spring.service;

import java.util.List;

import dorres.spring.domain.BoardVO;

public interface BoardService {
	String hello(String name);
	BoardVO getBoard();
	List<BoardVO> getBoardList();
}
