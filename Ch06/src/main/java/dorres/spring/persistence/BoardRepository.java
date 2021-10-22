package dorres.spring.persistence;

import org.springframework.data.repository.CrudRepository;

import dorres.spring.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
