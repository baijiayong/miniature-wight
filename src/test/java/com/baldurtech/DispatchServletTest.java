package com.baldurtech;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class  DispatchServletTest extends MiniatureSpiceTestCase{

    DispatchServlet dispatchServlet = new DispatchServlet();
    String contactActionClassName = "com.baldurtech.ContactAction";
    
    public void test_contact_show_应该由contactAction来处理() {
        assertEquals(contactActionClassName, dispatchServlet.getClassNameByUri("/contact/show.do"));
    }
   
    public void test_contact应该由contactAction来了处理() {
        assertEquals(contactActionClassName, dispatchServlet.getClassNameByUri("/contact.do"));
    }
    
    public void test_uri_contact_show的处理方法是show() {
        assertEquals("show", dispatchServlet.getMethodNameByUri("/contact/show.do"));
    }
    
    public void test_uri_contact的处理方法是index() {
        assertEquals("index", dispatchServlet.getMethodNameByUri("/contact.do"));
    }
}