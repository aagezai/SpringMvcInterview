package com.facebooked.demofacebooked.ViewStroedProcedureDataSql.repo;

import com.facebooked.demofacebooked.ViewStroedProcedureDataSql.model.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductViewRepository extends JpaRepository<ProductView, Long> {

    // You can add custom query methods if needed

}
