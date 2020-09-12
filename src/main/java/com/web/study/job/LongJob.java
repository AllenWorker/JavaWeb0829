/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.job;

import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;

/**
 *
 * @author MB-study
 */
public class LongJob implements Runnable {

    private AsyncContext ctx;

    public LongJob(AsyncContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = ctx.getResponse().getWriter();
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(1000);
                out.print(i + ". 很長的工作做完了,時間: " + new Date() + "<p>");
                out.flush();
            }

            ctx.complete();
        } catch (Exception e) {

        }
    }

}
