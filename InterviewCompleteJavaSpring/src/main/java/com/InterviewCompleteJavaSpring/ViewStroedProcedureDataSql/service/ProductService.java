package com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.service;

import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.model.Product;
import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.pojo.ProductView;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);


    List<ProductView> getAllProductsFromView();
}
