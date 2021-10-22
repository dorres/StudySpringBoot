package dorres.spring;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dorres.spring.domain.BootBoard;
import dorres.spring.domain.Member;
import dorres.spring.persistence.BoardRepository;
import dorres.spring.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationmapplingTest {
	@Autowired 
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
//	@Test
//	public void testManyToOneInsert() {
//		Member member1 = new Member();
//		member1.setId("member1");
//		member1.setPassword("member111");
//		member1.setName("둘리");
//		member1.setRole("User");
//		memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member2");
//		member2.setPassword("member222");
//		member2.setName("도넛");
//		member2.setRole("Admin");
//		memberRepo.save(member2);
//		
//		for(int i=0; i<=3; i++) {
//			BootBoard board = new BootBoard();
//			board.setMember(member1);
//			board.setTitle("둘리가 등록한 게시글" + i);
//			board.setContent("둘리가 등록한 게시글 내용" + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//		
//		for(int i=0; i<=3; i++) {
//			BootBoard board = new BootBoard();
//			board.setMember(member2);
//			board.setTitle("도넛이 등록한 게시글" + i);
//			board.setContent("도넛이 등록한 게시글 내용" + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}
	
//	@Test
//	public void testmanyToOneSelect() {
//		BootBoard board = boardRepo.findById(5L).get();
//		System.out.println("[" + board.getSeq() + "번 게시글 정보 ]");
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("내용 : " + board.getContent());
//		System.out.println("작성자 : " + board.getMember().getName());
//		System.out.println("작성자 권한 : " + board.getMember().getRole());
//	}
	
	@Test
	public void testTowWaymapping() {
		Member member = memberRepo.findById("member1").get();
		
		System.out.println("================================");
		System.out.println(member.getName() + "가 저장한 게시글 목록");
		System.out.println("============================");
		List<BootBoard> list = member.getBoardList();
		for(BootBoard board : list) {
			System.out.println(board.toString());
		}
	}
}
