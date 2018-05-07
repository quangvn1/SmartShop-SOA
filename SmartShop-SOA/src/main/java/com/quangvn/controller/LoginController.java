/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.controller;

import com.quangvn.beans.Account;
import com.quangvn.service.AccountService;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author VAN
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkUser(HttpSession session, Account account) {
        Account entity = AccountService.getInstance().checkAccount(account);
        if (entity != null) {
            session.setAttribute("user", entity);
            String[] _split_name = entity.getFullname().split(" ");
            session.setAttribute("fullname", _split_name[_split_name.length - 1]);
            session.setAttribute("resultLogin", "success");
            
            
        } else {
            session.setAttribute("resultLogin", "fail");
        }
        return "redirect:/";
    }
}
