package dorres.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dorres.spring.domain.Board;

public class JPAClient {
//	public static void main(String[] ar) {
//		//EntityManager 생성
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ch04");
//		EntityManager em = emf.createEntityManager();
//		//Transaction 생성
//		EntityTransaction tx = em.getTransaction();
//		try {
//			//  Transaction 시작
//			tx.begin();
//			Board board = new Board();
//			board.setTitle("JAP제목");
//			board.setWriter("관리자");
//			board.setContent("JPA 글 등록 잘 되네요.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			//글등록
//			em.persist(board);
//			
//			// Transaction commit
//			tx.commit();
//		}catch(Exception e) {
//			e.printStackTrace();
//			//Transaction rollback
//			tx.rollback();
//		}finally {
//			emf.close();
//			em.close();
//		}
//	}
//-----------------------------------------	
//	public static void main(String[] ar) {
//		//EntityManager 생성
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ch04");
//		EntityManager em = emf.createEntityManager();
//
//		try {
//			//글 상세 조회
//			Board searchBoard =em.find(Board.class, 33L);
//			System.out.println("---->" + searchBoard.toString());
//		}catch(Exception e) {
//			e.printStackTrace();
//
//		}finally {
//			emf.close();
//			em.close();
//		}
//	}
//-------------------------------------------
	public static void main(String[] ar) {
	//EntityManager 생성
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ch04");
	EntityManager em = emf.createEntityManager();
	//Transaction 생성
	EntityTransaction tx = em.getTransaction();
	try {
		String jpql = "select b from Board b order by b.seq desc";
		List<Board> boardList = em.createQuery(jpql,Board.class).getResultList();
		for(Board brd : boardList) {
			System.out.println("---->" + brd.toString());
		}
	}catch(Exception e) {
		e.printStackTrace();
		//Transaction rollback
		tx.rollback();
	}finally {
		emf.close();
		em.close();
	}
}	
}
