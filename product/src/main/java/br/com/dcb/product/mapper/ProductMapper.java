package br.com.dcb.product.mapper;

import br.com.dcb.product.domain.Product;
import br.com.dcb.product.domain.request.ProductRequest;
import br.com.dcb.product.domain.response.ProductResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductResponse> productsToResponses(List<Product> products);

    @Mappings({
            @Mapping(target = "price",      numberFormat = "R$ #.00"),
            @Mapping(target = "createdAt",  dateFormat = "dd/MM/yyyy HH:mm"),
            @Mapping(target = "updatedAt",  dateFormat = "dd/MM/yyyy HH:mm")
    })
    ProductResponse productToResponse(Product response);

    @Mappings({
            @Mapping(target = "id",          ignore = true),
            @Mapping(target = "name",        source = "request.name"),
            @Mapping(target = "price",       source = "request.price"),
            @Mapping(target = "createdAt",   ignore = true),
            @Mapping(target = "updatedAt",   ignore = true),
    })
    Product requestToProduct(ProductRequest request);

    @InheritConfiguration
    void updateFromRequest(@MappingTarget Product product, ProductRequest productRequest);
}
