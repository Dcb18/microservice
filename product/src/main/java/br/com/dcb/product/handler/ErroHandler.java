package br.com.dcb.product.handler;

import br.com.dcb.product.exception.ResourceNotFound;
import br.com.dcb.product.exception.details.ErroDetails;
import br.com.dcb.product.exception.details.ValidationErroDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErroHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFound rnf) {
       return new ResponseEntity<>(ErroDetails.Builder.newErro().titulo("Resource not found")
                .menssage(rnf.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .time(new Date().getTime())
                .build(), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        return new ResponseEntity<>(ValidationErroDetails.Builder.newErro().titulo("Method argument not valid exception")
                .menssage(ex.getMessage())
                .fildes(fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(",")))
                .fildesMessage(fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(",")))
                .status(status.value())
                .time(new Date().getTime())
                .build(), status);
    }


    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ErroDetails.Builder.newErro().titulo("Internal Error")
                .menssage(ex.getMessage())
                .status(status.value())
                .time(new Date().getTime())
                .build(), headers, status);
    }


}
