//dugu

import java.*;
import java.io.*;
import java.util.*;

import jdk.Exported;

@Exported
public class dugu {
    public static void main(String[] args) {
        System.out.println("DuGu, Hello Java in Vs Code");
        System.out.println("hahahah lalalala");
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

