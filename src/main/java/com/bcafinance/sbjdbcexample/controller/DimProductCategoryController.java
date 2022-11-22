package com.bcafinance.sbjdbcexample.controller;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 22/11/2022
@Last Modified on 22/11/2022 13:15
Version 1.0
*/

import com.bcafinance.sbjdbcexample.model.DimProductCategory;
import com.bcafinance.sbjdbcexample.repository.DimProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DimProductCategoryController {

    @Autowired
    DimProductCategoryRepository dimProductCategoryRepository;

    @GetMapping("/dimproductcategories/{id}")
    public ResponseEntity<DimProductCategory> getDimProductCategoryById(@PathVariable("id") int id) {
        DimProductCategory dimProductCategory = dimProductCategoryRepository.findById(id);

        if (dimProductCategory != null) {
            return new ResponseEntity<>(dimProductCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/dimproductcategories")
    public ResponseEntity<String> createDimProductCategory(@RequestBody DimProductCategory dimProductCategory) {
        try {
//            public DimCustomer(String firstname, String middlename,
//                    String lastname, String birthdate, String emailaddress, String customeralternatekey) {

            dimProductCategoryRepository.save(new DimProductCategory(dimProductCategory.getProductCategoryAlternateKey(),
                    dimProductCategory.getEnglishProductCategoryName(),
                    dimProductCategory.getSpanishProductCategoryName(),
                    dimProductCategory.getFrenchProductCategoryName()));
//
//            dimProductCategoryRepository.save(dimProductCategory);

            return new ResponseEntity<>("Data berhasil dibuat.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/dimproductcategories/{id}")
    public ResponseEntity<String> updateDimProductCategory(@PathVariable("id") int id, @RequestBody DimProductCategory dimProductCategory) {
        DimProductCategory _dimProductCategory = dimProductCategoryRepository.findById(id);
        if (_dimProductCategory != null) {
            _dimProductCategory.setProductCategoryAlternateKey(dimProductCategory.getProductCategoryAlternateKey());
            _dimProductCategory.setEnglishProductCategoryName(dimProductCategory.getEnglishProductCategoryName());
            _dimProductCategory.setSpanishProductCategoryName(dimProductCategory.getSpanishProductCategoryName());
            _dimProductCategory.setFrenchProductCategoryName(dimProductCategory.getFrenchProductCategoryName());
            _dimProductCategory.setProductCategoryKey(id);

            dimProductCategoryRepository.update(_dimProductCategory);
            return new ResponseEntity<>("Data Berhasil diperbaharui.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tidak dapat menemukan data dengan id=" + id, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/dimproductcategories/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        try {
            int result = dimProductCategoryRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Data dengan id " + id +" Tidak ada !!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data dengan id "+id+" Berhasil di hapus", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data .", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/dimproductcategories/datas/{name}")
    public ResponseEntity<List<DimProductCategory>> findByEnglishName(@PathVariable("name") String name) {
        try {
            List<DimProductCategory> lsDimProductCategory = dimProductCategoryRepository.findByName(name);

            if (lsDimProductCategory.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimProductCategory, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/dimproductcategories")
    public ResponseEntity<List<DimProductCategory>> getAllProductCategory() {
        try {
            List<DimProductCategory> lsDimProductCategory = dimProductCategoryRepository.findAll();

            if (lsDimProductCategory.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimProductCategory, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
