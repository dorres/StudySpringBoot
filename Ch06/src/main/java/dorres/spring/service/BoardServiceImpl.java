package dorres.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dorres.spring.domain.Board;
import dorres.spring.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	public List<Board> getBooardList(Board board){
		return (List<Board>) boardRepo.findAll();
	}
	
	public void insertBoard(Board board) {
		
	}
	
	public Board getBoard(Board board) {
		return null;
	}
	
	public void updateBoard(Board board) {
		
	}
	
	public void deleteBoard(Board board) {
		
	}
}
