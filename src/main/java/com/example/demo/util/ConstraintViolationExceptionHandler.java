package com.example.demo.util;


import org.apache.tomcat.util.buf.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ConstraintViolationExceptionHandler {
    public static String getMessage(ConstraintViolationException e){
        List<String> msgList = new ArrayList<>();
        for(ConstraintViolation<?> constraintViolation : e.getConstraintViolations()){
            msgList.add(constraintViolation.getMessage());
        }
        return msgList.toString();
    }
}
