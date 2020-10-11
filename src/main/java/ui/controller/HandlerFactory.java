package ui.controller;

import domain.db.PersonService;

import java.util.HashMap;
import java.util.Map;

public class HandlerFactory {
    private Map<String, RequestHandler> handlers = new HashMap<>();

    public HandlerFactory(){
        handlers.put("Home", new HomeHandler());
        handlers.put("Overview", new OverviewHandler());
        handlers.put("Register", new RegisterHandler());
        handlers.put("RegisterUser", new RegisterUserHandler());
        handlers.put("Login", new LoginHandler());
        handlers.put("Logout", new LogoutHandler());

    }

    public RequestHandler getHandler(String command, PersonService db) {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("ui.controller." + command);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(db);
        } catch (Exception e) {
            throw new RuntimeException("This page does not exist!");
        }
        return handler;
    }
}
