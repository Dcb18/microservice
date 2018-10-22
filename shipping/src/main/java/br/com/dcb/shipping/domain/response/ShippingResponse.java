package br.com.dcb.shipping.domain.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShippingResponse {

    private Long id;

    private String name;

    private String cnpj;

    private  String shippingType;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;


}
