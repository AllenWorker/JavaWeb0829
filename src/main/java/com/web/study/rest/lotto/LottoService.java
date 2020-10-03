/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.rest.lotto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

@Path("lotto")
public class LottoService {
    private Set<Lotto> lottos = new HashSet<>();
    private int id;
    @Path("/")
    @GET
    @Produces("application/json")
    public Set<Lotto> readAll() {
        return lottos;
    }
    
    @Path("{id}")
    @GET
    @Produces("application/json")
    public Lotto read(@PathParam("id")Integer id){
        Optional<Lotto> lo = lottos.stream().filter(lotto -> lotto.getId() == id).findAny();
        
        
        return lo.isPresent() ? lo.get() : null;
    }
    
    @Path("/")
    @POST
    @Produces("text/html")
    public String create(@Context Application app){
        Lotto lotto = genLotto(app);
        lottos.add(lotto);
        return lotto.toString();
    }
    
    @Path("{id}")
    @PUT
    @Produces("text/html")
    public String update(@Context Application app, @PathParam("id")Integer id){
        Optional<Lotto> lo = lottos.stream().filter(lotto -> lotto.getId() == id).findAny();
        if(lo.isPresent()){
            String oldLotto = lo.get().toString();
            lo.get().setNums(genLotto(app).getNums());
            return "Before: " + oldLotto + "\nAfter: " + lo.get().toString();
        }else{
           return "ID: " + id + " Not Found!";
        }
    }
    
    @Path("{id}")
    @DELETE
    @Produces("text/html")
    public String delete(@Context Application app, @PathParam("id")Integer id){
        Optional<Lotto> lo = lottos.stream().filter(lotto -> lotto.getId() == id).findAny();
        if(lo.isPresent()){
            lottos.remove(lo.get());
            return "ID: " + id + " is deleted successfully!!";
        }else{
           return "Not Found!";
        }
    }
    
    private Lotto genLotto(Application app) {
        Integer[] args = (Integer[])app.getProperties().get("Lotto");
        int size = args[0];
        int max = args[1];
        Set<Integer> nums = new LinkedHashSet<>();
        while (nums.size() < size) {            
            int num = new Random().nextInt(max) + 1;
            nums.add(num);
        }
        
        Lotto lotto = new Lotto();
        lotto.setId(++id);
        lotto.setNums(nums);
        return lotto;
    }
}
