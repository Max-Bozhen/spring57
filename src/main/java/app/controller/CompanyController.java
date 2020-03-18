package app.controller;

import app.service.IPhoneCompanyService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CompanyController {

  private final IPhoneCompanyService companyService;

  @GetMapping("/companies")
  public String showCompanies(Model model) {
    model.addAttribute("companies", companyService.findAll());
    return "companies";
  }
}
