package app.service;

import app.model.GitInfo;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GitInfoService {

  private final GitInfo gitInfo;

  public GitInfo getGitInfo(){
    return gitInfo;
  }
//@PostConstruct
//  public void toGitinfo() {
//    try (final Reader reader = new InputStreamReader(resource.getInputStream())) {
//      fromSource = Arrays.asList(
//          gson.fromJson(reader, GitInfo[].class));
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }
//  }
}
