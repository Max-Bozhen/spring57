package app.controller;

import app.exception.UserAlreadyExistException;
import app.exception.UserNotFoundException;
import app.model.User;
import app.service.IUserService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/users")
public class RestUserController {


  private IUserService userService;

  public RestUserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{userId}")
  public User getUser(@PathVariable Long userId) throws UserNotFoundException {
    Optional<User> u = userService.findById(userId);
    return userService
        .findById(userId)
        .orElseThrow(() -> new UserNotFoundException(userId));
  }

  @GetMapping
  public List<User> getUsers() {
    List<User> userList = new ArrayList<>();
    userService
        .findAll()
        .forEach(userList::add);
    return userList;
  }


  @GetMapping(value = "/sorted/{order}")
  public List<User> getUsersByOrder(@PathVariable String order) {
    String ordLow = order.toLowerCase();
    if (ordLow.equals("asc")) {
      return userService
          .findAllByOrderByFullNameAsc()
          .orElse(Collections.emptyList());
    } else if (ordLow.equals("desc")) {
      return userService
          .findAllByOrderByFullNameDesc()
          .orElse(Collections.emptyList());
    }
    throw new IllegalArgumentException("Order could be 'asc' or 'desc'");
  }

  @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET, consumes={"application/json", "application/xml"})
  public List<User> getUsersPageLimited(@PathVariable Integer page, @PathVariable Integer size) {
    Pageable pageable = PageRequest.of(page, size);
    return userService.findAll(pageable)
        .orElse(Collections.emptyList());
  }

  @PostMapping
  public User addUser(@Valid @RequestBody User user) throws UserAlreadyExistException {
    if (userService.findByUserName(user.getUsername()).isPresent()) {
      throw new UserAlreadyExistException(user.getUsername());
    }

    User newUser = new User();
    newUser.setFullName(user.getFullName());
    newUser.setUsername(user.getUsername());
    newUser.setPhoneNumber(user.getPhoneNumber());
    newUser.setRoles(user.getRoles());
    return userService.save(newUser);
  }


  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable Long userId) {
    userService.deleteById(userId);
  }

  @PutMapping("/{userId}")
  public User editUser(@PathVariable Long userId, @RequestBody User newUser)
      throws UserNotFoundException {
    return userService.findById(userId).
        map(user -> {
          if (newUser.getFullName() != null) {
            user.setFullName(newUser.getFullName());
          }

          if (newUser.getUsername() != null) {
            user.setUsername(newUser.getUsername());
          }

          if (newUser.getRoles() != null) {
            user.setRoles(newUser.getRoles());
          }
          return userService.save(user);
        })
        .orElseThrow(() -> new UserNotFoundException(userId));
  }
}