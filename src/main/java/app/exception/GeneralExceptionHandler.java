package app.exception;

import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

//  @ExceptionHandler(Exception.class)
//  protected String handleEntityNotFound(
//      Exception ex, Map<String, Object> model) {
//    model.put("message", ex.getMessage());
//    return "uploadStatus";
//  }

  @ExceptionHandler(value
      = { IllegalArgumentException.class, IllegalStateException.class })
  protected String handleConflict(
      Exception ex, Model model) {
    String bodyOfResponse = "This should be application specific";
    model.addAttribute("message", bodyOfResponse);
//    return handleExceptionInternal(ex, bodyOfResponse,
//        new HttpHeaders(), HttpStatus.CONFLICT, request);
    return "uploadStatus";
  }
}
