package app.exception;

import java.nio.file.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {



  @ExceptionHandler(IllegalStateException.class)
  protected String handleConflict(
      IllegalStateException ex, Model model) {
    String bodyOfResponse = "Format or structure of document isn't supported";
    model.addAttribute("message", bodyOfResponse);
    return "status";
  }

  @ExceptionHandler(MultipartException.class)
  protected String handleMultipartEx(
      MultipartException ex, Model model) {
    String bodyOfResponse = "Too big file...don't do this again";
    model.addAttribute("message", bodyOfResponse);
    return "status";
  }

  @ExceptionHandler({NotEnoughAmountException.class, SameCompanyException.class})
  protected String handleAmountEx( NotEnoughAmountException ex, Model model){
    model.addAttribute("message", ex.getMessage());
    return "status";
  }
}
