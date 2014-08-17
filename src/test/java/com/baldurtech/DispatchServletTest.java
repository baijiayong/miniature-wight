package com.baldurtech;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class  DispatchServletTest extends MiniatureSpiceTestCase{
    public void test_contact_show_应该由contactAction来处理() {
        DispatchServlet dispatchServlet = new DispatchServlet();
        
        assertEquals("com.baldurtech.ContactAction", dispatchServlet.getClassNameByUri("/contact/show"));
    }
}