/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.factory;

import com.quangvn.beans.ProductCart;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author quangvn
 */
public class ProductCartFactory {

    public static ProductCart createProductCart(ResultSet rs) throws SQLException {
        ProductCart entity = new ProductCart();
        entity.setProduct(ProductFactory.createProduct(rs));
        entity.setAmount(rs.getInt("NUMBER"));
        return entity;
    }
}
