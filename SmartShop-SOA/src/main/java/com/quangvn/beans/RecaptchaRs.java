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
public class RecaptchaRs {
    
    private String success;
    
    private String challenge_ts;
    
    private String hostname;
}
