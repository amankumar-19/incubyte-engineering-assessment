package com.acme.salary.exception;
import com.acme.salary.dto.ApiError;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime; import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler{
 @ExceptionHandler(EmployeeNotFoundException.class) ResponseEntity<ApiError> nf(EmployeeNotFoundException e){return build(HttpStatus.NOT_FOUND,e.getMessage(),Map.of());}
 @ExceptionHandler(DuplicateEmployeeException.class) ResponseEntity<ApiError> dup(DuplicateEmployeeException e){return build(HttpStatus.CONFLICT,e.getMessage(),Map.of());}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<ApiError> val(MethodArgumentNotValidException e){
  Map<String,String> f=new LinkedHashMap<>(); e.getBindingResult().getFieldErrors().forEach(x->f.putIfAbsent(x.getField(),x.getDefaultMessage()));
  return build(HttpStatus.BAD_REQUEST,"Validation failed",f);}
 @ExceptionHandler(Exception.class) ResponseEntity<ApiError> other(Exception e){return build(HttpStatus.INTERNAL_SERVER_ERROR,"Unexpected server error",Map.of());}
 private ResponseEntity<ApiError> build(HttpStatus s,String m,Map<String,String> f){return ResponseEntity.status(s).body(new ApiError(LocalDateTime.now(),s.value(),s.getReasonPhrase(),m,f));}
}
