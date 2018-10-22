package br.com.dcb.product.exception;

import lombok.Getter;

@Getter
public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message) {
        super(message);
    }
}
