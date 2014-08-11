package com.baldurtech;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class DispatchServletTest extends MiniatureSpiceTestCase {
    DispatchServlet dispatchServlet = new DispatchServlet();
    String contactActionClassName = "com.baldurtech.ContactAction";
    
    public void test_uri_contact_show_应该由ContactAction来处理() { 
        assertEquals(contactActionClassName,dispatchServlet.getActionClassNameByUri("/contact/show"));
    }
    public void test_uri_contact_应该由ContactAction来处理() {
        assertEquals(contactActionClassName,dispatchServlet.getActionClassNameByUri("/contact"));
    }
    public void test_contact_show的处理方法是show() {
        assertEquals("show",dispatchServlet.getMethodNameByUri("/contact/show"));
    }
    public void test_contact的处理方法是index() {
        assertEquals("index",dispatchServlet.getMethodNameByUri("/contact"));
    }
    public void test_contact_slash_suffix的处理方法是index() {
        assertEquals("index",dispatchServlet.getMethodNameByUri("/contact/"));
    }
}