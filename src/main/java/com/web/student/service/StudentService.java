/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.student.service;

import com.web.student.entity.Message;
import com.web.student.entity.Student;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("student")
public class StudentService {
    private Set<Student> students = new LinkedHashSet<>();
    {
        students.add(new Student(1, "John",100));
        students.add(new Student(2, "Mary",90));
        students.add(new Student(3, "Helen",80));
    }
    
    @Path("/")
    @GET
    @Produces("application/json")
    public Response getAll(){
        if(students.size() > 0){
            return Response.ok().entity(students).encoding("utf-8").build();
        } else {
            Message message = new Message(400, "NO DATA!");
            return Response.status(message.getCode()).entity(message).encoding("utf-8").build();
        }
    }
    
    @Path("{id}")
    @GET
    @Produces("application/json")
    public Response get(@PathParam("id")Integer id){
        Optional<Student> st = students.stream().filter(s -> s.getId() == id).findFirst();
        if (st.isPresent()) {
            return Response.ok().entity(st.get()).encoding("utf-8").build();
        }else{
            Message message = new Message(400, String.format("id: %d not found", id));
            return Response.status(message.getCode()).entity(message).encoding("utf-8").build();
        }
    }
    
    /*
    [
        "id": 1,
        "name": "John",
        "score": 90
    ]
    */
    @Path("/")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Student student){
        if(student != null){
            int nextId = 1;
            if (students.size() > 0) {
                nextId = students.stream().mapToInt(s -> s.getId()).max().getAsInt() + 1;
            }
            student.setId(nextId);
            students.add(student);
            Message message =new Message(200, "Create Successfully!");
            return Response.ok().entity(message).encoding("utf-8").build();
        } else {
            Message message = new Message(400, "CREATE ERROR! NO DATA!");
            return Response.status(message.getCode()).entity(message).encoding("utf-8").build();
        }
    }
    
    @Path("{id}")
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id")Integer id, Student student){
        Optional<Student> st = students.stream().filter(s -> s.getId() == id).findFirst();
        if (st.isPresent()) {
            st.get().setName(student.getName());
            st.get().setScore(student.getScore());
            Message message =new Message(200, "Update Successfully!");
            return Response.ok().entity(message).encoding("utf-8").build();
        }else{
            Message message = new Message(400, "CREATE ERROR! NO DATA!");
            return Response.status(message.getCode()).entity(message).encoding("utf-8").build();
        }
    }
    
    @Path("{id}")
    @DELETE
    @Produces("application/json")
    public Response delete(@PathParam("id")Integer id){
       Optional<Student> st = students.stream().filter(s -> s.getId() == id).findFirst();
        if (st.isPresent()) {
            students.remove(st.get());
            Message message =new Message(200, "Delete Successfully!");
            return Response.ok().entity(message).encoding("utf-8").build();
        }else{
            Message message = new Message(400, "DELETE ERROR! NO DATA!");
            return Response.status(message.getCode()).entity(message).encoding("utf-8").build();
        }
    }
}
