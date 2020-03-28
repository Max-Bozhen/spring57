package app.controller;

import app.model.FromUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequiredArgsConstructor
public class FromUrlController {

  private final Gson gson;
  @GetMapping("/fromURL")
  public String getFromUrl(Model model) throws JsonProcessingException, MalformedURLException {
    URL url = new URL("http://localhost:8090/version");
    try (final Reader reader = new InputStreamReader(url.openStream())) {
      FromUrl url1 = gson.fromJson(reader, FromUrl.class);
      model.addAttribute("fromUrl", url1);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "/fromURL";
  }
}
