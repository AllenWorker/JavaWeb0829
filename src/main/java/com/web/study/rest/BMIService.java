/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.rest;

// url: /rest/bmi/john/170.0/60.5, rest/bmi/mary/162.5/55.2

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("bmi")
public class BMIService {
    @Path("{name}/{height}/{weight}")
    @GET
    @Produces("text/plain")
    public String bmi(@PathParam("name")String name, @PathParam("height")double height, @PathParam("weight")double weight){
        char temp  = name.toUpperCase().charAt(0);
        name = temp + name.substring(1);
        return "Name: " + name + " BMI= " + (weight/Math.pow(height/100, 2));
    }
}
