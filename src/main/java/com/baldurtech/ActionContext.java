package com.baldurtech;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.io.IOException;
import javax.servlet.ServletException;
public interface ActionContext {
    public void setAttribute(String key, Object value);
}