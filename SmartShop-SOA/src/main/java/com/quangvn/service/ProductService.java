/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.service;

import com.quangvn.beans.Product;
import com.quangvn.dao.ProductDao;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class ProductService {
    
    private ProductService() {
    }
    
    public static ProductService getInstance() {
        return ProductServiceHolder.INSTANCE;
    }
    
    private static class ProductServiceHolder {

        private static final ProductService INSTANCE = new ProductService();
    }
    
    public List<Product> getProductByKeyStatus(String keyStatus){
        return ProductDao.getInstance().getProductByKeyStatus(keyStatus);
    }
    
    public List<Product> getListProduct(){
        return ProductDao.getInstance().getListProduct();
    }
    
    public Product getProductById(int id){
        return ProductDao.getInstance().getProductById(id);
    }
}
