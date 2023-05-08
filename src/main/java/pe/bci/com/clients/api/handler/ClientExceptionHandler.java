package pe.bci.com.clients.api.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.bci.com.clients.api.model.ErrorResponse;
import pe.bci.com.clients.exception.ClienteException;

@Slf4j
@ControllerAdvice
public class ClientExceptionHandler {

  @ExceptionHandler({ClienteException.class})
  @ResponseBody
  public ErrorResponse handleMineException(ClienteException e) {
    return ErrorResponse.builder()
        .message(e.getMessage())
        .build();
  }

}
