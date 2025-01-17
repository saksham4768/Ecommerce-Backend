package com.example.EcomSpringBoot.service;

import com.example.EcomSpringBoot.model.product;
import com.example.EcomSpringBoot.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productrepo;

    public List<product> getAllProducts() {
        return productrepo.findAll();
    }

    public product getProductById(int id) {
        return productrepo.findById(id).orElse(new product(-1));
    }

    public product addOrUpdateProduct(product product, MultipartFile image) throws IOException {

        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImagedata(image.getBytes());

        return productrepo.save(product);
    }

    public void deleteproductById(int id) {
        productrepo.deleteById(id);
    }

    public List<product> searchProductsByKeyword(String keyword) {
        return productrepo.searchProductsByKeyword(keyword);
    }
}
