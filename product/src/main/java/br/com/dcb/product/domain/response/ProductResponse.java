package br.com.dcb.product.domain.response;

import lombok.Data;

@Data
public class ProductResponse {

    private Long id;

    private String name;

    private String price;

    private String stock;

    private String createdAt;

    private String updatedAt;





}
