/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.service;

import com.quangvn.beans.Account;
import com.quangvn.beans.Bill;
import com.quangvn.dao.BillDao;
import java.util.Date;

/**
 *
 * @author quangvn
 */
public class BillService {
    
    private BillService() {
    }
    
    public static BillService getInstance() {
        return BillServiceHolder.INSTANCE;
    }
    
    private static class BillServiceHolder {

        private static final BillService INSTANCE = new BillService();
    }
    
    public Bill checkBillExist(Account account){
        return BillDao.getInstance().checkBillExist(account);
    }
    
    public void addBill(Account account, Date createDate){
        BillDao.getInstance().addBill(account, createDate);
    }
}
