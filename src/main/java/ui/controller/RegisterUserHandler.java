package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RegisterUserHandler extends ui.controller.RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();
        Person persoon = new Person();

        setUserid(persoon, request, errors);
        setFirstName(persoon, request, errors);
        setLastName(persoon, request, errors);
        setEmail(persoon, request, errors);
        setPassword(persoon, request, errors);

        if (errors.size() == 0){
            try{
                db.add(persoon);
                return "Controller?command=OverviewHandler";
            } catch (IllegalArgumentException e){
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=RegisterHandler";
    }

    private void setFirstName(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        try{
            persoon.setFirstName(firstName);
            request.setAttribute("firstNamePreviousValue", firstName);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setLastName(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");
        try {
            persoon.setLastName(lastName);
            request.setAttribute("lastNamePreviousValue", lastName);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setUserid(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String userid = request.getParameter("userid");
        try {
            persoon.setUserid(userid);
            request.setAttribute("useridPreviousValue", userid);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setPassword(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String password = request.getParameter("password");
        try{
            persoon.setPassword(password);
            request.setAttribute("passwordPreviousValue", password);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setEmail(Person persoon, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try {
            persoon.setEmail(email);
            request.setAttribute("emailPreviousValue", email);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }
}
