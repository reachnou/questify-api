package edu.mui.cs489.reachnou.questify.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DuplicatedUserException extends RuntimeException{
    public DuplicatedUserException(String msg) {
        super(msg);
    }
}
