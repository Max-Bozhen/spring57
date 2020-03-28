package app.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/changeCompany")
public class ChangeCompanyController {

  private final IUserService userService;
  private final IAccountService accountService;
  private final IPhoneCompanyService phoneCompanyService;

  @GetMapping("{account}")
  public String changeMobileOperator(@PathVariable UserAccount account, Model model) {
    List<String> companyNames = phoneCompanyService.getCompanyNames();
    model.addAttribute("company", account);
    model.addAttribute("companyNames", companyNames);
    return "changeCompany";
  }

  @PostMapping("changeCompany")
  public String changeMobileOperator(@RequestParam String phoneNumber, @RequestParam String userName,
       @RequestParam("accountId") UserAccount account, @RequestParam String company, RedirectAttributes model) {
    List<String> companyNames = phoneCompanyService.getCompanyNames();
    accountService.changeMobileOperator(account, company);
    model.addAttribute("account", account.getUser().getId());
    return "redirect:/changeAcc/{account}";
  }
}
