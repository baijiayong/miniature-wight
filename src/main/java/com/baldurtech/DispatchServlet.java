package com.baldurtech;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DispatchServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
        try {
            String uri = getUri(request);
            ActionContext actionContext = new ActionContextImpl(getServletContext(), request, response);
            
            Class actionClass = getActionByUri(uri);
            Constructor actionConstructor = actionClass.getDeclaredConstructor(new Class<?>[]{ActionContext.class});
            
            Action actionInstance = (Action)actionConstructor.newInstance(actionContext);
            Method method = actionClass.getDeclaredMethod(getMethodNameByUri(uri),new Class<?>[]{});
            Object returnValue = method.invoke(actionInstance);
            if(null == returnValue) {
                return;
            }
            if(returnValue instanceof Map) {
                Map<String, Object> dataModel = (Map<String, Object>) returnValue;
                for(String key: dataModel.keySet()) {
                    request.setAttribute(key, dataModel.get(key));
                }
               
            }
            else{
                request.setAttribute("data", returnValue);
            }
           
            getServletContext()
                .getRequestDispatcher(getViewPage(uri))
                .forward(request, response);

        }catch(Exception e) {
            
        }
    }
     
    public String getUri(HttpServletRequest request) {
        return request.getRequestURI().replace(request.getContextPath(), "");
    }
    public String defaultPackageName = "com.baldurtech";
    public String defaultSuffix = ".jsp";
    
    public Class getActionByUri(String uri) throws Exception {
        return Class.forName(getActionClassNameByUri(uri)); 
    }
    
    public String getActionClassNameByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfActionClassName = 1;
        String actionClassName = capitalize(removeMethodSuffix(uriParts[indexOfActionClassName]));
        return defaultPackageName + "." + actionClassName + "Action";
    }
    
    public String getMethodNameByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfMethodName = 2;
        if(uriParts.length <= indexOfMethodName) {
            return "index";
        }
        return removeMethodSuffix(uriParts[indexOfMethodName]);
    }
    
    public String removeMethodSuffix(String str) {
        return str.replace(defaultSuffix, "");
    }
    public String[] splitBySlash(String uri) {
        return uri.split("/");
    }
    public String getViewPage(String uri) {
        return "WEB-INF/jsp/contact/show.jsp";
    }
    public String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}