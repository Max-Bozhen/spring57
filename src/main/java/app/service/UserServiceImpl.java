package app.service;

import app.model.User;
import app.repository.UserRepository;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;
  private final Gson gson;
  private final PasswordEncoder encoder;
  private List<User> users;
  @Value("${usersURL}")
  private Resource usersList;

  @PostConstruct
  public void init() {
    try (final Reader reader = new InputStreamReader(usersList.getInputStream())) {
      users = Arrays.asList(
          gson.fromJson(reader, User[].class));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    users.forEach(user -> user.setPassword(encoder.encode(user.getPassword())));
    userRepository.saveAll(users);
}

  @Override
  public Optional<User> findByFullName(String fullName) {
    return userRepository.findByFullName(fullName);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> findById(long id) {
    return userRepository.findById(id);
  }

  @Override
  public List<String> getUsersPhoneNumbers(String fullName) {
    return userRepository.findPhoneNumberByFullName(fullName);
  }

  @Override
  public User save(User user) {
    userRepository.save(user);
    return user;
  }

  @Override
  public List<User> saveAll(List<User> users) {
    return userRepository.saveAll(users);
  }

  @Override
  public Optional<User> findByUserName(String userName) {
    return userRepository.findByUsername(userName);
  }

  @Override
  public void deleteById(Long userId) {

  }

  @Override
  public Optional<List<User>> findAllByOrderByFullNameAsc() {
    return Optional.empty();
  }

  @Override
  public Optional<List<User>> findAllByOrderByFullNameDesc() {
    return Optional.empty();
  }

  @Override
  public Optional<List<User>> findAll(Pageable pageable) {
    return Optional.empty();
  }

}
