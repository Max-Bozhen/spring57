package app.config;

import app.model.GitInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:git.properties", "classpath:application.properties"})
public class GitInfoConfig {
//
//  @Value("${artifactId}")
//  private String artifactId;
  @Value("${${artifactId}.branch}")
  private String branch;
  @Value("${${artifactId}.build.time}")
  private String buildDateAndTime;
  @Value("${${artifactId}.commit.message.full}")
  private String gitCommit;
  @Bean
  GitInfo getGitInfo(){
//    System.out.println(artifactId);
    GitInfo gitInfo = new GitInfo();
    gitInfo.setBranch(branch);
    gitInfo.setBuildDateAndTime(buildDateAndTime);
    gitInfo.setGitCommit(gitCommit);
    return gitInfo;
  }
}
