package app.controller;

import app.model.Role;
import app.model.User;
import app.service.IUserService;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editUsers")
public class AdminPanelController {

  private final IUserService userService;

  public AdminPanelController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("{user}")
  public String getEditPage(@PathVariable User user, Model model) {
    model.addAttribute("user", user);
    model.addAttribute("roles", Arrays.asList(Role.values()));
    return "editUsers";
  }

  @PostMapping("editUsers")
  public String edit(@RequestParam String username,
      @RequestParam Map<String, String> phones,
      @RequestParam Map<String, String> rolesForm,
      @RequestParam("userId") User user) {
    user.setUsername(username);
    user.getPhoneNumber().clear();
    for(String key : phones.keySet()){
      user.getPhoneNumber().add(phones.get(key));
    }
    Set<String> roles = Arrays.stream(Role.values())
        .map(Role::name)
        .collect(Collectors.toSet());

    user.getRoles().clear();

    for (String key : rolesForm.keySet()) {
      if (roles.contains(key)) {
        user.getRoles().add(Role.valueOf(key));
      }
    }

    userService.save(user);
    return "redirect:/users";
  }
}
