package dorres.spring;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import dorres.spring.domain.BootBoard;
import dorres.spring.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
//	@before
//	public void dataPrepare() {
//		for(int i=0; i<=200; i++) {
//			BootBoard board = new BootBoard();
//			board.setTitle("테스트 제목" + i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용:" + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			boardRepo.save(board);
//		}
//	}
//	//before가 왜 안먹는지 모르겠지만 여튼 test메서드는 실행가능
//	@Test
//	public void testFindByTitle() {
//		List<BootBoard> boardList = boardRepo.findByTitle("첫 뻔째 게시글");
//		//실제 잇는 데이터값을 이용했음
//		
//		System.out.println("검색 결과");
//		for(BootBoard board : boardList) {
//			System.out.println("---->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByContentContaining() {
//		List<BootBoard> boardList = boardRepo.findByContentContaining("17");
//		System.out.println("검색 결과");
//		for(BootBoard board : boardList) {
//			System.out.println("---->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<BootBoard> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");
//		System.out.println("검색 결과");
//		for(BootBoard board : boardList) {
//			System.out.println("---->" +board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<BootBoard> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		System.out.println("검색 결과");
//		for(BootBoard board : boardList) {
//			System.out.println("---->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5);
//		List<BootBoard> boardList = boardRepo.findByTitleContaining("제목", paging);
//		System.out.println("검색 결과");
//		for(BootBoard board : boardList) {
//			System.out.println("=---->" + board.toString()); 
//		}
//	}
	
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5,Sort.Direction.DESC, "seq");
//		List<BootBoard> boardList = boardRepo.findByTitleContaining("제목", paging);
//		System.out.println("검색 결과");
//		for(BootBoard board : boardList) {
//			System.out.println("=---->" + board.toString()); 
//		}
//	}
	
	@Test
	public void testFindByTitleContainingOrderBySeqAsc() {
		Pageable paging = PageRequest.of(0, 5,Sort.Direction.DESC, "seq");
		
		Page<BootBoard> pageInfo = boardRepo.findByTitleContainingOrderBySeqAsc("제목", paging);
		
		System.out.println("PAGE SIZE : " + pageInfo.getSize());
		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
		System.out.println("NEXT : " + pageInfo.nextPageable());
		
		List<BootBoard> boardList = pageInfo.getContent();
		System.out.println("검색결과");
		for(BootBoard board : boardList) {
			System.out.println("---->" + board.toString());
		}
	}
}
