package app.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
@GetMapping("/main")
  public String mainPage(Map<String, Object> model){
  model.put("message", "Welcome to main page");
  return "main";
}
}
