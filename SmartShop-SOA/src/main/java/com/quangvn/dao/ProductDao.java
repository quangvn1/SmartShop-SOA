/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import com.quangvn.beans.Product;
import com.quangvn.factory.ProductFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class ProductDao extends BaseDao {

    private ProductDao() {
    }

    public static ProductDao getInstance() {
        return ProductDaoHolder.INSTANCE;
    }

    private static class ProductDaoHolder {

        private static final ProductDao INSTANCE = new ProductDao();
    }

    public List<Product> getProductByKeyStatus(String keyStatus) {
        List<Product> list = new ArrayList<>();
        Connection conn = getConnect();
        try {
            PreparedStatement ps = conn.prepareCall("SELECT *\n"
                    + "FROM product\n"
                    + "WHERE KEY_STATUS=?");
            ps.setString(1, keyStatus);
            ResultSet rs = ps.executeQuery();
            Product entity;
            while (rs.next()) {
                entity = ProductFactory.createProduct(rs);
                list.add(entity);
            }
        } catch (SQLException e) {
            System.out.println("Error to get list product by key status index:" + e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return list;
    }

    public Product getProductById(int id) {
        Connection con = getConnect();
        Product entity = new Product();
        try {
            PreparedStatement ps = con.prepareCall("SELECT * \n"
                    + "FROM product\n"
                    + "WHERE ID =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entity = ProductFactory.createProduct(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error to get product by id index: " + e.getMessage());
            entity = null;
        } finally {
            closeConnection(con);
        }
        return entity;
    }

//    public List<AbstractProduct> getProductByName(String key) {
//        Connection conn = getConnect();
//        List<AbstractProduct> list = new ArrayList<>();
//        Product entity;
//        try {
//            CallableStatement cs = conn.prepareCall("CALL " + SCHEMA_NAME + ".getProductByName(?)");
//            cs.setString(1, key);
//            ResultSet rs = cs.executeQuery();
//            while (rs.next()) {
//                entity = ProductFactory.createProduct(rs);
//                list.add(entity);
//            }
//            return list;
//        } catch (Exception e) {
//            System.out.println("Error to get product by name: " + e.getMessage());
//        } finally {
//            closeConnection(conn);
//        }
//        return new ArrayList<AbstractProduct>((Collection<? extends AbstractProduct>) new NullProduct());
//    }
//
    public List<Product> getListProduct() {
        List<Product> list = new ArrayList<>();
        Connection conn = getConnect();
        try {
            PreparedStatement ps = conn.prepareCall("SELECT * \n"
                    + "FROM product\n"
                    + "ORDER BY PRICE ASC");
            ResultSet rs = ps.executeQuery();
            Product entity;
            while (rs.next()) {
                entity = ProductFactory.createProduct(rs);
                list.add(entity);
            }
        } catch (SQLException e) {
            System.out.println("Error to get list product:" + e.getMessage());
            list = null;
        } finally {
            closeConnection(conn);
        }
        return list;
    }
}
