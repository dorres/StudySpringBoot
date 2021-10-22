 package dorres.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import dorres.spring.domain.BoardVO;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BoardControllerTest2 {
	@Autowired
	private TestRestTemplate restTemplate;
	//private MockMvc mockMvc; 더이상 서블리스 컨테이너를 모킹하지 않기 때문에  MockMvc 객체를 목업할수 없다
	//그러므로 실제  컨트롤러를 실행해줄 TestRestTemplate객체를 주입해주어야 하며
	//properties설정에서 servlet으로 변경해주어야 실제 톰캣 서버가 구동되어서 실행이 가능하다.!!!!!!!
	
	
	@Test
	public void testHello() throws Exception{
//		mockMvc.perform(get("/hello").param("name","둘리"))
//		.andExpect(status().isOk())
//		.andExpect(content().string("Hello : 둘리"))
//		.andDo(print());
		
		String result = restTemplate.getForObject("/hello  ?name=둘리", String.class);
		assertEquals("Hello : 둘리", result);
	}
	
	@Test
	public void testGetBoard() throws Exception{
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("테스터",  board.getWriter());
	}
}
