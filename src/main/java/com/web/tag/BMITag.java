/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import org.eclipse.persistence.internal.jpa.parsing.StringFunctionNode;

/**
 *
 * @author MB-study
 */
public class BMITag implements Tag{
    private PageContext pageContext;
    private Tag parentTag;
    private double h;
    private double w;
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

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        double bmi = w/Math.pow(h/100, 2);
        try {
           String result = (bmi>23)?"過重":(bmi<18)?"過輕":"正常";
           String data = String.format("h= %.1f, w= %.1f bmi= %.2f (%s)", h,w,bmi, result);
           out.print(data);
        } catch (Exception e) {
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}
