package kg.mega.saloon.models.exceptions;

import kg.mega.saloon.models.responses.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler
    public ResponseEntity<?> handleException(ClientException e) {
        return new ResponseEntity(new Response(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
