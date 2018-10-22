package br.com.dcb.product.servie;

import br.com.dcb.product.domain.request.ProductRequest;
import br.com.dcb.product.domain.response.ProductResponse;
import br.com.dcb.product.exception.ResourceNotFound;
import br.com.dcb.product.mapper.ProductMapper;
import br.com.dcb.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper mapper;

    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {
        log.info("Call method findAll");
        return mapper.productsToResponses(productRepository.findAll());
    }


    @Transactional
    public ProductResponse save(ProductRequest productRequest) {
        log.info("Save shipping");
        ProductResponse shippingResponse =
                mapper.productToResponse(productRepository.save(mapper.requestToProduct(productRequest)));
        return shippingResponse;
    }

    @Transactional
    public ProductResponse upadate(long id, ProductRequest productRequest) {
        log.info("update shipping: " + id);
        findById(id);
        ProductResponse shippingResponse =
                mapper.productToResponse(productRepository.save(mapper.requestToProduct(productRequest)));
        return shippingResponse;
    }


    @Transactional
    public void delete(Long id) {
        log.info("delete shipping: " + id);
        productRepository.deleteById(findById(id).getId());
    }


    @Transactional
    public ProductResponse findById(long id) {
        log.info("Call find shipping by id: " + id);
        if(!productRepository.findById(id).isPresent()) {
            throw new ResourceNotFound("Shipping of id: "+ id + "not exist");
        }
        return mapper.productToResponse(productRepository.findById(id).get());
    }



}
