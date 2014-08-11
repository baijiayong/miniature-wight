package com.baldurtech;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class DispatchServletTest extends MiniatureSpiceTestCase {
    DispatchServlet dispatchServlet = new DispatchServlet();
    String contactActionClassName = "com.baldurtech.ContactAction";
    String adminContactActionClassName = "com.baldurtech.AdminContactAction";
    
    public void test_uri_contact_show_应该由ContactAction来处理() { 
        assertEquals(contactActionClassName, dispatchServlet.getActionClassNameByUri("/contact/show.jsp"));
    }
    public void test_uri_contact_应该由ContactAction来处理() {
        assertEquals(contactActionClassName, dispatchServlet.getActionClassNameByUri("/contact.jsp"));
    }
    public void test_contact_show的处理方法是show() {
        assertEquals("show", dispatchServlet.getMethodNameByUri("/contact/show.jsp"));
    }
    public void test_contact的处理方法是index() {
        assertEquals("index", dispatchServlet.getMethodNameByUri("/contact.jsp"));
    }
}