package edu.mui.cs489.reachnou.questify.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        var apiError = new ApiError(
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                false,
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<ApiError> handleInsufficientAuthenticationException(InsufficientAuthenticationException e, HttpServletRequest request) {
        var apiError = new ApiError(
                request.getRequestURI(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                false,
                e.getMessage(),
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleBadCredentialsException(BadCredentialsException e, HttpServletRequest request) {
        var apiError = new ApiError(
                request.getRequestURI(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                false,
                e.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException e, HttpServletRequest request) {
        var apiError = new ApiError(
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                false,
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        var apiError = new ApiError(
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                false,
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedUserException.class)
    public ResponseEntity<ApiError> handleDuplicatedUserException(ResourceNotFoundException e, HttpServletRequest request) {
        var apiError = new ApiError(
                request.getRequestURI(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                false,
                e.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        var apiError = new ApiError(
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                false,
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception e, HttpServletRequest request) {
        var apiError = new ApiError(
                request.getRequestURI(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                false,
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        // If the body is already a CustomResponse (e.g., in case of error responses), return it as is
//        if (body instanceof APIResponse) {
//            return body;
//        }
//
//        // If the body is not a CustomResponse, wrap it in a CustomResponse with statusCode 200 and "SUCCESS" message
//        APIResponse<Object> apiResponse = new APIResponse<>();
//        apiResponse.setStatusCode(HttpStatus.OK.value());
//        apiResponse.setMessage("SUCCESS");
//        apiResponse.setData(body);
//
//        // Catch ResponseStatusException and set the status code and message from it
//        if (body instanceof ResponseStatusException ex) {
//            apiResponse.setStatusCode(ex.getStatusCode().value());
//            apiResponse.setMessage(ex.getReason());
//        }
//
//        return apiResponse;
//    }
}
