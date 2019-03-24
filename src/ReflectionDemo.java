

import java.io.*;
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
        // 一个类在运行期间只有一个类产生
        // System.out.println(Class.forName("src.dugu"));
        try {
            int i = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
