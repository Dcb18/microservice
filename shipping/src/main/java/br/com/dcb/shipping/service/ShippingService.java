package br.com.dcb.shipping.service;


import br.com.dcb.shipping.domain.Shipping;
import br.com.dcb.shipping.domain.request.ShippingRequest;
import br.com.dcb.shipping.domain.response.ShippingResponse;
import br.com.dcb.shipping.exception.ResourceNotFound;
import br.com.dcb.shipping.mapper.ShippingMapper;
import br.com.dcb.shipping.repository.ShippingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private ShippingMapper mapper;

    @Transactional(readOnly = true)
    public List<ShippingResponse> findAll() {
        log.info("Call method findAll");
        return mapper.shippingToResponses(shippingRepository.findAll());
    }


    @Transactional
    public ShippingResponse save(ShippingRequest shippingRequest) {
        log.info("Save shipping");
        ShippingResponse shippingResponse =
                mapper.shippingToResponse(shippingRepository.save(mapper.requestToShipping(shippingRequest)));
        return shippingResponse;
    }

    @Transactional
    public ShippingResponse upadate(long id, ShippingRequest shippingRequest) {
        log.info("update shipping: " + id);
        findById(id);
        ShippingResponse shippingResponse =
                mapper.shippingToResponse(shippingRepository.save(mapper.requestToShipping(shippingRequest)));
        return shippingResponse;
    }


    @Transactional
    public void delete(Long id) {
        log.info("delete shipping: " + id);
      shippingRepository.deleteById(findById(id).getId());
    }


    @Transactional
    public ShippingResponse findById(long id) {
        log.info("Call find shipping by id: " + id);
        if(!shippingRepository.findById(id).isPresent()) {
            throw new ResourceNotFound("Shipping of id: "+ id + "not exist");
        }
        return mapper.shippingToResponse(shippingRepository.findById(id).get());
    }






    }
