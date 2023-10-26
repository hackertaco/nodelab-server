package nodelab.backend.ndlab.domain.user.repository;

import nodelab.backend.ndlab.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
