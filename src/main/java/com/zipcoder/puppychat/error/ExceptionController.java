package com.zipcoder.puppychat.error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> handleNotFound(){
        return new ResponseEntity<>("Oops!! Resource Not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DuplicateDataException.class)
    public ResponseEntity<String> handleDupe(){
        return new ResponseEntity<>("You can't do that because the data is already there", HttpStatus.CONFLICT);
    }

}
