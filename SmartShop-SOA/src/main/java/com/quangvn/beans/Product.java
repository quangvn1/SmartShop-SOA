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
public class Product {

    private int id;

    private String name;

    private String type;

    private String company;

    private String image;

    private int price;

    private String des;

    private String keyStatus;

    private int oldPrice;

    public Product() {
    }
    
    
}
