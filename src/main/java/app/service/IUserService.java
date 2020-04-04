package app.service;

import app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

public interface IUserService {

  Optional<User> findByFullName(String fullName);

  List<User> findAll();

  Optional<User> findById(long id);

  List<String> getUsersPhoneNumbers(String fullName);

  User save(User user);

  List<User> saveAll(List<User> users);

  Optional<User> findByUserName(String userName);

  void deleteById(Long userId);

  Optional<List<User>> findAllByOrderByFullNameAsc();

  Optional<List<User>> findAllByOrderByFullNameDesc();

  Optional<List<User>> findAll(Pageable pageable);
}
