package dorres.spring.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import dorres.spring.domain.BootBoard;

public interface DynamicBoardRepository extends CrudRepository<BootBoard, Long>, QuerydslPredicateExecutor<BootBoard>{

}
