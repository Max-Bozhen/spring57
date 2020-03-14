package app.repository;

import app.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByFullName(String fullName);

  User findByPhoneNumber(String phoneNumber);

  List<String> findPhoneNumberByFullName(String fullName);
}
