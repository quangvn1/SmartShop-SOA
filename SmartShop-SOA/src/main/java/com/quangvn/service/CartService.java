/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.service;

import com.quangvn.beans.Account;
import com.quangvn.beans.ProductCart;
import com.quangvn.dao.CartDao;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class CartService {
    
    private CartService() {
    }
    
    public static CartService getInstance() {
        return CartServiceHolder.INSTANCE;
    }
    
    private static class CartServiceHolder {

        private static final CartService INSTANCE = new CartService();
    }
    
    public List<ProductCart> getListProductCart(Account account){
        return CartDao.getInstance().getListProductCart(account);
    }
    
    public void addProductToCart(int idProduct, int number, Account account){
        CartDao.getInstance().addProductToCart(idProduct, number, account);
    }
    
    public boolean checkProductInCart(int idProduct, Account account){
        return CartDao.getInstance().checkProductInCart(idProduct, account);
    }
    
    public void updateNumBerProductInCart(int idProduct, int number, Account account){
        CartDao.getInstance().updateNumBerProductInCart(idProduct, number, account);
    }
    
    public void deleteProductInCart(int idProduct, Account account){
        CartDao.getInstance().deleteProductInCart(idProduct, account);
    }
}
