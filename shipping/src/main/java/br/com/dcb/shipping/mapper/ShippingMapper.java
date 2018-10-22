package br.com.dcb.shipping.mapper;

import br.com.dcb.shipping.domain.Shipping;
import br.com.dcb.shipping.domain.request.ShippingRequest;
import br.com.dcb.shipping.domain.response.ShippingResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShippingMapper {

    List<ShippingResponse> shippingToResponses(List<Shipping> shipping);

    @Mappings({
            @Mapping(target = "createdDate",  dateFormat = "dd/MM/yyyy HH:mm"),
            @Mapping(target = "updatedDate",  dateFormat = "dd/MM/yyyy HH:mm")
    })
    ShippingResponse shippingToResponse(Shipping shipping);

    @Mappings({
            @Mapping(target = "id",          ignore = true),
            @Mapping(target = "name",        source = "request.name"),
            @Mapping(target = "cnpj",       source = "request.cnpj"),
            @Mapping(target = "createdAt",   ignore = true),
            @Mapping(target = "updatedAt",   ignore = true),
    })

    Shipping requestToShipping(ShippingRequest request);

    @InheritConfiguration
    void updateFromRequest(@MappingTarget Shipping shipping, ShippingRequest productRequest);
}