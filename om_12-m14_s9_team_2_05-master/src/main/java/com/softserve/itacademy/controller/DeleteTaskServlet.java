package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-task")
public class DeleteTaskServlet extends HttpServlet {
    private TaskRepository taskRepository;


    @Override
    public void init()  {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        boolean check = taskRepository.delete(id);
        if(!check) {
            response.setStatus(404);
            request.setAttribute("id", Integer.parseInt(request.getParameter("id")));
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        } else {
            response.sendRedirect("/tasks-list");
        }
    }
}
