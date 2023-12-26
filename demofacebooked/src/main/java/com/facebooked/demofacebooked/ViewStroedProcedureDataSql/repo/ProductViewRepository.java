package com.facebooked.demofacebooked.ViewStroedProcedureDataSql.repo;

import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.pojo.ProductView;

import java.util.List;

public interface ProductViewRepository {
    List<ProductView> findAll();
}
