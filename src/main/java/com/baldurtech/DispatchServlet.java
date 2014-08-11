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
    
    public String defaultPackageName = "com.baldurtech";
    public String defaultSuffix = ".jsp";
    
    public String getActionClassNameByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfActionClassName = 1;
        String actionClassName = capitalize(uriParts[indexOfActionClassName]).replace(defaultSuffix,"");
        return defaultPackageName + "." + actionClassName + "Action";
    }
    
    public String getMethodNameByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfMethodName = 2;
        if(uriParts.length <= indexOfMethodName) {
            return "index";
        }
        return uriParts[indexOfMethodName].replace(defaultSuffix,"");
    }
    
    public String[] splitBySlash(String uri) {
        return uri.split("/");
    }
    
    public String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}