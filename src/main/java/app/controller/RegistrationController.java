package app.controller;

import app.exception.UserAlreadyExistException;
import app.exception.UserNotFoundException;
import app.model.Role;
import app.model.User;
import app.service.IUserService;
import java.util.Collections;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

  private final IUserService iUserService;
  @GetMapping("/registration")
  public String register() {
    return "registration";
  }

  @PostMapping("/registration")
  public String addUser(User user, Map<String, Object> model) {
    User userFromDb = iUserService.findByUserName(user.getUsername()).orElseThrow(() -> new UserAlreadyExistException(user.getUsername()));

    if (userFromDb != null) {
      model.put("message", "User exists!");
      return "registration";
    }

    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    iUserService.save(user);
    model.put("message", "New user registered");
    return "redirect:/login";
  }
}
