/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.beans;

import lombok.Data;

/**
 *
 * @author quangvn
 */
@Data
public class Account {

    private String id;

    private String username;

    private String password;

    private String fullname;

    private String gender;

    private String phone;

    private String address;

    private String email;

    private int roleId;

    private String desc;

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    
}
