
//dugu

import java.*;
import java.io.*;
import java.lang.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.Exported;

@Exported
public class dugu {
    static int allClicks = 0;    // ?????
    
    public static final int MAX_DUGU = 22;

    public transient int limit = 55;   // ???????

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

        char c1='a';//???????char????
        int i1 = c1;//char???????????int
        System.out.println("char???????????int????????"+i1);
        char c2 = 'A';//???????char????
        int i2 = c2+1;//char ????? int ???????
        System.out.println("char?????int???????????"+i2);

        i1 = 123;
        b = (byte)i1;//???????????byte
        System.out.println("int???????????byte????????"+b);

        int aa, bb, cc;         // ????????int????????a?? b??c
        int dd = 3, e = 4, f = 5; // ????????????????????
        byte z = 22;         // ??????????? z
        String xs = "runoob";  // ???????????????? s
        double pi = 3.14159; // ??????????????????? pi
        char xx = 'x';        // ???????? x ???????? 'x'??

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
        // ??  d++ ?? ++d ????
        System.out.println("d++   = " +  (d++) );
        System.out.println("++d   = " +  (++d) );

        a = 5;//?????????????
        b = 5;
        x = 2*++a;
        int y = 2*b++;
        System.out.println("????????????????a="+a+",x="+x);
        System.out.println("?????????????????b="+b+",y="+y);

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

        a = 5;//?????????????
        bbool = (a<4) && (a++<10);
        System.out.println("????��?????????????"+bbool);
        System.out.println("a?????"+a);

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
        // ??? a ???? 1 ???????????? b ? 20??????? 30
        b = (byte)((a == 1) ? 20 : 30);
        System.out.println( "Value of b is : " +  b );
        // ??? a ???? 10 ???????????? b ? 20??????? 30
        b = (byte)((a == 10) ? 20 : 30);
        System.out.println( "Value of b is : " + b );

        String name = "James";
        boolean result = name instanceof String;

        String [] names ={"James", "Larry", "Tom", "Lacy"};
        for( String n : names ) {
           System.out.print( n );
           System.out.print(",");
        }
        char grade = 'C';
        switch(grade)
        {
           case 'A' :
              System.out.println("����"); 
              break;
           case 'B' :
           case 'C' :
              System.out.println("����");
              break;
           case 'D' :
              System.out.println("����");
              break;
           case 'F' :
              System.out.println("����Ҫ��Ŭ��Ŭ��");
              break;
           default :
              System.out.println("δ֪�ȼ�");
        }
        System.out.println("��ĵȼ��� " + grade);

        int ii = 1;
        switch(ii){
           case 0:
              System.out.println("0");
           case 1:
              System.out.println("1");
           case 2:
              System.out.println("2");
           case 3:
              System.out.println("3"); break;
           default:
              System.out.println("default");
        }
    
        System.out.println("90 �ȵ�����ֵ��" + Math.sin(Math.PI/2));  
        System.out.println("0�ȵ�����ֵ��" + Math.cos(0));  
        System.out.println("60�ȵ�����ֵ��" + Math.tan(Math.PI/3));  
        System.out.println("1�ķ�����ֵ�� " + Math.atan(1));  
        System.out.println("��/2�ĽǶ�ֵ��" + Math.toDegrees(Math.PI/2));  
        System.out.println(Math.PI);  

