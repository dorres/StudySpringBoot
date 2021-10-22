package dorres.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(
			properties = {
					"author.name=dorres",
					"author.age=45",
					"author.nation=Korea"})
//classes로 등록되지 않은 클래스는 객체가 생성되지 않는다
//이때 아무것도 선언하지 않는데 BoardController 객체가 생성될것이다 그이유는 @RestController 설정해서 메모리에 올라가는거같음
class PropertiesTest {
	@Autowired
	Environment environment;
	
	@Test
	void testMethod() {
		System.out.println("이름 : " + environment.getProperty("author.name"));
		System.out.println("나이 : " + environment.getProperty("author.age"));
		System.out.println("국가 : " + environment.getProperty("author.nation"));
	}

}