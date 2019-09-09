package com.hwua.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Created by unbreabakle on 2017/1/17.
 */
public class TestFileUpload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了!");
        processRequest(req, resp);
        resp.getWriter().write("hello");
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("file");
        String fileName = part.getSubmittedFileName();
        InputStream inputStream = part.getInputStream();
        OutputStream os = null;
        byte[] buf = new byte[1024];
        int flag = 0;
        System.out.println("ContextPath:"+request.getContextPath());
        System.out.println("RequestURI:"+request.getRequestURI());
        System.out.println("RequestURL:"+request.getRequestURL());
        String realPath=request.getServletContext().getRealPath("/");
        System.out.println(realPath+"imgs");
        File file = new File(realPath+"imgs/"+ fileName);
        request.getSession().setAttribute("filename",fileName);
        os = new FileOutputStream(file);
        while ((flag = inputStream.read(buf, 0, 1024)) != -1) {
            os.write(buf, 0, 1024);
        }
        inputStream.close();
        os.close();
    }
}
