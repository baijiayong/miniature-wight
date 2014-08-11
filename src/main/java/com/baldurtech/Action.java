package com.baldurtech;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

public abstract class Action {
    final ActionContext actionContext;
   
    public Action() {
        this(null);
    }
    public Action(ActionContext actionContext) {
        this.actionContext = actionContext;
    }

    public void setAttribute(String key, Object value) {
        actionContext.setAttribute(key, value);
    }
    
    
}