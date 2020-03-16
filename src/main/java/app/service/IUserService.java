package app.service;

import app.model.User;
import java.util.List;

public interface IUserService {

  User findByFullName(String fullName);

  List<User> findAll();

  User findById(long id);

  List<String> getUsersPhoneNumbers(String fullName);

  User save(User user);

  List<User> saveAll(List<User> users);

  User findByUserName(String userName);
}
