package ui.controller;

import domain.db.DbException;
import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandler extends ui.controller.RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try{
            String userid = request.getParameter("userid").toLowerCase();
            Person person = db.get(userid);
            if (person != null && person.isCorrectPassword(request.getParameter("password"))){
                HttpSession session = request.getSession();
                session.setAttribute("login", person);
            } else{
                request.setAttribute("error", "Wrong user identification or password.");
            }
        } catch (DbException e){
            request.setAttribute("error", "The given data is invalid");
        } return "Controller?command=HomeHandler";
    }
}
