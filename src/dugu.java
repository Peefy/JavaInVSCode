//dugu

import java.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.FutureTask;

import jdk.Exported;

@Exported
public class dugu {
    static int allClicks = 0;    // �����
    
    public static final int MAX_DUGU = 22;

    public transient int limit = 55;   // ����־û�

    private volatile boolean active;

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
        char ccchar = '\u0001';
        String s = "\u0001";

        Integer x = 10;

        Thread javaThread = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread" + String.valueOf(i));
                }
            }
        }, "thread_name");
        javaThread.setPriority(Thread.MAX_PRIORITY);
        javaThread.run();

        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
        System.out.println(FreshJuice.FreshJuiceSize.SMALL);

        int ia =128;   
        byte b = (byte)ia;
        System.out.println((int)23.7 == 23);
        System.out.println((int)-45.89f == -45);

        char c1='a';//����һ��char����
        int i1 = c1;//char�Զ�����ת��Ϊint
        System.out.println("char�Զ�����ת��Ϊint���ֵ����"+i1);
        char c2 = 'A';//����һ��char����
        int i2 = c2+1;//char ���ͺ� int ���ͼ���
        System.out.println("char���ͺ�int������ֵ����"+i2);

        i1 = 123;
        b = (byte)i1;//ǿ������ת��Ϊbyte
        System.out.println("intǿ������ת��Ϊbyte���ֵ����"+b);

        int aa, bb, cc;         // ��������int��������a�� b��c
        int dd = 3, e = 4, f = 5; // �������������������ֵ
        byte z = 22;         // ��������ʼ�� z
        String xs = "runoob";  // ��������ʼ���ַ��� s
        double pi = 3.14159; // ������˫���ȸ����ͱ��� pi
        char xx = 'x';        // �������� x ��ֵ���ַ� 'x'��

        System.out.println(dugu.allClicks);
        System.out.println(dugu.MAX_DUGU);

        System.out.println("Starting with " +
        InstanceCounter.getCount() + " instances");
        for (int i = 0; i < 500; ++i){
           new InstanceCounter();
            }
        System.out.println("Created " +
        InstanceCounter.getCount() + " instances");

        a = 10;
        b = 20;
        int c = 25;
        int d = 25;
        System.out.println("a + b = " + (a + b) );
        System.out.println("a - b = " + (a - b) );
        System.out.println("a * b = " + (a * b) );
        System.out.println("b / a = " + (b / a) );
        System.out.println("b % a = " + (b % a) );
        System.out.println("c % a = " + (c % a) );
        System.out.println("a++   = " +  (a++) );
        System.out.println("a--   = " +  (a--) );
        // �鿴  d++ �� ++d �Ĳ�ͬ
        System.out.println("d++   = " +  (d++) );
        System.out.println("++d   = " +  (++d) );

        a = 5;//����һ��������
        b = 5;
        x = 2*++a;
        int y = 2*b++;
        System.out.println("���������ǰ׺�����a="+a+",x="+x);
        System.out.println("�����������׺�����b="+b+",y="+y);

        a = 10;
        b = 20;
        System.out.println("a == b = " + (a == b) );
        System.out.println("a != b = " + (a != b) );
        System.out.println("a > b = " + (a > b) );
        System.out.println("a < b = " + (a < b) );
        System.out.println("b >= a = " + (b >= a) );
        System.out.println("b <= a = " + (b <= a) );

        a = 60; /* 60 = 0011 1100 */ 
        b = 13; /* 13 = 0000 1101 */
        c = 0;
        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c );
        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c );
        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c );
        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c );
        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c );
        c = a >> 2;     /* 15 = 1111 */
        System.out.println("a >> 2  = " + c );
        c = a >>> 2;     /* 15 = 0000 1111 */
        System.out.println("a >>> 2 = " + c );

        boolean abool = true;
        boolean bbool = false;
        System.out.println("a && b = " + (abool && bbool));
        System.out.println("a || b = " + (abool || bbool) );
        System.out.println("!(a && b) = " + !(abool && bbool));

        a = 5;//����һ��������
        bbool = (a<4) && (a++<10);
        System.out.println("ʹ�ö�·�߼�������Ľ��Ϊ"+bbool);
        System.out.println("a�Ľ��Ϊ"+a);

        a = 10;
        b = 20;
        c = 0;
        c = a + b;
        System.out.println("c = a + b = " + c );
        c += a ;
        System.out.println("c += a  = " + c );
        c -= a ;
        System.out.println("c -= a = " + c );
        c *= a ;
        System.out.println("c *= a = " + c );
        a = 10;
        c = 15;
        c /= a ;
        System.out.println("c /= a = " + c );
        a = 10;
        c = 15;
        c %= a ;
        System.out.println("c %= a  = " + c );
        c <<= 2 ;
        System.out.println("c <<= 2 = " + c );
        c >>= 2 ;
        System.out.println("c >>= 2 = " + c );
        c >>= 2 ;
        System.out.println("c >>= 2 = " + c );
        c &= a ;
        System.out.println("c &= a  = " + c );
        c ^= a ;
        System.out.println("c ^= a   = " + c );
        c |= a ;
        System.out.println("c |= a   = " + c );

        a = 10;
        // ��� a ���� 1 ������������ b Ϊ 20������Ϊ 30
        b = (byte)((a == 1) ? 20 : 30);
        System.out.println( "Value of b is : " +  b );
        // ��� a ���� 10 ������������ b Ϊ 20������Ϊ 30
        b = (byte)((a == 10) ? 20 : 30);
        System.out.println( "Value of b is : " + b );

        String name = "James";
        boolean result = name instanceof String;
        
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

