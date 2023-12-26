package com.facebooked.demofacebooked.ViewStroedProcedureDataSql.service;

import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.model.Product;
import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.pojo.ProductView;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);


    List<ProductView> getAllProductsFromView();
}
