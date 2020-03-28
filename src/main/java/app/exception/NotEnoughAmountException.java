package app.exception;

public class NotEnoughAmountException extends RuntimeException {

  private static final String message = "Not enough money on your account! Operation not completed";

  public NotEnoughAmountException() {
    super(message);
  }
}
