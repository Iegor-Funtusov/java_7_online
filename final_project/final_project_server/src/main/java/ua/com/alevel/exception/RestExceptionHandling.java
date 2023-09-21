package ua.com.alevel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandling {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(value = UserExistsException.class)
    public ResponseEntity<String> handleUserExistsException(UserExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<String> handleEntityNotFoundException(Exception exception) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
//    }
}
