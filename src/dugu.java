//dugu

import java.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.FutureTask;

import jdk.Exported;

@Exported
public class dugu {
    public static void main(String[] args) {
        System.out.println("DuGu, Hello Java in Vs Code");
        System.out.println("hahahah lalalala");
        Dog dog = new Dog();
        System.out.println(dog.color);
        Puppy myPuppy = new Puppy( "tommy" );
        myPuppy.setAge( 2 );
        myPuppy.getAge( );
        myPuppy.printValueType();
        System.out.println("value : " + myPuppy.puppyAge ); 

        final double PI = 3.1415927;
        byte a = 68;
        char c = '\u0001';
        String s = "\u0001";

        Integer x = 10;

        Thread javaThread = new Thread(new Runnable(){
            @Override
            public void run() {
                Thread.sleep(1000);
            }
        }, "thread_name");
        javaThread.setPriority(Thread.MAX_PRIORITY);
        javaThread.run();
    }

    int m_index;

    public int count;

    public int getIndex(){
        return m_index;
    }

    public void setIndex(int index) {
        m_index = index;
    }

    public dugu(int index){
        m_index = index;
    }

    public dugu(){
        m_index = 555;
        count = 888;
    }

    public void print(){
        System.out.println("Hello dugu!");
    }



}

