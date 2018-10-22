package br.com.dcb.shipping.controller;

import br.com.dcb.shipping.domain.request.ShippingRequest;
import br.com.dcb.shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/shippings")
public class shippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(shippingService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ShippingRequest shippingRequest) {
        return new ResponseEntity<>(shippingService.save(shippingRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable long id, @Valid @RequestBody ShippingRequest shippingRequest) {
        return new ResponseEntity<>(shippingService.upadate(id, shippingRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Long id ) {
        shippingService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(shippingService.findById(id), HttpStatus.OK);
    }



}
