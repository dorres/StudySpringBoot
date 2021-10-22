package dorres.spring.service;

import java.util.List;

import dorres.spring.domain.Board;

public interface BoardService {

	List<Board> getBooardList(Board board);

	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}