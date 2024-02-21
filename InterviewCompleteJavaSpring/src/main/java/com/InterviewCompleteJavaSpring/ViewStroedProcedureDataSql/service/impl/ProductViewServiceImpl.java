package com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.service.impl;

import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.pojo.ProductView;
import com.InterviewCompleteJavaSpring.ViewStroedProcedureDataSql.repo.ProductViewRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductViewServiceImpl implements ProductViewRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductViewServiceImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductView> findAll() {
        String sql = "SELECT * FROM productview";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductView.class));
    }
}
