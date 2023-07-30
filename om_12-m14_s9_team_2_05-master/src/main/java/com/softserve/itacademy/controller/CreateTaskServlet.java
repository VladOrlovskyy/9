package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.*;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {
    private TaskRepository taskRepository;
    private boolean check = true;


    @Override
    public void init() {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("check", check);
        request.getRequestDispatcher("/WEB-INF/pages/create-task.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        Priority priority = Priority.valueOf(request.getParameter("priority"));

        boolean check = false;
        if (title.equals("")) {
            request.setAttribute("error", "There is no title!");
        } else {
            check = taskRepository.create(new Task(title, priority));
        }



        if(!check || title.equals("")) {
            request.setAttribute("check", false);
            request.getRequestDispatcher("/WEB-INF/pages/create-task.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/tasks-list");
        }
    }
}
