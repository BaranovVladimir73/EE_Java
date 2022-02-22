package ru.gb.javarest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.javarest.entity.Product;
import ru.gb.javarest.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class RestCartController {

    private final ProductService productService;

    @GetMapping
    public List<Product> showAllProductFromCart(){
        return productService.showAllProductFromCart();
    }

    @GetMapping("/add/{productId}")
    public ResponseEntity<?> addProductFromRepositoryToCart(@PathVariable("productId") Long id){

        if (id != null){
            Product product = productService.findById(id);
            if (product != null) {
                productService.addProductToCart(product);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProductFromCart(@PathVariable("productId") int id){
        productService.deleteProductFromCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
