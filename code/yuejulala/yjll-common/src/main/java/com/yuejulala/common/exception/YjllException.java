package com.yuejulala.common.exception;

import com.yuejulala.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class YjllException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}