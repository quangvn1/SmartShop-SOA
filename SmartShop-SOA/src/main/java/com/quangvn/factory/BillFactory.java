/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.factory;

import com.quangvn.beans.Account;
import com.quangvn.beans.Bill;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author quangvn
 */
public class BillFactory {

    public static Bill createBill(ResultSet rs) throws SQLException {
        Bill entity = new Bill();
        entity.setId(rs.getInt("ID"));
        entity.setAccount(new Account(rs.getString("USERNAME")));
        entity.setCreateDate(rs.getString("CREATED_DATE"));
        entity.setPayDate(rs.getString("PAY_DATE"));
        entity.setStatus(rs.getInt("STATUS"));
        entity.setTimeShip(rs.getString("TIME_SHIP"));
        entity.setAddressShip(rs.getString("ADDRESS_SHIP"));
        return entity;
    }
}
