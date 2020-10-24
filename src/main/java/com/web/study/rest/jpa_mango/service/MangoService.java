/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.rest.jpa_mango.service;

import com.web.study.rest.jpa_mango.entity.Customer;
import com.web.study.rest.jpa_mango.entity.Mango;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("mango")
public class MangoService {

    @Path("customers")
    @GET
    @Produces("application/json")
    public List readAllCustomer(@Context HttpServletRequest req) {
        EntityManager em = getEntityManager(req);
        return em.createNamedQuery("Customer.findAll").getResultList();
    }

    // http://localhost:8080/JavaWeb0829/rest/mango/customers
    @Path("customer")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String create(Customer customer, @Context HttpServletRequest req) {
        //System.out.println(customer);
        EntityManager em = getEntityManager(req);
        // 確認數量
        String sql = "SELECT amount-(SELECT SUM(amount) FROM Customer) FROM Mango";
        // 剩餘庫存
        int remainAmount = Integer.parseInt(em.createNativeQuery(sql).getSingleResult()+"");
        if(remainAmount >= customer.getAmount()) {
            EntityTransaction et = em.getTransaction();
            et.begin(); // 交易開始
            em.persist(customer); // 將 customer 加入
            et.commit(); // 交易提交
            em.close();
            return "OK";
        } else {
            return "餘量不足, 尚有庫存:" + remainAmount;
        }

    }

    private EntityManager getEntityManager(HttpServletRequest req) {
        EntityManagerFactory emf = (EntityManagerFactory) req.getServletContext().getAttribute("emf");
        return emf.createEntityManager();
    }

}

/*
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
 */
