/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloService {
    
    // uri/rest/hello/
    @Path("/")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello Rest";
    }
    
    // uri/rest/hello/john
    @Path("john")
    @GET
    @Produces("text/plain")
    public String helloJohn() {
        return "Hello John";
    }
    
    // uri/rest/hello/{name}
    @Path("{name}")
    @GET
    @Produces("text/plain")
    public String helloWho(@PathParam("name") String name) {
        return "Hello " + name;
    }
    
    // uri/rest/hello/{x}/{y}
    @Path("{x}/{y}")
    @GET
    @Produces("text/plain")
    public String add(@PathParam("x")Integer x, @PathParam("y")Integer y){
        return "Sum: " + (x + y);
    }
}
