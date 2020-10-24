/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.rest;

import com.web.student.service.StudentService;
import com.web.study.rest.jpa_mango.service.MangoService;
import com.web.study.rest.lotto.LottoService;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class MyApplication extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new LinkedHashSet<>();
        classes.add(HelloService.class);
        classes.add(BMIService.class);
        //classes.add(StudentService.class);
        return classes;
    }
    
    @Override
    public Set<Object> getSingletons() {
        Set<Object> objects = new LinkedHashSet<>();
        objects.add(new CountSingletonService());
        objects.add(new LottoService());
        objects.add(new StudentService());
        objects.add(new MangoService());
        return objects;
    }

    @Override
    public Map<String, Object> getProperties() {
        
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("max", 10);
        map.put("min", 0);
        map.put("Lotto", new Integer[]{5, 39});
        map.put("PassScore", 60);
        return map;
    }
    
    
    
    
}
