/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.tag;

import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;


public class HelloTag implements Tag{
    private PageContext pageContext;
    private Tag parentTag;
    private String name;
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        // code
        JspWriter out = pageContext.getOut();
        try {
            out.print("Hello ");
            if(name != null)
                out.print(name + " ");
            out.print(new Date());
        } catch (Exception e) {
            
        }
        return Tag.SKIP_BODY;
        
    }

    @Override
    public int doEndTag() throws JspException {
        // code
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}
