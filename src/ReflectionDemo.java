

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;


import java.*;
/**
 * ReflectionDemo
 */
public class ReflectionDemo implements TestDemo{
    public static void main(String[] args) {
        System.out.println("DuGu, Hello Java in Vs Code");
        System.out.println("hahahah lalalala");
        TestDemo that = new ReflectionDemo();
        that.testDemo();
    }

    @Override
    public void testDemo() {
        System.out.println("Java Reflection Demo!");
        dugu one = new dugu();
        Class<?> oneClass = one.getClass();
        Class<?> twoClass = dugu.class;
        System.out.println("the two classes is equal?");
        System.out.println(oneClass == twoClass);
        System.out.println(oneClass);
        System.out.println(oneClass.getName());
        // System.out.println(Class.forName("src.dugu"));
        try {
            int i = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Constructor<?>[] conArray = oneClass.getConstructors();
        for(Constructor<?> con : conArray){
            System.out.println(con.toString());
            System.out.println(String.format("%s, %d", con.getName(), con.getParameterCount()));        
        }
        //Object obj = oneClass.getConstructor(null).newInstance();
        for(Field field: oneClass.getFields()){
            System.out.println(field);
        }

        for(Method field: oneClass.getMethods()){
            System.out.println(field);
        }

        for(Annotation field: oneClass.getAnnotations()){
            System.out.println(field);
        }
        //oneClass.getMethod("print").invoke(oneClass.newInstance());
    }
    
}
