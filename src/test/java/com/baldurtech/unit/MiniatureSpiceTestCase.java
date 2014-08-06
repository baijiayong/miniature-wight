package com.baldurtech.unit;

import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.reflections.Reflections;

public class MiniatureSpiceTestCase
{
    static Boolean testResult = true;
    
    public static void main(String args[]) throws Exception
    {
        String testPackage = null;
        if(args.length > 0)
        {
           testPackage = args[0];
        }
            Reflections reflections = new Reflections(testPackage);
            
            Set<Class<? extends MiniatureSpiceTestCase>> allTestCase = reflections.getSubTypesOf(MiniatureSpiceTestCase.class);
        
            for(Class clazz: allTestCase)
            {
            System.out.println("Testing: " + clazz.getName());
            runAllTest(clazz);
            }
            outputTestResult();
        }
    
    public static void runAllTest(Class clazz) throws Exception
    {
        for(Method method : getAllTestMethod(clazz))
        {
            System.out.println("testing: " + method.getName());
            try{
                Object obj = clazz.newInstance();
                method.invoke(obj,new Object[]{});
            }catch(Exception e)
            {
                testResult = false;
                System.out.println("Unexcepted exception!");
                e.printStackTrace();
            }
        }      
    }
    public static List<Method> getAllTestMethod(Class clazz) throws Exception
    {
        List<Method> testMethods = new ArrayList<Method>();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods)
        {
            if(method.getName().startsWith("test"))
            {
                testMethods.add(method);
            }
        }
        return testMethods;
    }
    public static void assertEquals(String expectedResult,String actualResult)
    {
        assertEquals(expectedResult,actualResult,expectedResult.equals(actualResult));
    } 
    public static void assertEquals(int expectedResult, int actualResult)
    {   
        assertEquals(expectedResult,actualResult,expectedResult == actualResult);
    }
    public static void assertNull(Object actualResult)
    {
        assertEquals(null,actualResult,actualResult == null);
    }
    public static void assertTrue(Boolean actualResult)
    {
        assertEquals(true,actualResult,actualResult == true);
    }
    public static void assertFalse(Boolean actualResult)
    {
        assertEquals(false,actualResult,actualResult == false);
    }
    public static void assertEquals(Object expectedResult,Object actualResult)
    {
        Boolean testResult =false;
        if(expectedResult == null && actualResult ==null)
        {
            testResult = true;
        }else if(expectedResult != null)
        {
            testResult = expectedResult.equals(actualResult);
        }
        assertEquals(expectedResult,actualResult,testResult);
    }
    public static void assertEquals(Object expectedResult, Object actualResult,Boolean testSuccess)
    {
        if(! testSuccess)
        {
            testResult = false;
            System.out.println("Excepted '" + (expectedResult == null?"NULL":expectedResult) + "', but '" + (actualResult == null?"NULL":actualResult) + "'");
        }
    }
    private static void outputTestResult()
    {
        if(testResult)
        {
            System.out.println("TEST SUCCESS");
        }else
        {
            System.out.println("TEST FAILED");
        }
    }
}