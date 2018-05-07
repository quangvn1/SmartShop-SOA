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
public class ProductCart {
    
    private int id;
    
    private Product product;
    
    private int amount;

    public ProductCart() {
    }
    
}
