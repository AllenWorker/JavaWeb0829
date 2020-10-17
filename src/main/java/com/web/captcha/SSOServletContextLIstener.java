/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.captcha;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SSOServletContextLIstener implements ServletContextListener {
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Set<String> alreadyLoginMembers = new LinkedHashSet<>();
        
        sce.getServletContext().setAttribute("alreadyLoginMembers", alreadyLoginMembers);
        sce.getServletContext().setAttribute("captcha_verify_url", "https://www.google.com/recaptcha/api/siteverify");
        sce.getServletContext().setAttribute("captcha_remoteip", "localhost");
        sce.getServletContext().setAttribute("captcha_client_key", "6LdKStgZAAAAAHGaRG8uyRbziHSgxlEBv-EGloVm");
        sce.getServletContext().setAttribute("captcha_server_key", "6LdKStgZAAAAAGEBeLO8YY3V2cs1z6a-iRQ83Xqz");
        
    }
    
}
