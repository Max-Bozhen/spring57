package app.repository;

import app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByFullName(String fullName);

  Optional<User> findByUsername(String username);

  User findByPhoneNumber(String phoneNumber);

  List<String> findPhoneNumberByFullName(String fullName);
}
