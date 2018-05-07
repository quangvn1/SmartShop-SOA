/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import com.quangvn.beans.Account;
import com.quangvn.beans.ProductCart;
import com.quangvn.factory.ProductCartFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class ProductCartDao extends BaseDao {

    private ProductCartDao() {
    }

    public static ProductCartDao getInstance() {
        return CartDaoHolder.INSTANCE;
    }

    private static class CartDaoHolder {

        private static final ProductCartDao INSTANCE = new ProductCartDao();
    }

    public List<ProductCart> getListProductCart(Account account) {
        List<ProductCart> list = new ArrayList<>();
        Connection conn = getConnect();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * \n"
                    + "FROM product\n"
                    + "INNER JOIN cart\n"
                    + "ON cart.ID_PRODUCT = product.ID\n"
                    + "INNER JOIN bill\n"
                    + "ON bill.ID = cart.ID_BILL\n"
                    + "WHERE bill.USERNAME=?");
            ps.setString(1, account.getUsername());
            ResultSet rs = ps.executeQuery();
            ProductCart entity;
            while (rs.next()) {
                entity = ProductCartFactory.createProductCart(rs);
                list.add(entity);
            }
        } catch (SQLException e) {
            System.out.println("Error to get product in cart: " + e.getMessage());
            list = null;
        } finally {
            closeConnection(conn);
        }
        return list;
    }
}
