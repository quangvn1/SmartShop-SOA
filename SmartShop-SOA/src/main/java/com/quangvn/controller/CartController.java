/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.beans.Account;
import com.quangvn.beans.Bill;
import com.quangvn.beans.ProductCart;
import com.quangvn.service.CartService;
import com.quangvn.service.BillService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author quangvn
 */
@Controller
public class CartController {

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getProductInCart(Model model, HttpSession session) {
        List<ProductCart> list = (List<ProductCart>) session.getAttribute("productcart");
        int amount = 0;
        for (ProductCart productCart : list) {
            amount += productCart.getAmount() * productCart.getProduct().getPrice();
        }
        model.addAttribute("amount", amount);
        return "cart/cart";
    }

    @RequestMapping(value = "/addtocart", method = RequestMethod.POST)
    public String addProductToCart(String id, String number, HttpSession session) {
        Account account = (Account) session.getAttribute("user");
        Bill bill = BillService.getInstance().checkBillExist(account);
        if (bill != null) {
            if (CartService.getInstance().checkProductInCart(Integer.parseInt(id), account)) {
                CartService.getInstance().updateNumBerProductInCart(Integer.parseInt(id), Integer.parseInt(number), account);
            } else {
                CartService.getInstance().addProductToCart(Integer.parseInt(id), Integer.parseInt(number), account);
            }
        } else {
            Calendar today = Calendar.getInstance();
            Date createDate = today.getTime();
            BillService.getInstance().addBill(account, createDate);
            CartService.getInstance().addProductToCart(Integer.parseInt(id), Integer.parseInt(number), account);
        }

        List<ProductCart> list = CartService.getInstance().getListProductCart(account);
        int numberProductCart = 0;
        if (!list.isEmpty()) {
            for (ProductCart productCart : list) {
                numberProductCart += productCart.getAmount();
            }
        }
        session.setAttribute("productcart", list);
        session.setAttribute("numberproductcart", numberProductCart);
        return "cart/cart";
    }
    
    @RequestMapping(value = "/deleteproductcart", method = RequestMethod.POST)
    public String deleteProductCart(String id){
        
        return "redirect:cart";
    }

}
