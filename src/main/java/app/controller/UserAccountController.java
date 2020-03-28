package app.controller;

import app.model.PhoneCompany;
import app.model.User;
import app.model.UserAccount;
import app.service.IAccountService;
import app.service.IPhoneCompanyService;
import app.service.IUserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserAccountController {

  private final IUserService userService;
  private final IAccountService accountService;
  private final IPhoneCompanyService phoneCompanyService;

  @GetMapping("/changeAcc/{user}")
  public String findAccounts(@PathVariable User user, Model model) {
    List<UserAccount> byUserId = accountService.findByUserId(user.getId());
    model.addAttribute("username", user.getFullName());
    model.addAttribute("accounts", byUserId);
    return "/changeAcc";
  }

}
