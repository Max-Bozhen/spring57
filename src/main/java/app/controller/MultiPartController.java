package app.controller;

import app.model.User;
import app.service.IUserService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class MultiPartController {

  private final IUserService userService;
  private final Gson gson;

  @GetMapping("/upload")
  public String upload() {
    return "upload";
  }

  @PostMapping("upload")
  public String uploadFile(MultipartFile file, Model model) {
    List<User> users;
    try (final Reader reader = new InputStreamReader(file.getInputStream())) {
      users = Arrays.asList(gson.fromJson(reader, User[].class));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    userService.saveAll(users);
    model.addAttribute("message", "Upload file successfully");
    return "uploadStatus";
  }
}
