/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.mvc.bmi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MB-study
 */
public class BMIDAO {
    private static List<BMI> bmis = new ArrayList<>();
    
    public void add(BMI bmi) {
        bmis.add(bmi);
    }
    
    public List<BMI> queryAll() {
        return bmis;
    }
}
