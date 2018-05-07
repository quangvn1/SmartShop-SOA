/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.factory;

import com.quangvn.beans.Account;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author VAN
 */
public class AccountFactory {

    public static Account getAccount(ResultSet rs) throws SQLException {
        Account entity = new Account();
        entity.setUsername(rs.getString("USERNAME"));
        entity.setPassword(rs.getString("PASSWORD"));
        entity.setFullname(rs.getString("FULLNAME"));
        entity.setGender(rs.getString("GENDER"));
        entity.setPhone(rs.getString("PHONE"));
        entity.setAddress(rs.getString("ADDRESS"));
        entity.setEmail(rs.getString("EMAIL"));
        entity.setDesc(rs.getString("DESC"));
        entity.setRoleId(rs.getInt("ROLEID"));
        return entity;
    }

}
