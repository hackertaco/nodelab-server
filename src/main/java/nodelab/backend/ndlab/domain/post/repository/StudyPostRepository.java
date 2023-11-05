package nodelab.backend.ndlab.domain.post.repository;

import nodelab.backend.ndlab.domain.post.StudyPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPostRepository extends CrudRepository<StudyPost, Long> {
}
