package ui.controller;

import domain.db.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    protected PersonService db;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setModel(PersonService db) {
        this.db = db;
    }

    public PersonService getDb(){
        return this.db;
    }
}
