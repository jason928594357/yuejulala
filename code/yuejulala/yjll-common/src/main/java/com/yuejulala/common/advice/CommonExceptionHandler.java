package com.yuejulala.common.advice;

import com.yuejulala.common.enums.ExceptionEnum;
import com.yuejulala.common.exception.YjllException;
import com.yuejulala.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(YjllException.class)
    public ResponseEntity<ExceptionResult> handleException(YjllException e) {
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }
}