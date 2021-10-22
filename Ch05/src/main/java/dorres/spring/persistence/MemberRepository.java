package dorres.spring.persistence;

import org.springframework.data.repository.CrudRepository;

import dorres.spring.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{

}
