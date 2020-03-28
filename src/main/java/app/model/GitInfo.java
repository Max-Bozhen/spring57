package app.model;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@JacksonXmlRootElement()
public class GitInfo {

  private String branch;
  private String buildDateAndTime;

  private String gitCommit;

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public void setBuildDateAndTime(String buildDateAndTime) {
    this.buildDateAndTime = buildDateAndTime;
  }

  public void setGitCommit(String gitCommit) {
    this.gitCommit = gitCommit;
  }

  public String getBranch() {
    return branch;
  }

  public String getBuildDateAndTime() {
    return buildDateAndTime;
  }

  public String getGitCommit() {
    return gitCommit;
  }
}
