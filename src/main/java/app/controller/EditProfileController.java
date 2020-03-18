package app.controller;

import app.model.User;
import app.service.IUserService;
import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editProfile")
public class EditProfileController {

  private final IUserService iUserService;

  public EditProfileController(IUserService iUserService) {
    this.iUserService = iUserService;
  }

  @GetMapping("{user}")
  public String getEditPage(@PathVariable User user, Model model) {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    User byUserName = iUserService.findByUserName(authentication.getName());
    model.addAttribute("user", user);
    return "editProfile";
  }

  @PostMapping("editProfile")
  public String editProfile(Model model) {
    return "editProfile";
  }
}
