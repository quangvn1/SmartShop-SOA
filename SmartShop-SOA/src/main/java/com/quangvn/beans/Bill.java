/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.beans;

import java.util.List;
import lombok.Data;

/**
 *
 * @author quangvn
 */
@Data
public class Bill {
    
    private int id;
    
    private Account account;
    
    private List<ProductCart> listProductCart;
    
    private String createDate;
    
    private String payDate;
    
    private int status;
    
    private String timeShip;
    
    private String addressShip;

    public Bill() {
    }
    
}
