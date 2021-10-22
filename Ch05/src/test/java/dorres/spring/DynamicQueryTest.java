package dorres.spring;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;

import dorres.spring.domain.BootBoard;
import dorres.spring.domain.QBootBoard;
import dorres.spring.persistence.DynamicBoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {

	@Autowired
	private DynamicBoardRepository boardRepo;
	
	@Test
	public void testDynamicQuery() {
		String searchCondition = "TITLE";
		String searchKeyword = "테스트 제목10";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBootBoard qboard = QBootBoard.bootBoard;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		}else if(searchCondition.equals("CONTNET")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0,5);
		Page<BootBoard> boardList = boardRepo.findAll(builder,paging);
		
		System.out.println("검색 결과");
		for(BootBoard board : boardList) {
			System.out.println("---->" + board.toString());
		}
	}
}
