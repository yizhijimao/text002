package com.qf.servlet;

import com.qf.entity.Sumiko;

import com.qf.service.impl.sumikoServictImpl;
import com.qf.service.sumikoServict;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class sumikoServlet extends HttpServlet {
    Sumiko sumiko = new Sumiko();
    private sumikoServict sumikoServict = new sumikoServictImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Sumiko> all = sumikoServict.findAll();
        req.setAttribute("empList",all);
        req.getRequestDispatcher("/sumiko.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
