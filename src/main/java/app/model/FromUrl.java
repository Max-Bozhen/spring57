package app.model;

public class FromUrl {

  private String branch;
  private String gitCommit;
  private String buildDateAndTime;

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public String getGitCommit() {
    return gitCommit;
  }

  public void setGitCommit(String gitCommit) {
    this.gitCommit = gitCommit;
  }

  public String getBuildDateAndTime() {
    return buildDateAndTime;
  }

  public void setBuildDateAndTime(String buildDateAndTime) {
    this.buildDateAndTime = buildDateAndTime;
  }
}
