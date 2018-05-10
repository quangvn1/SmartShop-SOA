/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.utils;

import com.google.gson.Gson;
import com.quangvn.beans.RecaptchaRs;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 *
 * @author quangvn
 */
public class VerifyUtils {

    public static final String SITE_KEY = "6Le2xlYUAAAAAMvKnCvhdAdUWHzhTJyh9MvApXnr";

    public static final String SECRET_KEY = "6Le2xlYUAAAAAM81C-kti2kOH8DXDCv-rqHwztpF";

    public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    public static boolean verify(String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
            return false;
        }
        try {
            String url = SITE_VERIFY_URL
                    + "?secret=" + SECRET_KEY
                    + "&response=" + gRecaptchaResponse;
            InputStream res = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(res, Charset.forName("UTF-8")));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            res.close();

            Gson gson = new Gson();
            RecaptchaRs rs = gson.fromJson(jsonText, RecaptchaRs.class);
            if (rs.getSuccess().equals("true")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
