package com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.repo;

import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.pojo.ProductView;

import java.util.List;

public interface ProductViewRepository {
    List<ProductView> findAll();
}
