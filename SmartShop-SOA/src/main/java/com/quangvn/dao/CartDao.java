/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import com.quangvn.beans.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author quangvn
 */
public class CartDao extends BaseDao {

    private CartDao() {
    }

    public static CartDao getInstance() {
        return CartDaoHolder.INSTANCE;
    }

    private static class CartDaoHolder {

        private static final CartDao INSTANCE = new CartDao();
    }

    public void addProductToCart(int idProduct, int number, Account account) {
        Connection conn = getConnect();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO cart(ID_PRODUCT,NUMBER,ID_BILL)\n"
                    + "VALUE(?,?, (SELECT ID \n"
                    + "FROM bill \n"
                    + "WHERE USERNAME=?))");
            ps.setInt(1, idProduct);
            ps.setInt(2, number);
            ps.setString(3, account.getUsername());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error to add product to cart: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public boolean checkProductInCart(int idProduct, Account account) {
        Connection conn = getConnect();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT *\n"
                    + "FROM cart\n"
                    + "INNER JOIN bill\n"
                    + "ON cart.ID_BILL=bill.ID\n"
                    + "WHERE cart.ID_PRODUCT=?\n"
                    + "AND bill.USERNAME=?\n"
                    + "AND bill.STATUS=?");
            ps.setInt(1, idProduct);
            ps.setString(2, account.getUsername());
            ps.setInt(3, 0);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error to check product in cart: " + e.getMessage());
            return false;
        } finally {
            closeConnection(conn);
        }
        return false;
    }

    public void updateNumBerProductInCart(int idProduct, int number, Account account) {
        Connection conn = getConnect();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE cart\n"
                    + "SET NUMBER=NUMBER+?\n"
                    + "WHERE ID_PRODUCT=?\n"
                    + "AND ID_BILL=(SELECT ID FROM bill WHERE USERNAME=?)");
            ps.setInt(1, number);
            ps.setInt(2, idProduct);
            ps.setString(3, account.getUsername());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error to update number product in cart: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
}
