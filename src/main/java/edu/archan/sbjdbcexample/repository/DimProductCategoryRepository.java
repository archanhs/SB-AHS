package edu.archan.sbjdbcexample.repository;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 22/11/2022
@Last Modified on 22/11/2022 13:17
Version 1.0
*/


import edu.archan.sbjdbcexample.model.DimProductCategory;

import java.util.List;

public interface DimProductCategoryRepository {


    int save(DimProductCategory dc);
    int update(DimProductCategory dc);
    DimProductCategory findById(int id);

    /*
        Delete maksud nya adalah mengupdate kolom flag status dirubah menjadi 0
     */
    int deleteById(int id);
    List<DimProductCategory> findAll();

    List<DimProductCategory> findByName(String name);
    int deleteAll();
}
