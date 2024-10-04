package com.api.exception;


import com.api.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionhandeller {

    @ExceptionHandler(NoData.class)
    public ResponseEntity<ErrorDto> resourceNotfound(NoData nd , WebRequest wr)
    {
        ErrorDto rnf = new ErrorDto(nd.getMessage(), new Date(), wr.getDescription(true));

        return new ResponseEntity<>(rnf,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> alreadyexist(Exception e , WebRequest wre)
    {

        ErrorDto aeh = new ErrorDto(e.getMessage(), new Date(), wre.getDescription(false));
//        Date date = new Date();
//        System.out.println(date.getTime());
        return new ResponseEntity<>(aeh,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
