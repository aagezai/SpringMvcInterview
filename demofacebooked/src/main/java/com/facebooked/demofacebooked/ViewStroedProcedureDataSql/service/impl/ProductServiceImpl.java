package com.facebooked.demofacebooked.ViewStroedProcedureDataSql.service.impl;

import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.model.Product;
import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.model.ProductView;
import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.repo.ProductRepository;
import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.repo.ProductViewRepository;
import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private final ProductViewRepository productViewRepository;

    @Autowired
    public ProductServiceImpl(ProductViewRepository productViewRepository,ProductRepository productRepository) {
        this.productViewRepository = productViewRepository;
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.getProductsByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<ProductView> getAllProductsFromView() {

        return productViewRepository.findAll();
    }
}
