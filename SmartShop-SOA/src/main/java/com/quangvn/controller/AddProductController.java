/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.beans.Account;
import com.quangvn.beans.Product;
import com.quangvn.beans.ProductCart;
import com.quangvn.service.CartService;
import com.quangvn.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nguye
 */
@Controller
public class AddProductController {
    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        
        return "product/addproduct";
    }
}
