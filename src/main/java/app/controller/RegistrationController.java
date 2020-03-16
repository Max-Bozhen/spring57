package app.controller;

import app.model.Role;
import app.model.User;
import app.service.IUserService;
import java.util.Collections;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    User userFromDb = iUserService.findByUserName(user.getUserName());

    if (userFromDb != null) {
      model.put("message", "User exists!");
      return "registration";
    }

    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    iUserService.save(user);

    return "redirect:/login";
  }
}
