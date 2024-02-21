package com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.service.impl;

import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.model.Product;
import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.pojo.ProductView;
import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.repo.ProductRepository;
import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.repo.ProductViewRepository;
import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.getProductsByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<ProductView> getAllProductsFromView() {

        return productViewRepository.findAll();
    }
}
