package app.controller;

import app.model.GitInfo;
import app.service.GitInfoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GitInfoController {

  private final GitInfoService infoService;

  @GetMapping("/version")
  public Map<String,GitInfo> gitInfo() {
   GitInfo gitInfo = infoService.getGitInfo();
    Map<String, GitInfo> git = new HashMap<>();
    git.put(gitInfo.getBranch(), gitInfo);
    return git;
  }
}
