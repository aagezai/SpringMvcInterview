package com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.repo;// ProductRepository.java

import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Procedure(name = "GetProductsByPriceRange")
    List<Product> getProductsByPriceRange(BigDecimal minPrice,BigDecimal maxPrice);
}
