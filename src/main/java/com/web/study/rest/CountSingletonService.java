/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

@Path("count")
public class CountSingletonService {
    private int count;
    
    @Path("add")
    @GET
    @Produces("text/plain")
    public String add(@Context Application app){
        int max =  Integer.parseInt(app.getProperties().get("max").toString());
        int min = Integer.parseInt(app.getProperties().get("min").toString());
        count = (count >= max) ? min : count;
        count++;
        return "Count: " + count;
    }
    
}
