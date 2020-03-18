package app.controller;

import app.model.User;
import app.service.IUserService;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editProfile")
public class EditUserProfileController {

  private final IUserService userService;

  public EditUserProfileController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("{user}")
  public String getEditPage(@PathVariable User user, Model model) {
    model.addAttribute("user", user);
    return "editProfile";
  }

  @PostMapping("editProfile")
  public String edit(@RequestParam String username,
      @RequestParam Map<String, String> form,
      @RequestParam("userId") User user){
    user.setUsername(username);



    userService.save(user);
    return "redirect:/main";
  }

}
