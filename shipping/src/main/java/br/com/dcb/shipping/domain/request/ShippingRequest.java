package br.com.dcb.shipping.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShippingRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String shippingType;


}
