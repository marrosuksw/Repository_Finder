package pl.repo_finder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(HttpClientErrorException exception) {
        return ResponseEntity.status(404).body(new ErrorResponse(404, "User does not exist."));
    }
}
