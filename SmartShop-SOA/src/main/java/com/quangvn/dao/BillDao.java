/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import com.quangvn.beans.Account;
import com.quangvn.beans.Bill;
import com.quangvn.factory.BillFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author quangvn
 */
public class BillDao extends BaseDao {

    private BillDao() {
    }

    public static BillDao getInstance() {
        return BiiDaoHolder.INSTANCE;
    }

    private static class BiiDaoHolder {

        private static final BillDao INSTANCE = new BillDao();
    }

    public Bill checkBillExist(Account account) {
        Bill bill = new Bill();
        Connection conn = getConnect();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT *\n"
                    + "FROM bill\n"
                    + "WHERE USERNAME =?");
            ps.setString(1, account.getUsername());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bill = BillFactory.createBill(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error to check bill exist: " + e.getMessage());
            bill = null;
        } finally {
            closeConnection(conn);
        }
        return bill;
    }

    public void addBill(Account account, Date createDate) {
        Connection conn = getConnect();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO bill(USERNAME,CREATED_DATE,STATUS)\n"
                    + "VALUE(?,?,?)");
            ps.setString(1, account.getUsername());
            ps.setTimestamp(2, getTime(createDate));
            ps.setInt(3, 0);
        } catch (SQLException e) {
            System.out.println("Error to add bill: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
}
