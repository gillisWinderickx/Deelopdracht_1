package ui.controller;

import domain.db.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    PersonService db = new PersonService();
    HandlerFactory handlerFactory = new HandlerFactory();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            RequestHandler handler = handlerFactory.getHandler(command, db);
            String destination = handler.handleRequest(request, response);
            RequestDispatcher view = request.getRequestDispatcher(destination);
            view.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
