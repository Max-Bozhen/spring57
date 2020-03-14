package app.controller;

import app.model.PhoneCompany;
import app.model.User;
import app.service.IPhoneCompanyService;
import app.service.IUserService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final IUserService userService;
  private final IPhoneCompanyService companyService;

  @GetMapping("/usersList")
  public ModelAndView usersList(Map<String, Object> model) {
    List<User> all = userService.findAll();
    List<PhoneCompany> companyList = companyService.findAll();

    model.put("users", all);
    model.put("companies", companyList);

    return new ModelAndView(new PDFView(), model);
  }

  @GetMapping("/users")
  public String showUsers(Map<String, Object> model) {
    model.put("users", userService.findAll());
    return "users";
  }
}