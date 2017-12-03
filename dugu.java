//dugu
import java.lang.System;
import java.awt.SystemColor;
import java.io.*;
import java.lang.System;
import java.util.*;
import java.*;

public class dugu {
    public static void main(String[] args) {
        System.out.println("DuGu, Hello Java in Vs Code");
        Mydugu dugu = new Mydugu();
        System.out.println("hahahah lalalala");
        System.out.println(my.ss.toString());
        System.out.println(dugu.ok + dugu.num);
        dugu.Get();
        System.out.println(dugu.getClass().toString());
    }
}

class my implements myinterface{
    public static String ss = "aa";
    @Override
    public void Get(){

    }
}

class Mydugu extends my implements myinterface{
    public String ok = "ok";
    public int num = 2;
}
