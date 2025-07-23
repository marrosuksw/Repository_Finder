package pl.repo_finder.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(HttpClientErrorException exception) {
        return ResponseEntity.status(404).body(new ErrorResponse(404, "User does not exist."));
    }
    @ExceptionHandler(value = {RestClientException.class})
    public ResponseEntity<ErrorResponse> handleRestClientException(RestClientException exception) {
        return ResponseEntity.status(500).body(new ErrorResponse(500, exception.getMessage()));
    }
}