        double[] nums = { 1.4, 1.5, 1.6, -1.4, -1.5, -1.6 };   
        for (double num : nums) {   
            System.out.println("Math.floor(" + num + ")=" + Math.floor(num));   
            System.out.println("Math.round(" + num + ")=" + Math.round(num));   
            System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num));     
        }  

        char[] helloArray = { 'h', 'e', 'l', 'l', 'o', 'd'};
        String helloString = new String(helloArray);  
        System.out.println( helloString );

        float floatVar = 1.0f;
        int intVar = 0;
        String stringVar = "dugu";

        System.out.printf("�����ͱ�����ֵΪ " +
                  "%f, ���ͱ�����ֵΪ " +
                  " %d, �ַ���������ֵΪ " +
                  "is %s", floatVar, intVar, stringVar);

        StringBuffer sBuffer = new StringBuffer("dugu github��");
        sBuffer.append("www");
        sBuffer.append(".github");
        sBuffer.append(".peefy");
        System.out.println(sBuffer.toString());  

        // �����С
        int size = 10;
        // ��������
        double[] myList = new double[size];
        myList[0] = 5.6;
        myList[1] = 4.5;
        myList[2] = 3.3;
        myList[3] = 13.2;
        myList[4] = 4.0;
        myList[5] = 34.33;
        myList[6] = 34.0;
        myList[7] = 45.45;
        myList[8] = 99.993;
        myList[9] = 11123;
        // ��������Ԫ�ص��ܺ�
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += myList[i];
        }
        System.out.println("�ܺ�Ϊ�� " + total);

        String sarr[][] = new String[2][];
        sarr[0] = new String[2];
        sarr[1] = new String[3];
        sarr[0][0] = new String("Good");
        sarr[0][1] = new String("Luck");
        sarr[1][0] = new String("to");
        sarr[1][1] = new String("you");
        sarr[1][2] = new String("!");
       // ��ʼ�� Date ����
       Date date = new Date();
        
       // ʹ�� toString() ������ʾ����ʱ��
       System.out.println(date.toString());
       Date dNow = new Date( );
       SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
  
       System.out.println("��ǰʱ��Ϊ: " + ft.format(dNow));
       System.out.printf("ȫ�����ں�ʱ����Ϣ��%tc%n",date);          
       //f��ʹ��  
       System.out.printf("��-��-�ո�ʽ��%tF%n",date);  
       //d��ʹ��  
       System.out.printf("��/��/���ʽ��%tD%n",date);  
       //r��ʹ��  
       System.out.printf("HH:MM:SS PM��ʽ��12ʱ�ƣ���%tr%n",date);  
       //t��ʹ��  
       System.out.printf("HH:MM:SS��ʽ��24ʱ�ƣ���%tT%n",date);  
       //R��ʹ��  
       System.out.printf("HH:MM��ʽ��24ʱ�ƣ���%tR",date); 

       try {
           long start = System.currentTimeMillis( );
           System.out.println(new Date( ) + "\n");
           Thread.sleep(5*60*10);
           System.out.println(new Date( ) + "\n");
           long end = System.currentTimeMillis( );
           long diff = end - start;
           System.out.println("Difference is : " + diff);
        } catch (Exception ex) {
           System.out.println("Got an exception!");
           ex.printStackTrace();
       }

       Calendar calendar1 = Calendar.getInstance();
       // ������
       int year = calendar1.get(Calendar.YEAR);
       // ����·�
       int month = calendar1.get(Calendar.MONTH) + 1;
       // �������
       int datec = calendar1.get(Calendar.DATE);
       // ���Сʱ
       int hour = calendar1.get(Calendar.HOUR_OF_DAY);
       // ��÷���
       int minute = calendar1.get(Calendar.MINUTE);
       // �����
       int second = calendar1.get(Calendar.SECOND);
       // ������ڼ���ע�⣨�����Date���ǲ�ͬ�ģ���1���������ա�2��������1��3�������ڶ����Դ����ƣ�
       int day = calendar1.get(Calendar.DAY_OF_WEEK);

       String months[] = {
        "Jan", "Feb", "Mar", "Apr",
        "May", "Jun", "Jul", "Aug",
        "Sep", "Oct", "Nov", "Dec"};
        
        // ��ʼ�� Gregorian ����
        // ʹ�õ�ǰʱ�������
        // Ĭ��Ϊ����ʱ���ʱ��
        GregorianCalendar gcalendar = new GregorianCalendar();
        // ��ʾ��ǰʱ������ڵ���Ϣ
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));
        
        // ���Ե�ǰ����Ƿ�Ϊ����
        if(gcalendar.isLeapYear(year)) {
           System.out.println("��ǰ���������");
        }
        else {
           System.out.println("��ǰ��ݲ�������");
        }

        String content = "I am noob " +
        "from runoob.com.";
 
        String pattern = ".*runoob.*";
 
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("�ַ������Ƿ������ 'runoob' ���ַ���? " + isMatch);
        // ��ָ��ģʽ���ַ�������
        String line = "This order was placed for QT3000! OK?";
        pattern = "(\\D*)(\\d+)(.*)";
    
        // ���� Pattern ����
        Pattern r = Pattern.compile(pattern);
    
        // ���ڴ��� matcher ����
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) ); 
        } else {
            System.out.println("NO MATCH");
        }
        // ���ÿɱ�����ķ���
        printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});

        try {
            char bWrite[] = { 'a', 'b', 'c', 'd', 'e' };
            OutputStream os = new FileOutputStream("test.txt");
            for (int k = 0; k < bWrite.length; k++) {
                os.write(bWrite[k]); // writes the bytes
            }
            os.close();
 
            InputStream is = new FileInputStream("test.txt");
            size = is.available();
 
            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException ex) {
            System.out.print("Exception");
        }
        try {
            File ff = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(ff);
        // ����FileOutputStream����,�ļ������ڻ��Զ��½�
 
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows����gbk
 
        writer.append("��������");
        // д�뵽������
 
        writer.append("\r\n");
        // ����
 
        writer.append("English");
        // ˢ�»����,д�뵽�ļ�,��������Ѿ�û��д���������,ֱ��closeҲ��д��
 
        writer.close();
        // �ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�
 
        fop.close();
        // �ر������,�ͷ�ϵͳ��Դ
 
        FileInputStream fip = new FileInputStream(ff);
        // ����FileInputStream����
 
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // ����InputStreamReader����,������д����ͬ
 
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // ת��char�ӵ�StringBuffer������
        }
        System.out.println(sb.toString());
        reader.close();
        // �رն�ȡ��
 
        fip.close();
        // �ر�������,�ͷ�ϵͳ��Դ

        } catch (Exception ex) {
            //TODO: handle exception
        }   

        String dirname = "./tmp/user/java/bin";
        new File(dirname).mkdirs();
        // ���ڴ���Ŀ¼
        try{
            int arr[] = new int[2];
            System.out.println("Access element three :" + arr[3]);
        }catch(ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        finally{
            System.out.println("Out of the block");
        }
        
        Salary ss = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee ee = new Salary("John Adams", "Boston, MA", 2, 2400.00);
   
        System.out.println("Call mailCheck using Salary reference --");
        ss.mailCheck();
   
        System.out.println("\n Call mailCheck using Employee reference--");
        ee.mailCheck();

        List<String> list=new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("HAHAHAHA");
        //��һ�ֱ�������ʹ��foreach����List
        for (String str : list) {            //Ҳ���Ը�дfor(int i=0;i<list.size();i++)������ʽ
           System.out.println(str);
        }
    
        //�ڶ��ֱ������������Ϊ������ص����ݽ��б���
        String[] strArray=new String[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++) //����Ҳ���Ը�дΪ  foreach(String str:strArray)������ʽ
        {
           System.out.println(strArray[i]);
        }
        
       //�����ֱ��� ʹ�õ�����������ر���
        
        Iterator<String> ite=list.iterator();
        while(ite.hasNext())//�ж���һ��Ԫ��֮����ֵ
        {
            System.out.println(ite.next());
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        
        //��һ�֣��ձ�ʹ�ã�����ȡֵ
        System.out.println("ͨ��Map.keySet����key��value��");
        for (String key : map.keySet()) {
         System.out.println("key= "+ key + " and value= " + map.get(key));
        }
        
        //�ڶ���
        System.out.println("ͨ��Map.entrySetʹ��iterator����key��value��");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
         Map.Entry<String, String> entry = it.next();
         System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        
        //�����֣��Ƽ���������������ʱ
        System.out.println("ͨ��Map.entrySet����key��value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
         System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
      
        //������
        System.out.println("ͨ��Map.values()�������е�value�������ܱ���key");
        for (String v : map.values()) {
         System.out.println("value= " + v);
        }

        // ������ͬ�������飺 Integer, Double �� Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
 
        System.out.println( "��������Ԫ��Ϊ:" );
        printArray( intArray  ); // ����һ����������
 
        System.out.println( "\n˫����������Ԫ��Ϊ:" );
        printArray( doubleArray ); // ����һ��˫����������
 
        System.out.println( "\n�ַ�������Ԫ��Ϊ:" );
        printArray( charArray ); // ����һ���ַ�������

        System.out.printf( "%d, %d �� %d ��������Ϊ %d\n\n",
        3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f �� %.1f ��������Ϊ %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s �� %s ��������Ϊ %s\n","pear",
        "apple", "orange", maximum( "pear", "apple", "orange" ) );

        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();
     
        integerBox.add(new Integer(10));
        stringBox.add(new String("DuGu"));
     
        System.out.printf("����ֵΪ :%d\n\n", integerBox.get());
        System.out.printf("�ַ���Ϊ :%s\n", stringBox.get());

        List<String> nam = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        
        nam.add("icon");
        age.add(18);
        number.add(314);
 
        getData(nam);
        getData(age);
        getData(number);

        Employee emp = new Employee();
        emp.name = "Reyan Ali";
        emp.address = "Phokka Kuan, Ambehta Peer";
        emp.number = 101;
        try
        {
           FileOutputStream fileOut =
           new FileOutputStream("employee.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(emp);
           out.close();
           fileOut.close();
           System.out.printf("Serialized data is saved in /tmp/employee.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
        emp = null;
        try
        {
           FileInputStream fileIn = new FileInputStream("employee.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           emp = (Employee) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
        }catch(ClassNotFoundException ex)
        {
           System.out.println("Employee class not found");
           ex.printStackTrace();
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + emp.name);
        System.out.println("Address: " + emp.address);
        System.out.println("Number: " + emp.number);

        udpDemo();
    
        List<Employee> namedugus = new ArrayList<>();
        namedugus.add(new Employee());
        namedugus.add(new Employee());
        namedugus.add(new Employee());
        Collections.sort(namedugus, (s1, s2) -> s1.number - s2.number);
    }

    public static void udpDemo(){
        try {
            DatagramSocket server = new DatagramSocket(5060);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            //server.receive(packet);
            //System.out.println(packet.getAddress().getHostName() + "(" + packet.getPort() + "):" + new String(packet.getData()));
            packet.setData("Hello Client".getBytes());
            packet.setPort(5070);
            packet.setAddress(InetAddress.getLocalHost());
            server.send(packet);
            server.close();
            System.out.println("udp send!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );
        
        cars.forEach( Car::collide );
        
        cars.forEach( Car::repair );
        
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );

        List<String> names = new ArrayList<>();
        
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
          
        names.forEach(System.out::println);

        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        
        // Predicate<Integer> predicate = n -> true
        // n ��һ���������ݵ� Predicate �ӿڵ� test ����
        // n ��������� test �������� true
          
        System.out.println("�����������:");
          
        // ���ݲ��� n
        eval(list, n->true);
          
        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n ��һ���������ݵ� Predicate �ӿڵ� test ����
        // ��� n%2 Ϊ 0 test �������� true
          
        System.out.println("�������ż��:");
        eval(list, n-> n%2 == 0 );
          
        // Predicate<Integer> predicate2 = n -> n > 3
        // n ��һ���������ݵ� Predicate �ӿڵ� test ����
        // ��� n ���� 3 test �������� true
          
        System.out.println("������� 3 ����������:");
        eval(list, n-> n > 3 );
        /*
        List<Integer> transactionsIds = 
        widgets.stream()
                     .filter(b -> b.getColor() == RED)
                     .sorted((x,y) -> x.getWeight() - y.getWeight())
                     .mapToInt(Widget::getWeight)
                     .sum();
        */
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }

    public static void socketDemo(){
        String serverName = "";
      int port = 9999;
      try
      {
         System.out.println("���ӵ�������" + serverName + " ���˿ںţ�" + port);
         Socket client = new Socket(serverName, port);
         System.out.println("Զ��������ַ��" + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
 
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println("��������Ӧ�� " + in.readUTF());
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }
   // �Ƚ�����ֵ���������ֵ
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {                     
      T max = x; // ����x�ǳ�ʼ���ֵ
      if ( y.compareTo( max ) > 0 ){
         max = y; //y ����
      }
      if ( z.compareTo( max ) > 0 ){
         max = z; // ���� z ����           
      }
      return max; // ����������
   }

    public static < E > void printArray( E[] inputArray )
    {
       // �������Ԫ��            
          for ( E element : inputArray ){        
             System.out.printf( "%s ", element );
          }
          System.out.println();
     }

    public static void printMax( double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }
 
        double result = numbers[0];
 
        for (int i = 1; i <  numbers.length; i++){
            if (numbers[i] >  result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);     
    }

    protected void finalize() throws java.lang.Throwable {  
        super.finalize();  
        System.out.println("Cake Object " + "id" + "is disposed");  
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

