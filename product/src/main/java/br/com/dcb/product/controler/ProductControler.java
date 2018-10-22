package br.com.dcb.product.controler;

import br.com.dcb.product.domain.request.ProductRequest;
import br.com.dcb.product.servie.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductControler {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAl() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.save(productRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.upadate(id, productRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Long id ) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }
}
