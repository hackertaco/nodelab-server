package nodelab.backend.ndlab.domain.study.repository;

import nodelab.backend.ndlab.domain.study.Study;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends CrudRepository<Study, Long> {
}
