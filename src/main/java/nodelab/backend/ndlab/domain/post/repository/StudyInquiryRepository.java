package nodelab.backend.ndlab.domain.post.repository;

import nodelab.backend.ndlab.domain.post.StudyInquery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyInquiryRepository extends CrudRepository<StudyInquery, Long> {
}
