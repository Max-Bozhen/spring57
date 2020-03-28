package app.exception;

public class SameCompanyException extends RuntimeException {

  public static final String message = "You chose same company";

  public SameCompanyException() {
    super(message);
  }
}
