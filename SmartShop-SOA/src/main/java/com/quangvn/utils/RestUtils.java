/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author quangvn
 */
public class RestUtils {

    public static void restPost() {
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("https://sandbox.vnpayment.vn/tryitnow/Home/CreateOrder");

            List<NameValuePair> params = new ArrayList<NameValuePair>(2);
            params.add(new BasicNameValuePair("orderType", "fashion"));
            params.add(new BasicNameValuePair("Amount", "30000"));
            params.add(new BasicNameValuePair("OrderDescription", "quangvn test Jmeter"));
            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            httpclient.execute(httppost);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
