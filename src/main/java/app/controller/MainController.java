package app.controller;

import app.model.User;
import app.service.IUserService;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

  private final IUserService iUserService;

  @GetMapping("/")
  public String greeting(Model model) {
    return "greeting";
  }

  @GetMapping("/main")
  public String mainPage(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = iUserService.findByUserName(auth.getName());
    List<User> user1 = Arrays.asList(user);
    model.addAttribute("message", "Welcome to main page");
    model.addAttribute("users", user1);
    return "main";
  }

//  @GetMapping("/main")
//  public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
//    List<User> all = iUserService.findAll();
//
//
//
//    model.addAttribute("messages", all);
//    model.addAttribute("filter", filter);
//
//    return "main";
//  }
}
