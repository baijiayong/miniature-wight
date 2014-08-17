package com.baldurtech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet {

    public void doget(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException 
    {
        
    }
    
    public String defaultPackageName = "com.baldurtech";
    
    public String getClassNameByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfActionClassName = 1;
        String actionClassName =capitalize(uriParts[indexOfActionClassName]);
        return defaultPackageName + "." + actionClassName + "Action";
    }
    
    public String getMethodNameByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfMethodName = 2;
        if(uriParts.length <= indexOfMethodName) {
            return "index";
        }
        return uriParts[indexOfMethodName];
    }
    
    public String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    
    public String[] splitBySlash(String uri) {
        return uri.split("/");
    }
}   