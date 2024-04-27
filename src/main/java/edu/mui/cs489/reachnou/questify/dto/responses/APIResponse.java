package edu.mui.cs489.reachnou.questify.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse  <T> {
    private int statusCode;
    private String message;
    private T data;
}
