package com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.controller;

import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.model.Product;
import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.pojo.ProductView;
import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/call-stored-procedure")
    public List<Product> callStoredProcedure(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }
    @GetMapping("/get-all-products")
    public List<ProductView> getAllProducts() {

        return productService.getAllProductsFromView();
    }
}
