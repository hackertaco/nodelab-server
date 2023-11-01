package nodelab.backend.ndlab.domain.study.repository;

import nodelab.backend.ndlab.domain.study.UserStudy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStudyRepository extends CrudRepository<UserStudy, Long> {

}
