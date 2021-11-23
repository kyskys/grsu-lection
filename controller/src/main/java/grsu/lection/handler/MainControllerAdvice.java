package grsu.lection.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@Slf4j
public class MainControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity onConstraintViolationException(ConstraintViolationException e) {
        log.error("Constraint violation", e);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity onUserNotFoundException(BadCredentialsException exception) {
        log.error("Bad credentials", exception);
        return ResponseEntity.notFound().build();
    }
}
