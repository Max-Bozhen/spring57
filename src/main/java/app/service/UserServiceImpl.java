package app.service;

import app.model.User;
import app.repository.UserRepository;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;
  private final Gson gson;

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
    userRepository.saveAll(users);
}

  @Override
  public User findByFullName(String fullName) {
    return userRepository.findByFullName(fullName);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findById(long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User with " + id + " not found"));
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
  public User findByUserName(String userName) {
    return userRepository.findByUsername(userName);
  }

}
