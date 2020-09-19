/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.fastfood.login;

import com.web.fastfood.DB;

/**
 *
 * @author MB-study
 */
public class LoginDao {
    public boolean login(String username, String password) {
        return DB.users.entrySet().stream()
                .filter(u -> u.getKey().equals(username) && u.getValue().equals(password))
                .findAny()
                .isPresent();
    }
}
