
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
    }
    
}
