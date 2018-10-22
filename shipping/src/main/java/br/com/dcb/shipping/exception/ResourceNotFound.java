package br.com.dcb.shipping.exception;

import lombok.Getter;

@Getter
public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message) {
        super(message);
    }
}
