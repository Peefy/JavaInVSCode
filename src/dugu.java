
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
        System.out.println("????·?????????????"+bbool);
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
              System.out.println("优秀"); 
              break;
           case 'B' :
           case 'C' :
              System.out.println("良好");
              break;
           case 'D' :
              System.out.println("及格");
              break;
           case 'F' :
              System.out.println("你需要再努力努力");
              break;
           default :
              System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);

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
    
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));  
        System.out.println("0度的余弦值：" + Math.cos(0));  
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));  
        System.out.println("1的反正切值： " + Math.atan(1));  
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));  
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

        System.out.printf("浮点型变量的值为 " +
                  "%f, 整型变量的值为 " +
                  " %d, 字符串变量的值为 " +
                  "is %s", floatVar, intVar, stringVar);

        StringBuffer sBuffer = new StringBuffer("dugu github：");
        sBuffer.append("www");
        sBuffer.append(".github");
        sBuffer.append(".peefy");
        System.out.println(sBuffer.toString());  

        // 数组大小
        int size = 10;
        // 定义数组
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
        // 计算所有元素的总和
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += myList[i];
        }
        System.out.println("总和为： " + total);

        String sarr[][] = new String[2][];
        sarr[0] = new String[2];
        sarr[1] = new String[3];
        sarr[0][0] = new String("Good");
        sarr[0][1] = new String("Luck");
        sarr[1][0] = new String("to");
        sarr[1][1] = new String("you");
        sarr[1][2] = new String("!");
       // 初始化 Date 对象
       Date date = new Date();
        
       // 使用 toString() 函数显示日期时间
       System.out.println(date.toString());
       Date dNow = new Date( );
       SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
  
       System.out.println("当前时间为: " + ft.format(dNow));
       System.out.printf("全部日期和时间信息：%tc%n",date);          
       //f的使用  
       System.out.printf("年-月-日格式：%tF%n",date);  
       //d的使用  
       System.out.printf("月/日/年格式：%tD%n",date);  
       //r的使用  
       System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);  
       //t的使用  
       System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);  
       //R的使用  
       System.out.printf("HH:MM格式（24时制）：%tR",date); 

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
       // 获得年份
       int year = calendar1.get(Calendar.YEAR);
       // 获得月份
       int month = calendar1.get(Calendar.MONTH) + 1;
       // 获得日期
       int datec = calendar1.get(Calendar.DATE);
       // 获得小时
       int hour = calendar1.get(Calendar.HOUR_OF_DAY);
       // 获得分钟
       int minute = calendar1.get(Calendar.MINUTE);
       // 获得秒
       int second = calendar1.get(Calendar.SECOND);
       // 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
       int day = calendar1.get(Calendar.DAY_OF_WEEK);

       String months[] = {
        "Jan", "Feb", "Mar", "Apr",
        "May", "Jun", "Jul", "Aug",
        "Sep", "Oct", "Nov", "Dec"};
        
        // 初始化 Gregorian 日历
        // 使用当前时间和日期
        // 默认为本地时间和时区
        GregorianCalendar gcalendar = new GregorianCalendar();
        // 显示当前时间和日期的信息
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));
        
        // 测试当前年份是否为闰年
        if(gcalendar.isLeapYear(year)) {
           System.out.println("当前年份是闰年");
        }
        else {
           System.out.println("当前年份不是闰年");
        }

        String content = "I am noob " +
        "from runoob.com.";
 
        String pattern = ".*runoob.*";
 
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        pattern = "(\\D*)(\\d+)(.*)";
    
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
    
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) ); 
        } else {
            System.out.println("NO MATCH");
        }
        // 调用可变参数的方法
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
        // 构建FileOutputStream对象,文件不存在会自动新建
 
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
 
        writer.append("中文输入");
        // 写入到缓冲区
 
        writer.append("\r\n");
        // 换行
 
        writer.append("English");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
 
        writer.close();
        // 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
 
        fop.close();
        // 关闭输出流,释放系统资源
 
        FileInputStream fip = new FileInputStream(ff);
        // 构建FileInputStream对象
 
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // 构建InputStreamReader对象,编码与写入相同
 
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        // 关闭读取流
 
        fip.close();
        // 关闭输入流,释放系统资源

        } catch (Exception ex) {
            //TODO: handle exception
        }   

        String dirname = "./tmp/user/java/bin";
        new File(dirname).mkdirs();
        // 现在创建目录
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
        //第一种遍历方法使用foreach遍历List
        for (String str : list) {            //也可以改写for(int i=0;i<list.size();i++)这种形式
           System.out.println(str);
        }
    
        //第二种遍历，把链表变为数组相关的内容进行遍历
        String[] strArray=new String[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++) //这里也可以改写为  foreach(String str:strArray)这种形式
        {
           System.out.println(strArray[i]);
        }
        
       //第三种遍历 使用迭代器进行相关遍历
        
        Iterator<String> ite=list.iterator();
        while(ite.hasNext())//判断下一个元素之后有值
        {
            System.out.println(ite.next());
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        
        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
         System.out.println("key= "+ key + " and value= " + map.get(key));
        }
        
        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
         Map.Entry<String, String> entry = it.next();
         System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        
        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
         System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
      
        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
         System.out.println("value= " + v);
        }

        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
 
        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组
 
        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组
 
        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组

        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
        3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
        "apple", "orange", maximum( "pear", "apple", "orange" ) );

        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();
     
        integerBox.add(new Integer(10));
        stringBox.add(new String("DuGu"));
     
        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());

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
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true
          
        System.out.println("输出所有数据:");
          
        // 传递参数 n
        eval(list, n->true);
          
        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true
          
        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );
          
        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true
          
        System.out.println("输出大于 3 的所有数字:");
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
         System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
         Socket client = new Socket(serverName, port);
         System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
 
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println("服务器响应： " + in.readUTF());
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }
   // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {                     
      T max = x; // 假设x是初始最大值
      if ( y.compareTo( max ) > 0 ){
         max = y; //y 更大
      }
      if ( z.compareTo( max ) > 0 ){
         max = z; // 现在 z 更大           
      }
      return max; // 返回最大对象
   }

    public static < E > void printArray( E[] inputArray )
    {
       // 输出数组元素            
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

