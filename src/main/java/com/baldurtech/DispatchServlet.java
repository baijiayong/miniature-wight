package com.baldurtech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       
        resp.getWriter().println(req.getRequestURI());
    }
    public String getActionClassNameByUri(String uri) {
        String[] uriParts = uri.split("/");
        Integer indexOfActionClassName = 1;
        String actionClassName = uriParts[indexOfActionClassName];
        actionClassName = actionClassName.substring(0,1).toUpperCase() + actionClassName.substring(1);
        return "com.baldurtech." + actionClassName + "Action";
    }
}