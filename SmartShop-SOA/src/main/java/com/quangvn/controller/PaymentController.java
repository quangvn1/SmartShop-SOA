/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.utils.RestUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author quangvn
 */
@Controller
public class PaymentController {

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay() {
        return "payment/infopay";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public void infoPay(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "https://sandbox.vnpayment.vn/tryitnow/Home/CreateOrder?orderType=fashion&Amount=30000&OrderDescription=quangvn");
    }
}
