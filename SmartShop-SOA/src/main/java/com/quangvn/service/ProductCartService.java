/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.service;

import com.quangvn.beans.Account;
import com.quangvn.beans.ProductCart;
import com.quangvn.dao.ProductCartDao;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class ProductCartService {
    
    private ProductCartService() {
    }
    
    public static ProductCartService getInstance() {
        return ProductCartServiceHolder.INSTANCE;
    }
    
    private static class ProductCartServiceHolder {

        private static final ProductCartService INSTANCE = new ProductCartService();
    }
    
    public List<ProductCart> getListProductCart(Account account){
        return ProductCartDao.getInstance().getListProductCart(account);
    }
}
