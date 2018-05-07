/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.beans.Product;
import com.quangvn.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class ProductController {

    @RequestMapping(value = "/listproduct", method = RequestMethod.GET)
    public String getListProduct(Model model) {
        List<Product> listProduct = ProductService.getInstance().getListProduct();
        model.addAttribute("listProduct", listProduct);
        return "product/listproduct";
    }

    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
    public String getProductDetail(Model model, HttpServletRequest req) {
        String idProduct = req.getParameter("id");
        Product product = ProductService.getInstance().getProductById(Integer.parseInt(idProduct));
        model.addAttribute("product", product);
        return "product/productdetail";
    }

    @RequestMapping(value = "/searchproduct", method = RequestMethod.GET)
    public String searchProduct(String key, Model model) {
        List<Product> listProduct = ProductService.getInstance().getProductByName(key);
        model.addAttribute("listProduct", listProduct);
        return "product/listproduct";
    }
}
