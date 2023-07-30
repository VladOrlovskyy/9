package com.softserve.itacademy.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/", "/home"})
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String path = request.getServletPath();
        if ("/".equals(path) || "/home".equals(path)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/home.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Wrong URL");
        }
    }
}