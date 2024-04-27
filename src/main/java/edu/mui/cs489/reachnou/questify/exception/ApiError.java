package edu.mui.cs489.reachnou.questify.exception;

import java.time.LocalDateTime;

public record ApiError(
        String path,
        String error,
        boolean success,
        String message,
        int statusCode,
        LocalDateTime localDateTime
) {
}
