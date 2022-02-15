package sid.usermanagement.model.repository;

import sid.usermanagement.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
