/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.student.entity;

/**
 *
 * @author MB-study
 */
public class Message {
    private int code;
    private String text;

    public Message() {
    }

    public Message(int code, String text) {
        this.code = code;
        this.text = text;
    }
    
    

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" + "code=" + code + ", text=" + text + '}';
    }
    
}
