package dorres.spring.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dorres.spring.domain.BootBoard;

public interface BoardRepository extends CrudRepository<BootBoard, Long>{
	List<BootBoard> findByTitle(String searchkeyword);
	
	List<BootBoard>	findByContentContaining(String searchKeyword);
	
	List<BootBoard> findByTitleContainingOrContentContaining(String title, String content);

	List<BootBoard> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	//findByTitleContainingOrderBySeqAsc이렇게 하면 seq로 정렬됨
	List<BootBoard> findByTitleContaining(String searchKeyword, Pageable paging);
	
	//위에 findByTitleContaining메서드를 수정해서 해야하지만 두가지 예시를 다 남겨두고싶어서
	//메서드명을 바꿨으며 이렇게 하면 test클래스에서 pageRequest에서 sort클래스를 사용하면 안됨
	Page<BootBoard> findByTitleContainingOrderBySeqAsc(String searchKeyword, Pageable paging);
	
	//------------------------------------------------------------------------
	//여기서 부터는 QueryAnnontationTest클래스이다.
//	
//	@Query("SELECT b FROM BootBoard b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<BootBoard>	queryAnnotationTest0(String searchkeyword);
//	//'?1' ->첫번째 파라미터 값을 의미한다.
//	
//	
//	@Query("SELECT b FROM BootBoard b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
//	List<BootBoard>	queryAnnotationTest1(@Param("searchKeyword")String searchkeyword);
//	
//	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
//			+ "FROM BootBoard b "
//			+ "WHERE b.title like %?1% "
//			+ "ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest2(@Param("searchKeyword")String searchKeyword);
//
//	
//	@Query(value="select seq, title, writer, create_date "
//			+ "from boot_board where title like '%' || ?1 || '%' "
//			+ "order by seq desc",nativeQuery = true)
//	List<Object[]> queryAnnotationTest3(String searchKeyword);
//	
//	
//	@Query("SELECT b FROM BootBoard b ORDER BY b.seq DESC")
//	List<BootBoard> queryAnnotationTest4(Pageable paging);
}
