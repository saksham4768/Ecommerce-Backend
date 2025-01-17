package com.example.EcomSpringBoot.controller;

import com.example.EcomSpringBoot.model.product;
import com.example.EcomSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:5173")
public class productController {

    @Autowired
    private ProductService productService;
    @GetMapping({"/products","/"})
    public ResponseEntity<List<product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<product> getProductById(@PathVariable int id){
        product Product = productService.getProductById(id);
        if(Product.getId() < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addprouct(@RequestPart product product, @RequestPart MultipartFile imageFile) {
        product saveProduct = null;
        try {
            saveProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        product product = productService.getProductById(productId);

        if(product.getId() < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.getImagedata(), HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateTheProductData(@PathVariable int id, @RequestPart product product, @RequestPart MultipartFile imageFile){
        product updatedProduct = null;
        try {
            updatedProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        product Product = productService.getProductById(id);
        if(Product != null){
            productService.deleteproductById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<product>> searchproducts(@RequestParam String Keyword){
        List<product>Products = productService.searchProductsByKeyword(Keyword);
        return new ResponseEntity<>(Products, HttpStatus.OK);
    }
}
