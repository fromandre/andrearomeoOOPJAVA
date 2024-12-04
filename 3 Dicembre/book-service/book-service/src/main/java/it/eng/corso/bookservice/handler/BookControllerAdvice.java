package it.eng.corso.bookservice.handler;


import it.eng.corso.bookservice.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> noDataFoundExceptionHandler(NoDataFoundException e){
        HashMap<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("code_error", "1000");
        body.put("message", "Non è stato trovato l'elemento richiesto");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
