package com.bcafinance.sbjdbcexample.repository;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 22/11/2022
@Last Modified on 22/11/2022 13:20
Version 1.0
*/

import com.bcafinance.sbjdbcexample.model.DimProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCDimProductCategoryRepository implements DimProductCategoryRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DimProductCategory dc) {
        return jdbcTemplate.update("INSERT INTO DimProductCategory (ProductCategoryAlternateKey,EnglishProductCategoryName,SpanishProductCategoryName,FrenchProductCategoryName) VALUES(?,?,?,?)",
                new Object[] {dc.getProductCategoryAlternateKey(),
                        dc.getEnglishProductCategoryName(),
                        dc.getSpanishProductCategoryName(),
                        dc.getFrenchProductCategoryName()});
    }

    @Override
    public int update(DimProductCategory dc) {
        return jdbcTemplate.update("UPDATE DimProductCategory SET ProductCategoryAlternateKey=?,EnglishProductCategoryName=?,SpanishProductCategoryName=?,FrenchProductCategoryName=? WHERE ProductCategoryKey=?",
                new Object[] {dc.getProductCategoryAlternateKey(),
                        dc.getEnglishProductCategoryName(),
                        dc.getSpanishProductCategoryName(),
                        dc.getFrenchProductCategoryName(),
                        dc.getProductCategoryKey()});
    }

    @Override
    public DimProductCategory findById(int id) {
        try{
            DimProductCategory dimProductCategory = jdbcTemplate.queryForObject("SELECT * FROM DimProductCategory WHERE ProductCategoryKey=?",
                    BeanPropertyRowMapper.newInstance(DimProductCategory.class), id);

            return dimProductCategory;
        } catch (
                Exception e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM DimProductCategory WHERE ProductCategoryKey=?", id);
    }

    @Override
    public List<DimProductCategory> findAll() {
        return jdbcTemplate.query("SELECT * from DimProductCategory", BeanPropertyRowMapper.newInstance(DimProductCategory.class));
    }

    @Override
    public List<DimProductCategory> findByName(String name) {
        return jdbcTemplate.query("SELECT * from DimProductCategory WHERE EnglishProductCategoryName LIKE CONCAT('%',?,'%')",
                BeanPropertyRowMapper.newInstance(DimProductCategory.class), name);
    }


    @Override
    public int deleteAll() {
        return 0;
    }
}
