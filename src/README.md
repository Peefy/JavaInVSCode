 String\[\] args和String args\[\]都可以运行，但推荐使用String\[\] args
javac 和 java javac 后面跟着的是java文件的文件名，例如 HelloWorld.java。 该命令用于将 java 源文件编译为 class 字节码文件，如： javac HelloWorld.java。
注意：java命令后面不要加.class。

* 对象：对象是类的一个实例，有状态和行为。
* 类：类是一个模板，它描述一类对象的行为和状态。
* 方法：方法就是行为，一个类可以有很多方法。逻辑运算、数据修改以及所有动作都是在方法中完成的。
* 实例变量：每个对象都有独特的实例变量，对象的状态由这些实例变量的值决定。

```java
public class HelloWorld {
    /* 第一个Java程序
     * 它将打印字符串 Hello World
     */
    public static void main(String []args) {
        System.out.println("Hello World"); // 打印 Hello World
    }
}
```

**基本语法**

* **大小写敏感** Java 是大小写敏感的，这就意味着标识符 Hello 与 hello 是不同的。
* **类名** 对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 MyFirstJavaClass 。
* **方法名** 所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
* **主方法入口** 所有的 Java 程序由 public static void main(String []args) 方法开始执行。


**Java标识符**

Java 所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。

* 所有的标识符都应该以字母（A-Z 或者 a-z）,美元符（$）、或者下划线（_）开始
* 首字符之后可以是字母（A-Z 或者 a-z）,美元符（$）、下划线（_）或数字的任何字符组合
* 关键字不能用作标识符
* 标识符是大小写敏感的
* 合法标识符举例：age、$salary、_value、__1_value
* 非法标识符举例：123abc、-salary

**Java修饰符**

像其他语言一样，Java可以使用修饰符来修饰类中方法和属性。主要有两类修饰符：

* 访问控制修饰符 : `default`, `public` , `protected`, `private`
* 非访问控制修饰符 : `final`, `abstract`, `static`, `synchronized`

**Java变量**

* 局部变量
* 类变量（静态变量）
* 成员变量（非静态变量）

**Java数组**

数组是储存在堆上的对象，可以保存多个同类型变量。在后面的章节中，我们将会学到如何声明、构造以及初始化一个数组

**Java枚举**

Java 5.0引入了枚举，枚举限制变量只能是预先设定好的值。使用枚举可以减少代码中的bug。

```java

class FreshJuice {
   enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }
   FreshJuiceSize size;
}
 
public class FreshJuiceTest {
   public static void main(String []args){
      FreshJuice juice = new FreshJuice();
      juice.size = FreshJuice.FreshJuiceSize.MEDIUM  ;
   }
}

```

**Java关键字**

类别|关键字|说明
-|-|-
访问控制|private|私有的
-|protected|受保护的
-|public|公共的
||
类、方法和变量修饰符|abstract|声明抽象
-|class|类
-|extends|扩充，继承(类)
-|final|最终值，不可改变
-|implements|实现(接口)
-|interface|接口
-|native|本地,原生方法(非Java实现)
-|new|新,创建
-|static|静态
-|strictfp|严格,精准
-|synchronized|线程,同步
-|transient|短暂
-|volatile|易失
||
程序控制语句|break|跳出循环
-|case|定义一个值以供switch选择
-|continue|继续
-|default|默认
-|do|运行
-|else|否则
-|for|循环
-|if|如果
-|instanceof|实例
-|return|返回
-|switch|根据值选择执行
-|while|循环
||
错误类型|assert|断言表达式是否为真
-|catch|捕捉异常
-|finally|有没有异常都执行
-|throw|抛出一个异常对象
-|throws|声明一个异常可能被抛出
-|try|捕获异常
||
包相关|import|引入
-|package|包
||
基本类型|boolean|布尔型
-|byte|字节型
-|char|字符型
-|double|双精度浮点
-|float|单精度浮点
-|int|整型
-|long|长整型
-|short|短整型
||
变量引用|super|父类,超类
-|this|本类
-|void|无返回值
||
保留关键字|goto|是关键字，但不能使用
-|const|是关键字，但不能使用
-|null|空


**Java注释**

类似于 C/C++、Java 也支持单行以及多行注释。注释中的字符将被 Java 编译器忽略。

```java
public class HelloWorld {
   /* 这是第一个Java程序
    *它将打印Hello World
    * 这是一个多行注释的示例
    */
    public static void main(String []args){
       // 这是单行注释的示例
       /* 这个也是单行注释的示例 */
       System.out.println("Hello World"); 
    }
}
```

**Java空行**

空白行或者有注释的行，Java 编译器都会忽略掉。

**Java继承**

在 Java 中，一个类可以由其他类派生。如果你要创建一个类，而且已经存在一个类具有你所需要的属性或方法，那么你可以将新创建的类继承该类。

利用继承的方法，可以重用已存在类的方法和属性，而不用重写这些代码。被继承的类称为超类（super class），派生类称为子类（subclass）。

**Java接口**

在 Java 中，接口可理解为对象间相互通信的协议。接口在继承中扮演着很重要的角色。
接口只定义派生要用到的方法，但是方法的具体实现完全取决于派生类。

**Java对象**

Java作为一种面向对象语言。支持以下基本概念：

* **多态**
* **继承**
* **封装**
* **抽象**
* **类**
* **对象**
* **实例**
* **方法**
* **重载**

*对象*：对象是类的一个实例（对象不是找个女朋友），有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。

*类*：类是一个模板，它描述一类对象的行为和状态。

```java
public class Dog{
  String breed;
  int age;
  String color;
  void barking(){
  }
 
  void hungry(){
  }
 
  void sleeping(){
  }
}
```

一个类可以包含以下类型的变量

* **局部变量**:在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明和初始化都是在方法中，方法结束后，变量就会自动销毁。
* **成员变量**:成员变量是定义在类中，方法体之外的变量。这种变量在创建对象的时候实例化。成员变量可以被类中方法、构造方法和特定类的语句块访问。
* **类变量**:类变量也声明在类中，方法体之外，但必须声明为static类型。

一个类可以拥有多个方法，在上面的例子中：barking()、hungry()和sleeping()都是Dog类的方法。

**Java类的构造方法**

每个类都有构造方法。如果没有显式地为类定义构造方法，Java编译器将会为该类提供一个默认构造方法。

在创建一个对象的时候，至少要调用一个构造方法。构造方法的名称必须与类同名，一个类可以有多个构造方法。

下面是一个构造方法示例：

```java
public class Puppy{
    public Puppy(){
    }
 
    public Puppy(String name){
        // 这个构造器仅有一个参数：name
    }
}
```

**Java创建对象**

对象是根据类创建的。在Java中，使用关键字new来创建一个新的对象。创建对象需要以下三步：
* **声明**:声明一个对象，包括对象名称和对象类型。
* **实例化**:使用关键字new来创建一个对象。
* **初始化**:使用new创建对象时，会调用构造方法初始化对象。

```java
public class Puppy{
   public Puppy(String name){
      //这个构造器仅有一个参数：name
      System.out.println("小狗的名字是 : " + name ); 
   }
   public static void main(String[] args){
      // 下面的语句将创建一个Puppy对象
      Puppy myPuppy = new Puppy( "tommy" );
   }
}
```

**访问实例变量和方法**

```java
public class Puppy{
   int puppyAge;
   public Puppy(String name){
      // 这个构造器仅有一个参数：name
      System.out.println("小狗的名字是 : " + name ); 
   }
 
   public void setAge( int age ){
       puppyAge = age;
   }
 
   public int getAge( ){
       System.out.println("小狗的年龄为 : " + puppyAge ); 
       return puppyAge;
   }
 
   public static void main(String[] args){
      /* 创建对象 */
      Puppy myPuppy = new Puppy( "tommy" );
      /* 通过方法来设定age */
      myPuppy.setAge( 2 );
      /* 调用另一个方法获取age */
      myPuppy.getAge( );
      /*你也可以像下面这样访问成员变量 */
      System.out.println("变量值 : " + myPuppy.puppyAge ); 
   }
}
```

**源文件声明规则**

当在一个源文件中定义多个类，并且还有import语句和package语句时，要特别注意这些规则。

* 一个源文件中只能有一个public类
* 一个源文件可以有多个非public类
* 源文件的名称应该和public类的类名保持一致。例如：源文件中public类的类名是Employee，那么源文件应该命名为Employee.java。
* 如果一个类定义在某个包中，那么package语句应该在源文件的首行。
* 如果源文件包含import语句，那么应该放在package语句和类定义之间。如果没有package语句，那么import语句应该在源文件中最前面。
* import语句和package语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。

**Java包**

包主要用来对类和接口进行分类。当开发Java程序时，可能编写成百上千的类，因此很有必要对类和接口进行分类。

**Import语句**

在Java中，如果给出一个完整的限定名，包括包名、类名，那么Java编译器就可以很容易地定位到源代码或者类。Import语句就是用来提供一个合理的路径，使得编译器可以找到某个类。

例如，下面的命令行将会命令编译器载入java_installation/java/io路径下的所有类

**Java基本数据类型**

变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。

内存管理系统根据变量的类型为变量分配存储空间，分配的空间只能用来储存该类型数据。

Java的两大数据类型
* 内置数据类型
* 引用数据类型

**内置数据类型**

Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。

*byte*
* byte 数据类型是8位、有符号的，以二进制补码表示的整数；
* 最小值是 `-128(-2^7)`；
* 最大值是 `127(2^7-1)`；
* 默认值是 `0`；
* byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
* 例子：byte a = 100，byte b = -50。

*short*
* short 数据类型是 16 位、有符号的以二进制补码表示的整数
* 最小值是 `-32768(-2^15)`；
* 最大值是 `32767(2^15 - 1)`；
* Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
* 默认值是 `0`；
* 例子：short s = 1000，short r = -20000。

*int*
* int 数据类型是32位、有符号的以二进制补码表示的整数；
* 最小值是 `-2,147,483,648(-2^31)`；
* 最大值是 `2,147,483,647(2^31 - 1)`；
* 一般地整型变量默认为 int 类型；
* 默认值是 `0` ；
* 例子：int a = 100000, int b = -200000。

*long*
* long 数据类型是 64 位、有符号的以二进制补码表示的整数；
* 最小值是 `-9,223,372,036,854,775,808(-2^63)`；
* 最大值是 `9,223,372,036,854,775,807(2^63 -1)`；
* 这种类型主要使用在需要比较大整数的系统上；
* 默认值是 `0L`；
* 例子： long a = 100000L，Long b = -200000L。
"L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写

*float*
* float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
* float 在储存大型浮点数组的时候可节省内存空间；
* 默认值是 `0.0f`；
* 浮点数不能用来表示精确的值，如货币；
* 例子：float f1 = 234.5f。

*double*
* double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；
* 浮点数的默认类型为double类型；
* double类型同样不能表示精确的值，如货币；
* 默认值是 `0.0d`；
* 例子：double d1 = 123.4。

*boolean*
* boolean数据类型表示一位的信息；
* 只有两个取值：true 和 false；
* 这种类型只作为一种标志来记录 true/false 情况；
* 默认值是 `false`；
* 例子：boolean one = true。

*char*
* char类型是一个单一的 16 位 Unicode 字符；
* 最小值是 `\u0000`（即为0）；
* 最大值是 `\uffff`（即为65,535）；
* char 数据类型可以储存任何字符；
* 例子：char letter = 'A';。

```
public class PrimitiveTypeTest {  
    public static void main(String[] args) {  
        // byte  
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);  
        System.out.println("包装类：java.lang.Byte");  
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);  
        System.out.println();  
  
        // short  
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);  
        System.out.println("包装类：java.lang.Short");  
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);  
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);  
        System.out.println();  
  
        // int  
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);  
        System.out.println("包装类：java.lang.Integer");  
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);  
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);  
        System.out.println();  
  
        // long  
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);  
        System.out.println("包装类：java.lang.Long");  
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);  
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);  
        System.out.println();  
  
        // float  
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);  
        System.out.println("包装类：java.lang.Float");  
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);  
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);  
        System.out.println();  
  
        // double  
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);  
        System.out.println("包装类：java.lang.Double");  
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);  
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);  
        System.out.println();  
  
        // char  
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);  
        System.out.println("包装类：java.lang.Character");  
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台  
        System.out.println("最小值：Character.MIN_VALUE="  
                + (int) Character.MIN_VALUE);  
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台  
        System.out.println("最大值：Character.MAX_VALUE="  
                + (int) Character.MAX_VALUE);  
    }  
}
```

**引用数据类型**

* 在Java中，引用类型的变量非常类似于C/C++的指针。引用类型指向一个对象，指向对象的变量是引用变量。这些变量在声明时被指定为一个特定的类型，比如 Employee、Puppy 等。变量一旦声明后，类型就不能被改变了。
* 对象、数组都是引用数据类型。
* 所有引用类型的默认值都是null。
* 一个引用变量可以用来引用任何与之兼容的类型。
* 例子：Site site = new Site("Runoob")。

**Java常量**

常量在程序运行时是不能被修改的。在 Java 中使用 final 关键字来修饰常量，声明方式和变量类似：
```java
final double PI = 3.1415927;
```

*java转义字符*
符号|字符含义
\n|换行 (0x0a)
\r|回车 (0x0d)
\f|换页符(0x0c)
\b|退格 (0x08)
\0|空字符 (0x20)
\s|字符串
\t|制表符
\"|双引号
\'|单引号
\\\\|反斜杠
\ddd|八进制字符 (ddd)
\uxxxx|16进制Unicode字符 (xxxx)

**Java自动类型转换**

整型、实型（常量）、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。

* 1.不能对boolean类型进行类型转换。
* 2.不能把对象类型转换成不相关类的对象。
* 3.在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
* 4.转换过程中可能导致溢出或损失精度，例如：
```java
int i =128;   
byte b = (byte)i;
```
* 5.浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入，例如：
```java
(int)23.7 == 23;        
(int)-45.89f == -45
```

必须满足转换前的数据类型的位数要低于转换后的数据类型，例如: short数据类型的位数为16位，就可以自动转换位数为32的int类型，同样float数据类型的位数为32，可以自动转换为64位的double类型。

```java
public class ZiDongLeiZhuan{
        public static void main(String[] args){
            char c1='a';//定义一个char类型
            int i1 = c1;//char自动类型转换为int
            System.out.println("char自动类型转换为int后的值等于"+i1);
            char c2 = 'A';//定义一个char类型
            int i2 = c2+1;//char 类型和 int 类型计算
            System.out.println("char类型和int计算后的值等于"+i2);
        }
}
```

**强制类型转换**

* 条件是转换的数据类型必须是兼容的。
* 格式：(type)value type是要强制类型转换后的数据类型 实例：

```java
int i1 = 123;
byte b = (byte)i1;//强制类型转换为byte
System.out.println("int强制类型转换为byte后的值等于"+b);
```

**隐含强制类型转换**

* 整数的默认类型是 int。
* 浮点型不存在这种情况，因为在定义 float 类型时必须在数字后面跟上 F 或者 f。

**Java变量类型**

在Java语言中，所有的变量在使用前必须声明。声明变量的基本格式如下：
```java
type identifier [ = value][, identifier [= value] ...] ;
```
```java
int a, b, c;         // 声明三个int型整数：a、 b、c
int d = 3, e = 4, f = 5; // 声明三个整数并赋予初值
byte z = 22;         // 声明并初始化 z
String s = "runoob";  // 声明并初始化字符串 s
double pi = 3.14159; // 声明了双精度浮点型变量 pi
char x = 'x';        // 声明变量 x 的值是字符 'x'。
```

Java语言支持的变量类型有：
* 类变量：独立于方法之外的变量，用 static 修饰。
* 实例变量：独立于方法之外的变量，不过没有 static 修饰。
* 局部变量：类的方法中的变量。
```java
public class Variable{
    static int allClicks=0;    // 类变量
    String str="hello world";  // 实例变量
    public void method(){
        int i =0;  // 局部变量
    }
}
```

**Java局部变量**
* 局部变量声明在方法、构造方法或者语句块中；
* 局部变量在方法、构造方法、或者语句块被执行的时候创建，当它们执行完成后，变量将会被销毁；
* 访问修饰符不能用于局部变量；
* 局部变量只在声明它的方法、构造方法或者语句块中可见；
* 局部变量是在栈上分配的。
* 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。

**Java实例变量**
* 实例变量声明在一个类中，但在方法、构造方法和语句块之外；
* 当一个对象被实例化之后，每个实例变量的值就跟着确定；
* 实例变量在对象创建的时候创建，在对象被销毁的时候销毁；
* 实例变量的值应该至少被一个方法、构造方法或者语句块引用，使得外部能够通过这些方式获取实例变量信息；
* 实例变量可以声明在使用前或者使用后；
* 访问修饰符可以修饰实例变量；
* 实例变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把实例变量设为私有。通过使用访问修饰符可以使实例变量对子类可见；
* 实例变量具有默认值。数值型变量的默认值是0，布尔型变量的默认值是false，引用类型变量的默认值是null。变量的值可以在声明时指定，也可以在构造方法中指定；
* 实例变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名：ObejectReference.VariableName。

**Java类变量（静态变量）**
* 变量也称为静态变量，在类中以 static 关键字声明，但必须在方法之外。
* 无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
* 静态变量除了被声明为常量外很少使用。常量是指声明为public/private，final和static类型的变量。常量初始化后不可改变。
* 静态变量储存在静态存储区。经常被声明为常量，很少单独使用static声明变量。
* 静态变量在第一次被访问时创建，在程序结束时销毁。
* 与实例变量具有相似的可见性。但为了对类的使用者可见，大多数静态变量声明为public类型。
* 默认值和实例变量相似。数值型变量默认值是0，布尔型默认值是false，引用类型默认值是null。变量的值可以在声明的时候指定，也可以在构造方法中指定。此外，静态变量还可以在静态语句块中初始化。
* 静态变量可以通过：ClassName.VariableName的方式访问。
* 类变量被声明为public static final类型时，类变量名称一般建议使用大写字母。如果静态变量不是public和final类型，其命名方式与实例变量以及局部变量的命名方式一致。

**Java访问控制修饰符**

* **default** (即缺省，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
* **private** 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
* **public** 对所有类可见。使用对象：类、接口、变量、方法
* **protected** 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。

*默认访问修饰符-不使用任何关键字*
使用默认访问修饰符声明的变量和方法，对同一个包内的类是可见的。接口里的变量都隐式声明为 `public static final`,而接口里的方法默认情况下访问权限为 `public`。

*私有访问修饰符-private*
私有访问修饰符是最严格的访问级别，所以被声明为 private 的方法、变量和构造方法只能被所属类访问，并且类和接口不能声明为 private。

声明为私有访问类型的变量只能通过类中公共的 getter 方法被外部类访问。

Private 访问修饰符的使用主要用来隐藏类的实现细节和保护类的数据。

下面的类使用了私有访问修饰符：

*公有访问修饰符-public*
被声明为 public 的类、方法、构造方法和接口能够被任何其他类访问。

如果几个相互访问的 public 类分布在不同的包中，则需要导入相应 public 类所在的包。由于类的继承性，类所有的公有方法和变量都能被其子类继承。

以下函数使用了公有访问控制：

*受保护的访问修饰符-protected*
protected 需要从以下两个点来分析说明：

子类与基类在同一包中：被声明为 protected 的变量、方法和构造器能被同一个包中的任何其他类访问；

子类与基类不在同一包中：那么在子类中，子类实例可以访问其从基类继承而来的 protected 方法，而不能访问基类实例的protected方法。

**访问控制和继承**

* 父类中声明为 public 的方法在子类中也必须为 public。
* 父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
* 父类中声明为 private 的方法，不能够被继承

**Java非访问控制修饰符**

为了实现一些其他的功能，Java 也提供了许多非访问修饰符。

static 修饰符，用来修饰类方法和类变量。

final 修饰符，用来修饰类、方法和变量，final 修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。

abstract 修饰符，用来创建抽象类和抽象方法。

synchronized 和 volatile 修饰符，主要用于线程的编程。

*static修饰符*
* **静态变量**：static 关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。 静态变量也被称为类变量。局部变量不能被声明为 static 变量。
* **静态方法**：static 关键字用来声明独立于对象的静态方法。静态方法不能使用类的非静态变量。静态方法从参数列表得到数据，然后计算这些数据。

```java
public class InstanceCounter {
   private static int numInstances = 0;
   protected static int getCount() {
      return numInstances;
   }
 
   private static void addInstance() {
      numInstances++;
   }
 
   InstanceCounter() {
      InstanceCounter.addInstance();
   }
 
   public static void main(String[] arguments) {
      System.out.println("Starting with " +
      InstanceCounter.getCount() + " instances");
      for (int i = 0; i < 500; ++i){
         new InstanceCounter();
          }
      System.out.println("Created " +
      InstanceCounter.getCount() + " instances");
   }
}
```

**final修饰符**

*final变量*
final 表示"最后的、最终的"含义，变量一旦赋值后，不能被重新赋值。被 final 修饰的实例变量必须显式指定初始值。

final 修饰符通常和 static 修饰符一起使用来创建类常量。

```java
public class Test{
  final int value = 10;
  // 下面是声明常量的实例
  public static final int BOXWIDTH = 6;
  static final String TITLE = "Manager";
 
  public void changeValue(){
     value = 12; //将输出一个错误
  }
}
```

*final方法*
类中的 final 方法可以被子类继承，但是不能被子类修改。

声明 final 方法的主要目的是防止该方法的内容被修改。

如下所示，使用 final 修饰符声明方法。

*final类*
final 类不能被继承，没有类能够继承 final 类的任何特性。

**abstract 修饰符**
*抽象类*：

抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。

一个类不能同时被 abstract 和 final 修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。

抽象类可以包含抽象方法和非抽象方法。

```java
abstract class Caravan{
   private double price;
   private String model;
   private String year;
   public abstract void goFast(); //抽象方法
   public abstract void changeColor();
}
```

*抽象方法*
抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。

抽象方法不能被声明成 final 和 static。

任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。

如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。抽象类可以不包含抽象方法。

抽象方法的声明以分号结尾，例如：public abstract sample();

**synchronized 修饰符**

synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于*四个访问*修饰符。

*transient 修饰符*
序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。

该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。

```java
public transient int limit = 55;   // 不会持久化
public int b; // 持久化
```

*volatile 修饰符*
volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。

一个 volatile 对象引用可能是 null。
```java
public class MyRunnable implements Runnable
{
    private volatile boolean active;
    public void run()
    {
        active = true;
        while (active) // 第一行
        {
            // 代码
        }
    }
    public void stop()
    {
        active = false; // 第二行
    }
}
```

**Java运算符**

计算机的最基本用途之一就是执行数学运算，作为一门计算机语言，Java也提供了一套丰富的运算符来操纵变量。我们可以把运算符分成以下几组：

* 算术运算符
* 关系运算符
* 位运算符
* 逻辑运算符
* 赋值运算符
* 其他运算符

**算术运算符**
算术运算符用在数学表达式中，它们的作用和在数学中的作用一样。下表列出了所有的算术运算符。

表格中的实例假设整数变量A的值为10，变量B的值为20：

操作符|描述|例子
-|-|-
+|加法 - 相加运算符两侧的值|A + B 等于 30
-|减法 - 左操作数减去右操作数|A – B 等于 -10
*|乘法 - 相乘操作符两侧的值|A * B等于200
/|除法 - 左操作数除以右操作数|B / A等于2
%|取余 - 左操作数除以右操作数的余数|B%A等于0
++|自增: 操作数的值增加1|	B++ 或 ++B 等于 21
--|自减: 操作数的值减少1|B-- 或 --B 等于 19

```java

     int a = 10;
     int b = 20;
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
     // 查看  d++ 与 ++d 的不同
     System.out.println("d++   = " +  (d++) );
     System.out.println("++d   = " +  (++d) );

```

```java

        int a = 5;//定义一个变量；
        int b = 5;
        int x = 2*++a;
        int y = 2*b++;
        System.out.println("自增运算符前缀运算后a="+a+",x="+x);
        System.out.println("自增运算符后缀运算后b="+b+",y="+y);

```

**关系运算符**

运算符|描述|例子
-|-|-
==|检查如果两个操作数的值是否相等，如果相等则条件为真。|（A == B）为假。
!=|检查如果两个操作数的值是否相等，如果值不相等则条件为真。|(A != B) 为真。
\>|检查左操作数的值是否大于右操作数的值，如果是那么条件为真。|（A> B）为假。
\<|检查左操作数的值是否小于右操作数的值，如果是那么条件为真。|	（A <B）为真。
\>=|检查左操作数的值是否大于或等于右操作数的值，如果是那么条件为真。|（A> = B）为假。
\<=|检查左操作数的值是否小于或等于右操作数的值，如果是那么条件为真。|（A <= B）为真。

```java

     int a = 10;
     int b = 20;
     System.out.println("a == b = " + (a == b) );
     System.out.println("a != b = " + (a != b) );
     System.out.println("a > b = " + (a > b) );
     System.out.println("a < b = " + (a < b) );
     System.out.println("b >= a = " + (b >= a) );
     System.out.println("b <= a = " + (b <= a) );

```

**位运算符**

Java定义了位运算符，应用于整数类型(int)，长整型(long)，短整型(short)，字符型(char)，和字节型(byte)等类型。

位运算符作用在所有的位上，并且按位运算。假设a = 60，b = 13;它们的二进制格式表示将如下：

```java
A = 0011 1100
B = 0000 1101
-----------------
A&b = 0000 1100
A | B = 0011 1101
A ^ B = 0011 0001
~A= 1100 0011
```

操作符|描述|例子
-|-|-
&|如果相对应位都是1，则结果为1，否则为0|（A＆B），得到12，即0000 1100
\||如果相对应位都是0，则结果为0，否则为1|（A | B）得到61，即 0011 1101
^|如果相对应位值相同，则结果为0，否则为1|（A ^ B）得到49，即 0011 0001
~|按位取反运算符翻转操作数的每一位，即0变成1，1变成0。|（〜A）得到-61，即1100 0011
\<\<|按位左移运算符。左操作数按位左移右操作数指定的位数。|A << 2得到240，即 1111 0000
\>\>|按位右移运算符。左操作数按位右移右操作数指定的位数。|A >> 2得到15即 1111
\>\>\>|按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。|A>>>2得到15即0000 1111

```java
     int a = 60; /* 60 = 0011 1100 */ 
     int b = 13; /* 13 = 0000 1101 */
     int c = 0;
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
```

**逻辑运算符**

操作符|描述|例子
&&|称为逻辑与运算符。当且仅当两个操作数都为真，条件才为真。|（A && B）为假。
\|\||称为逻辑或操作符。如果任何两个操作数任何一个为真，条件为真。|（A | | B）为真。
!|称为逻辑非运算符。用来反转操作数的逻辑状态。如果条件为true，则逻辑非运算符将得到false。|！（A && B）为真。

```java
     boolean a = true;
     boolean b = false;
     System.out.println("a && b = " + (a&&b));
     System.out.println("a || b = " + (a||b) );
     System.out.println("!(a && b) = " + !(a && b));
```

*逻辑运算符短路*
当使用与逻辑运算符时，在两个操作数都为true时，结果才为true，但是当得到第一个操作为false时，其结果就必定是false，这时候就不会再判断第二个操作了。
```java
        int a = 5;//定义一个变量；
        boolean b = (a<4)&&(a++<10);
        System.out.println("使用短路逻辑运算符的结果为"+b);
        System.out.println("a的结果为"+a);
```

**赋值运算符**
操作数|描述|例子
-|-|-
=|简单的赋值运算符，将右操作数的值赋给左侧操作数|	C = A + B将把A + B得到的值赋给C
+=|加和赋值操作符，它把左操作数和右操作数相加赋值给左操作数|C + = A等价于C = C + A
-=|减和赋值操作符，它把左操作数和右操作数相减赋值给左操作数|	C - = A等价于C =C-A
*=|乘和赋值操作符，它把左操作数和右操作数相乘赋值给左操作数|C * = A等价于C = C * A
/=|除和赋值操作符，它把左操作数和右操作数相除赋值给左操作数|C / = A等价于C = C / A
(%)=|取模和赋值操作符，它把左操作数和右操作数取模后赋值给左操作数|C％= A等价于C = C％A
\<\<=|左移位赋值运算符|C << = 2等价于C = C << 2
\>\>=|右移位赋值运算符|C >> = 2等价于C = C >> 2
&=|按位与赋值运算符|C&= 2等价于C = C＆2
^=|按位异或赋值操作符|C ^ = 2等价于C = C ^ 2
\|=|按位或赋值操作符|C | = 2等价于C = C | 2

```java
        int a = 10;
        int b = 20;
        int c = 0;
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
```

**条件运算符(?:)**

条件运算符也被称为三元运算符。该运算符有3个操作数，并且需要判断布尔表达式的值。该运算符的主要是决定哪个值应该赋值给变量。

```java
variable x = (expression) ? value if true : value if false
```

```java
      int a , b;
      a = 10;
      // 如果 a 等于 1 成立，则设置 b 为 20，否则为 30
      b = (a == 1) ? 20 : 30;
      System.out.println( "Value of b is : " +  b );
 
      // 如果 a 等于 10 成立，则设置 b 为 20，否则为 30
      b = (a == 10) ? 20 : 30;
      System.out.println( "Value of b is : " + b );
```

**instanceof运算符**

该运算符用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。

instanceof运算符使用格式如下：

```java
( Object reference variable ) instanceof  (class/interface type)
```

如果运算符左侧变量所指的对象，是操作符右侧类或接口(class/interface)的一个对象，那么结果为真。

下面是一个例子：
```java
String name = "James";
boolean result = name instanceof String; // 由于 name 是 String 类型，所以返回真
```

```java
class Vehicle {}
 
public class Car extends Vehicle {
   public static void main(String[] args){
      Vehicle a = new Car();
      boolean result =  a instanceof Car;
      System.out.println( result);
   }
}
```

**Java运算符优先级**

当多个运算符出现在一个表达式中，谁先谁后呢？这就涉及到运算符的优先级别的问题。在一个多运算符的表达式中，运算符优先级不同会导致最后得出的结果差别甚大。

例如，（1+3）＋（3+2）*2，这个表达式如果按加号最优先计算，答案就是 18，如果按照乘号最优先，答案则是 14。

再如，x = 7 + 3 * 2;这里x得到13，而不是20，因为乘法运算符比加法运算符有较高的优先级，所以先计算3 * 2得到6，然后再加7。

下表中具有最高优先级的运算符在的表的最上面，最低优先级的在表的底部。

类别|操作符|关联性
-|-|-
后缀|	() [] . (点操作符)|左到右
一元|+ + - ！〜|从右到左
乘性|* /%|左到右
加性|+ -|左到右
移位 |	>> >>>  << |左到右
关系 |>> = << = |左到右
相等|==  !=|左到右
按位与|&|左到右
按位异或|^|左到右
按位或|\||左到右
逻辑与|&&|左到右
逻辑或|\|\||左到右
条件|?:|从右到左
赋值|= + = - = * = / =%= >> = << =＆= ^ = \| =|从右到左
逗号|,|	左到右

**Java循环结构-for,while及do...while**

顺序结构的程序语句只能被执行一次。如果您想要同样的操作执行多次,，就需要使用循环结构。

Java中有三种主要的循环结构：

* while 循环
* do…while 循环
* for 循环

```java
public class Test {
   public static void main(String args[]) {
      int x = 10;
      while( x < 20 ) {
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }
   }
}
```

```java
public class Test {
   public static void main(String args[]){
      int x = 10;
 
      do{
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }while( x < 20 );
   }
}
```

**for循环**

然所有循环结构都可以用 while 或者 do...while表示，但 Java 提供了另一种语句 —— for 循环，使一些循环结构变得更加简单。

for循环执行的次数是在执行前就确定的。语法格式如下：

关于for循环有有以下几点说明：
* 最先执行初始化步骤。可以声明一种类型，但可初始化一个或多个循环控制变量，也可以是空语句。
* 然后，检测布尔表达式的值。如果为 true，循环体被执行。如果为false，循环终止，开始执行循环体后面的语句。
* 执行一次循环后，更新循环控制变量。
* 再次检测布尔表达式。循环执行上面的过程。

```java
public class Test {
   public static void main(String args[]) {
      for(int x = 10; x < 20; x = x+1) {
         System.out.print("value of x : " + x );
         System.out.print("\n");
      }
   }
}
```

**Java增强for循环**

Java5 引入了一种主要用于数组的增强型 for 循环。

Java 增强 for 循环语法格式如下:

```java
for(声明语句 : 表达式)
{
   //代码句子
}
```

**声明语句**：声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块，其值与此时数组元素的值相等。

**表达式**：表达式是要访问的数组名，或者是返回值为数组的方法。

```java
public class Test {
   public static void main(String args[]){
      int [] numbers = {10, 20, 30, 40, 50};
 
      for(int x : numbers ){
         System.out.print( x );
         System.out.print(",");
      }
      System.out.print("\n");
      String [] names ={"James", "Larry", "Tom", "Lacy"};
      for( String name : names ) {
         System.out.print( name );
         System.out.print(",");
      }
   }
}
```

**break关键字**

break 主要用在循环语句或者 switch 语句中，用来跳出整个语句块。

break 跳出最里层的循环，并且继续执行该循环下面的语句。

```java
public class Test {
   public static void main(String args[]) {
      int [] numbers = {10, 20, 30, 40, 50};
 
      for(int x : numbers ) {
         // x 等于 30 时跳出循环
         if( x == 30 ) {
            break;
         }
         System.out.print( x );
         System.out.print("\n");
      }
   }
}
```

**continue关键字**

continue 适用于任何循环控制结构中。作用是让程序立刻跳转到下一次循环的迭代。

在 for 循环中，continue 语句使程序立即跳转到更新语句。

在 while 或者 do…while 循环中，程序立即跳转到布尔表达式的判断语句。

语法
continue 就是循环体中一条简单的语句：

```java
public class Test {
   public static void main(String args[]) {
      int [] numbers = {10, 20, 30, 40, 50};
 
      for(int x : numbers ) {
         if( x == 30 ) {
        continue;
         }
         System.out.print( x );
         System.out.print("\n");
      }
   }
}
```

**Java 条件语句 - if...else**

如果布尔表达式的值为 true，则执行 if 语句中的代码块，否则执行 if 语句块后面的代码。

```java
public class Test {
   public static void main(String args[]){
      int x = 10;
      if( x < 20 ){
         System.out.print("这是 if 语句");
      }
   }
}
```

```java
public class Test {
   public static void main(String args[]){
      int x = 30;
      if( x < 20 ){
         System.out.print("这是 if 语句");
      }else{
         System.out.print("这是 else 语句");
      }
   }
}
```

**if...else if...else 语句**

if 语句后面可以跟 else if…else 语句，这种语句可以检测到多种可能的情况。

使用 if，else if，else 语句的时候，需要注意下面几点：
* if 语句至多有 1 个 else 语句，else 语句在所有的 else if 语句之后。
* if 语句可以有若干个 else if 语句，它们必须在 else 语句之前。
* 一旦其中一个 else if 语句检测为 true，其他的 else if 以及 else 语句都将跳过执行。

```java
public class Test {
   public static void main(String args[]){
      int x = 30;
      if( x == 10 ){
         System.out.print("Value of X is 10");
      }else if( x == 20 ){
         System.out.print("Value of X is 20");
      }else if( x == 30 ){
         System.out.print("Value of X is 30");
      }else{
         System.out.print("这是 else 语句");
      }
   }
}
```

**嵌套的 if…else 语句**

使用嵌套的 if…else 语句是合法的。也就是说你可以在另一个 if 或者 else if 语句中使用 if 或者 else if 语句。

```java
public class Test {
   public static void main(String args[]){
      int x = 30;
      int y = 10;
      if( x == 30 ){
         if( y == 10 ){
             System.out.print("X = 30 and Y = 10");
          }
       }
    }
}
```

**Java switch case 语句**

switch case 语句判断一个变量与一系列值中某个值是否相等，每个值称为一个分支。

* switch 语句中的变量类型可以是： byte、short、int 或者 char。从 Java SE 7 开始，switch 支持字符串 String 类型了，同时 case 标签必须为字符串常量或字面量。
* switch 语句可以拥有多个 case 语句。每个 case 后面跟一个要比较的值和冒号。
* case 语句中的值的数据类型必须与变量的数据类型相同，而且只能是常量或者字面常量。
* 当变量的值与 case 语句的值相等时，那么 case 语句之后的语句开始执行，直到 break 语句出现才会跳出 switch 语句。
* 当遇到 break 语句时，switch 语句终止。程序跳转到 switch 语句后面的语句执行。case 语句不必须要包含 break 语句。如果没有 break 语句出现，程序会继续执行下一条 case 语句，直到出现 break 语句。
* switch 语句可以包含一个 default 分支，该分支一般是 switch 语句的最后一个分支（可以在任何位置，但建议在最后一个）。default 在没有 case 语句的值和变量值相等的时候执行。default 分支不需要 break 语句。

switch case 执行时，一定会先进行匹配，匹配成功返回当前 case 的值，再根据是否有 break，判断是否继续输出，或是跳出判断。

```java
public class Test {
   public static void main(String args[]){
      //char grade = args[0].charAt(0);
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
   }
}
```

如果 case 语句块中没有 break 语句时，JVM 并不会顺序输出每一个 case 对应的返回值，而是继续匹配，匹配不成功则返回默认 case。

```java
public class Test {
   public static void main(String args[]){
      int i = 5;
      switch(i){
         case 0:
            System.out.println("0");
         case 1:
            System.out.println("1");
         case 2:
            System.out.println("2");
         default:
            System.out.println("default");
      }
   }
}
```

如果 case 语句块中没有 break 语句时，匹配成功后，从当前 case 开始，后续所有 case 的值都会输出。

```java
public class Test {
   public static void main(String args[]){
      int i = 1;
      switch(i){
         case 0:
            System.out.println("0");
         case 1:
            System.out.println("1");
         case 2:
            System.out.println("2");
         default:
            System.out.println("default");
      }
   }
}
```

如果当前匹配成功的 case 语句块没有 break 语句，则从当前 case 开始，后续所有 case 的值都会输出，如果后续的 case 语句块有 break 语句则会跳出判断。

```java
public class Test {
   public static void main(String args[]){
      int i = 1;
      switch(i){
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
   }
}
```

**Java Number & Math类**

一般地，当需要使用数字的时候，我们通常使用内置数据类型，如：byte、int、long、double 等。

```java
int a = 5000;
float b = 13.65f;
byte c = 0x4a;
```

然而，在实际开发过程中，我们经常会遇到需要使用对象，而不是内置数据类型的情形。为了解决这个问题，Java 语言为每一个内置数据类型提供了对应的包装类。

所有的包装类`（Integer、Long、Byte、Double、Float、Short）`都是抽象类 `Number` 的子类。

种由编译器特别支持的包装称为装箱，所以当内置数据类型被当作对象使用的时候，编译器会把内置类型装箱为包装类。相似的，编译器也可以把一个对象拆箱为内置类型。`Number` 类属于 `java.lang` 包。

下面是一个使用 Integer 对象的实例：
```java
public class Test{
   public static void main(String args[]){
      Integer x = 5;
      x =  x + 10;
      System.out.println(x); 
   }
}
```

当 x 被赋为整型值时，由于x是一个对象，所以编译器要对x进行装箱。然后，为了使x能进行加运算，所以要对x进行拆箱。

**Java Math类**

Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数。

Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用。

```java
public class Test {  
    public static void main (String []args)  
    {  
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));  
        System.out.println("0度的余弦值：" + Math.cos(0));  
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));  
        System.out.println("1的反正切值： " + Math.atan(1));  
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));  
        System.out.println(Math.PI);  
    }  
}
```

```java
public class Main {   
  public static void main(String[] args) {   
    double[] nums = { 1.4, 1.5, 1.6, -1.4, -1.5, -1.6 };   
    for (double num : nums) {   
      test(num);   
    }   
  }   
  
  private static void test(double num) {   
    System.out.println("Math.floor(" + num + ")=" + Math.floor(num));   
    System.out.println("Math.round(" + num + ")=" + Math.round(num));   
    System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num));   
  }   
}
```

**Java Character类**

```java
char ch = 'a';
 
// Unicode 字符表示形式
char uniChar = '\u039A'; 
 
// 字符数组
char[] charArray ={ 'a', 'b', 'c', 'd', 'e' };
```

然而，在实际开发过程中，我们经常会遇到需要使用对象，而不是内置数据类型的情况。为了解决这个问题，Java语言为内置数据类型char提供了包装类Character类。

Character类提供了一系列方法来操纵字符。你可以使用Character的构造方法创建一个Character类对象，例如：

在某些情况下，Java编译器会自动创建一个Character对象。

例如，将一个char类型的参数传递给需要一个Character类型参数的方法时，那么编译器会自动地将char类型参数转换为Character对象。 这种特征称为装箱，反过来称为拆箱。

转义序列|描述
-|-
\t|在文中该处插入一个tab键
\b|在文中该处插入一个后退键
\n|在文中该处换行
\r|在文中该处插入回车
\f|在文中该处插入换页符
\'|在文中该处插入单引号
\"|在文中该处插入双引号
\\\\|在文中该处插入反斜杠

```java
public class Test {
   public static void main(String args[]) {
      System.out.println("访问\"菜鸟教程!\"");
   }
}
```

**Java String类**

字符串广泛应用 在Java 编程中，在 Java 中字符串属于对象，Java 提供了 String 类来创建和操作字符串。

*创建字符串*
在代码中遇到字符串常量时，这里的值是 "菜鸟教程""，编译器会使用该值创建一个 String 对象。

和其它对象一样，可以使用关键字和构造方法来创建 String 对象。

```java
public class StringDemo{
   public static void main(String args[]){
      char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
      String helloString = new String(helloArray);  
      System.out.println( helloString );
   }
}
```

注意：*String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。如果需要对字符串做很多修改，那么应该选择使用 StringBuffer & StringBuilder 类。*

**String字符串长度**

用于获取有关对象的信息的方法称为访问器方法。

String 类的一个访问器方法是 length() 方法，它返回字符串对象包含的字符数。

下面的代码执行后，len变量等于14:

```java
public class StringDemo {
    public static void main(String args[]) {
        String site = "www.runoob.com";
        int len = site.length();
        System.out.println( "菜鸟教程网址长度 : " + len );
   }
}
```

**String连接字符串**

```java
string1.concat(string2);

"我的名字是 ".concat("Runoob");

"Hello," + " runoob" + "!"

```

**创建格式化字符串**

我们知道输出格式化数字可以使用 printf() 和 format() 方法。

String 类使用静态方法 format() 返回一个String 对象而不是 PrintStream 对象。

String 类的静态方法 format() 能用来创建可复用的格式化字符串，而不仅仅是用于一次打印输出。

```java
System.out.printf("浮点型变量的值为 " +
                  "%f, 整型变量的值为 " +
                  " %d, 字符串变量的值为 " +
                  "is %s", floatVar, intVar, stringVar);
```

```java
String fs;
fs = String.format("浮点型变量的值为 " +
                   "%f, 整型变量的值为 " +
                   " %d, 字符串变量的值为 " +
                   " %s", floatVar, intVar, stringVar);
```

**String方法

SN(序号)|方法描述
-|-
1|char charAt(int index)返回指定索引处的 char 值。
2|int compareTo(Object o)把这个字符串和另一个对象比较。
3|int compareTo(String anotherString)按字典顺序比较两个字符串。
4|int compareToIgnoreCase(String str)按字典顺序比较两个字符串，不考虑大小写。
5|String concat(String str)将指定字符串连接到此字符串的结尾。
6|boolean contentEquals(StringBuffer sb)当且仅当字符串与指定的StringBuffer有相同顺序的字符时候返回真。
7|static String copyValueOf(char[] data)返回指定数组中表示该字符序列的 String。
8|static String copyValueOf(char[] data, int offset, int count)返回指定数组中表示该字符序列的 String。
9|boolean endsWith(String suffix)测试此字符串是否以指定的后缀结束。
10|boolean equals(Object anObject)将此字符串与指定的对象比较。
11|boolean equalsIgnoreCase(String anotherString)将此 String 与另一个 String 比较，不考虑大小写。
12|byte[] getBytes()使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中
13|byte[] getBytes(String charsetName)使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
14|void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)将字符从此字符串复制到目标字符数组。
15|int hashCode()返回此字符串的哈希码。
16|int indexOf(int ch)返回指定字符在此字符串中第一次出现处的索引。
17|int indexOf(int ch, int fromIndex)返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
18|int indexOf(String str)返回指定子字符串在此字符串中第一次出现处的索引。
19|int indexOf(String str, int fromIndex)返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
20|String intern()返回字符串对象的规范化表示形式。
21|int lastIndexOf(int ch)返回指定字符在此字符串中最后一次出现处的索引。
22|int lastIndexOf(int ch, int fromIndex)返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。
23|int lastIndexOf(String str)返回指定子字符串在此字符串中最右边出现处的索引。
24|int lastIndexOf(String str, int fromIndex)返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
25|int length()返回此字符串的长度。
26|boolean matches(String regex)告知此字符串是否匹配给定的正则表达式。
27|boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)测试两个字符串区域是否相等。
28|boolean regionMatches(int toffset, String other, int ooffset, int len)测试两个字符串区域是否相等。
29|String replace(char oldChar, char newChar)返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
30|String replaceAll(String regex, String replacement)使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
31|String replaceFirst(String regex, String replacement)使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
32|String[] split(String regex)根据给定正则表达式的匹配拆分此字符串。
33|String[] split(String regex, int limit)根据匹配给定的正则表达式来拆分此字符串。
34|boolean startsWith(String prefix)测试此字符串是否以指定的前缀开始。
35|boolean startsWith(String prefix, int toffset)测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
36|CharSequence subSequence(int beginIndex, int endIndex)返回一个新的字符序列，它是此序列的一个子序列。
37|String substring(int beginIndex)返回一个新的字符串，它是此字符串的一个子字符串。
38|String substring(int beginIndex, int endIndex)返回一个新字符串，它是此字符串的一个子字符串。
39|char[] toCharArray()将此字符串转换为一个新的字符数组。
40|String toLowerCase()使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
41|String toLowerCase(Locale locale)使用给定 Locale 的规则将此 String 中的所有字符都转换为小写。
42|String toString()返回此对象本身（它已经是一个字符串！）。
43|String toUpperCase()使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
44|String toUpperCase(Locale locale)使用给定 Locale 的规则将此 String 中的所有字符都转换为大写。
45|String trim()返回字符串的副本，忽略前导空白和尾部空白。
46|static String valueOf(primitive data type x)返回给定data type类型x参数的字符串表示形式。

**Java StringBuffer和StringBuilder类**

当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。

和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。

StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。

由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。

```java
public class Test{
  public static void main(String args[]){
    StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
    sBuffer.append("www");
    sBuffer.append(".runoob");
    sBuffer.append(".com");
    System.out.println(sBuffer);  
  }
}
```

**Java中的String，StringBuilder，StringBuffer三者的区别**

这三个类之间的区别主要是在两个方面，即*运行速度*和*线程安全*这两方面。

1.首先说运行速度，或者说是执行速度，在这方面运行速度快慢为：StringBuilder > StringBuffer > String. String最慢的原因：String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，所以速度要比String快很多。

2.再来说线程安全:在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的

* String：适用于少量的字符串操作的情况
* StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
* StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况

**StringBuffer方法**

序号|方法描述
-|-
1|public StringBuffer append(String s) 将指定的字符串追加到此字符序列。
2|public StringBuffer reverse() 将此字符序列用其反转形式取代。
3|public delete(int start, int end) 移除此序列的子字符串中的字符。
4|public insert(int offset, int i) 将 int 参数的字符串表示形式插入此序列中。
5|replace(int start, int end, String str) 使用给定 String 中的字符替换此序列的子字符串中的字符。

下面的列表里的方法和 String 类的方法类似：

序号|方法描述
-|-
1|int capacity() 返回当前容量。
2|char charAt(int index) 返回此序列中指定索引处的 char 值。
3|void ensureCapacity(int minimumCapacity) 确保容量至少等于指定的最小值。
4|void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 将字符从此序列复制到目标字符数组 dst。
5|int indexOf(String str) 返回第一次出现的指定子字符串在该字符串中的索引。
6|int indexOf(String str, int fromIndex) 从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。
7|int lastIndexOf(String str) 返回最右边出现的指定子字符串在此字符串中的索引。
8|int lastIndexOf(String str, int fromIndex) 返回 String 对象中子字符串最后出现的位置。
9|int length() 返回长度（字符数）。
10|void setCharAt(int index, char ch) 将给定索引处的字符设置为 ch。
11|void setLength(int newLength) 设置字符序列的长度。
12|CharSequence subSequence(int start, int end) 返回一个新的字符序列，该字符序列是此序列的子序列。
13|String substring(int start) 返回一个新的 String，它包含此字符序列当前所包含的字符子序列。
14|String substring(int start, int end) 返回一个新的 String，它包含此序列当前所包含的字符子序列。
15|String toString() 返回此序列中数据的字符串表示形式。

**Java数组**

数组对于每一门编程语言来说都是重要的数据结构之一，当然不同语言对数组的实现及处理也不尽相同。

Java 语言中提供的数组是用来存储固定大小的同类型元素。

你可以声明一个数组变量，如 numbers[100] 来代替直接声明 100 个独立变量 number0，number1，....，number99。

本教程将为大家介绍 Java 数组的声明、创建和初始化，并给出其对应的代码。

**声明数组变量**

首先必须声明数组变量，才能在程序中使用数组。下面是声明数组变量的语法：

```java
dataType[] arrayRefVar;   // 首选的方法
 
或
 
dataType arrayRefVar[];  // 效果相同，但不是首选方法
```

创建数据

Java语言使用new操作符来创建数组，语法如下：
```java
arrayRefVar = new dataType[arraySize];
```

上面的语法语句做了两件事：

* 使用 dataType[arraySize] 创建了一个数组。
* 把新创建的数组的引用赋值给变量 arrayRefVar。数组变量的声明，和创建数组可以用一条语句完成，如下所示：

```java
public class TestArray {
   public static void main(String[] args) {
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
   }
}
```

处理数组

```java
public class TestArray {
   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};
 
      // 打印所有数组元素
      for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
      // 计算所有元素的总和
      double total = 0;
      for (int i = 0; i < myList.length; i++) {
         total += myList[i];
      }
      System.out.println("Total is " + total);
      // 查找最大元素
      double max = myList[0];
      for (int i = 1; i < myList.length; i++) {
         if (myList[i] > max) max = myList[i];
      }
      System.out.println("Max is " + max);
   }
}
```

**For-Each 循环**

JDK 1.5 引进了一种新的循环类型，被称为 For-Each 循环或者加强型循环，它能在不使用下标的情况下遍历数组。

```java
for(type element: array)
{
    System.out.println(element);
}
```

```java
public class TestArray {
   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};
 
      // 打印所有数组元素
      for (double element: myList) {
         System.out.println(element);
      }
   }
}
```

**数组作为函数的参数**

数组可以作为参数传递给方法。

例如，下面的例子就是一个打印 int 数组中元素的方法:

```java
public static void printArray(int[] array) {
  for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + " ");
  }
}
```

```java
printArray(new int[]{3, 1, 2, 6, 4, 2});
```

**数组作为函数的返回值**

```java
public static int[] reverse(int[] list) {
  int[] result = new int[list.length];
 
  for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
    result[j] = list[i];
  }
  return result;
}
```

**多维数组**

多维数组可以看成是数组的数组，比如二维数组就是一个特殊的一维数组，其每一个元素都是一个一维数组，例如：

```java
type[][] typeName = new type[typeLength1][typeLength2];
```

type 可以为基本数据类型和复合数据类型，arraylenght1 和 arraylenght2 必须为正整数，arraylenght1 为行数，arraylenght2 为列数。

```java
int a[][] = new int[2][3];
```

解析：二维数组 a 可以看成一个两行三列的数组。
2.从最高维开始，分别为每一维分配空间，例如：

```java
String s[][] = new String[2][];
s[0] = new String[2];
s[1] = new String[3];
s[0][0] = new String("Good");
s[0][1] = new String("Luck");
s[1][0] = new String("to");
s[1][1] = new String("you");
s[1][2] = new String("!");
```

s[0]=new String[2] 和 s[1]=new String[3] 是为最高维分配引用空间，也就是为最高维限制其能保存数据的最长的长度，然后再为其每个数组元素单独分配空间 s0=new String("Good") 等操作。

**多维数组的引用**
对二维数组中的每个元素，引用方式为 arrayName[index1][index2]，例如：

**Array类**

java.util.Arrays 类能方便地操作数组，它提供的所有方法都是静态的。

具有以下功能：

* 给数组赋值：通过fill方法
* 对数组排序：通过sort方法，按升序
* 比较数组：通过equals方法比较数组中元素值是否相等
* 查找数组元素：通过binarySearch方法能对排序好的数组进行二分查找法操作

序号!方法和说明
-|-
1|public static int binarySearch(Object[] a, Object key) 用二分查找算法在给定数组中搜索给定值的对象(Byte,Int,double等)。数组在调用前必须排序好的。如果查找值包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。
2|public static boolean equals(long[] a, long[] a2) 如果两个指定的 long 型数组彼此相等，则返回 true。如果两个数组包含相同数量的元素，并且两个数组中的所有相应元素对都是相等的，则认为这两个数组是相等的。换句话说，如果两个数组以相同顺序包含相同的元素，则两个数组是相等的。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）。
3|public static void fill(int[] a, int val) 将指定的 int 值分配给指定 int 型数组指定范围中的每个元素。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）。
4|	public static void sort(Object[] a) 对指定对象数组根据其元素的自然顺序进行升序排列。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）。

**Java日期时间**

java.util 包提供了 Date 类来封装当前的日期和时间。 Date 类提供两个构造函数来实例化 Date 对象。

第一个构造函数使用当前日期和时间来初始化对象。

```java
Date()
```

第二个构造函数接收一个参数，该参数是从1970年1月1日起的毫秒数。
```java
Date(long millisec)
```

序号|方法和描述
-|-
1|boolean after(Date date) 若当调用此方法的Date对象在指定日期之后返回true,否则返回false。
2|	boolean before(Date date) 若当调用此方法的Date对象在指定日期之前返回true,否则返回false。
3| Object clone( ) 返回此对象的副本。
4| int compareTo(Date date) 比较当调用此方法的Date对象和指定日期。两者相等时候返回0。调用对象在指定日期之前则返回负数。调用对象在指定日期之后则返回正数。
5| int compareTo(Object obj) 若obj是Date类型则操作等同于compareTo(Date) 。否则它抛出ClassCastException。
6| boolean equals(Object date) 当调用此方法的Date对象和指定日期相等时候返回true,否则返回false。
7| long getTime( ) 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
8|	int hashCode( ) 返回此对象的哈希码值。
9| void setTime(long time) 用自1970年1月1日00:00:00 GMT以后time毫秒数设置时间和日期。
10| String toString( ) 把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)。

**获取当前日期时间**

Java中获取当前日期和时间很简单，使用 Date 对象的 toString() 方法来打印当前日期和时间，如下所示：

```java
import java.util.Date;
  
public class DateDemo {
   public static void main(String args[]) {
       // 初始化 Date 对象
       Date date = new Date();
        
       // 使用 toString() 函数显示日期时间
       System.out.println(date.toString());
   }
}
```

**日期比较**

Java使用以下三种方法来比较两个日期：
* 使用 getTime() 方法获取两个日期（自1970年1月1日经历的毫秒数值），然后比较这两个值。
* 使用方法 before()，after() 和 equals()。例如，一个月的12号比18号早，则 new Date(99, 2, 12).before(new Date (99, 2, 18)) 返回true。
* 使用 compareTo() 方法，它是由 Comparable 接口定义的，Date 类实现了这个接口。

**使用SimpleDateFormat格式化日期**

SimpleDateFormat 是一个以语言环境敏感的方式来格式化和分析日期的类。SimpleDateFormat 允许你选择任何用户自定义日期时间格式来运行。例如：

```java
import  java.util.*;
import java.text.*;
 
public class DateDemo {
   public static void main(String args[]) {
 
      Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
 
      System.out.println("当前时间为: " + ft.format(dNow));
   }
}
```

这一行代码确立了转换的格式，其中 yyyy 是完整的公元年，MM 是月份，dd 是日期，HH:mm:ss 是时、分、秒。

注意:有的格式大写，有的格式小写，例如 MM 是月份，mm 是分；HH 是 24 小时制，而 hh 是 12 小时制。

以上实例编译运行结果如下:

```java
当前时间为: 2018-09-06 10:16:34
```

**日期和时间的格式化编码**

字母|描述|实例
-|-|-
G|纪元标记|AD
y|四位年份|2001
M|月份|July or 07
d|一个月的日期|10
h||A.M./P.M.(1~12)格式小时|12
H|一天中的小时(0~23)|22
m|分钟数|30
s|秒数|55
S|毫秒数|234
E|星期几|Tuesday
D|一年中的日子|360
F|一个月中第几周的周几|2(second Wed. in July)
w|一年中的第几周|40
W|一个月中第几周|1
a|A.M./P.M. 标记|PM
k|一天中的小时(1~24)|24
K|A.M./P.M.(0~11)格式小时|10
z|时区|Eastern Standard Time
‘|文字定界符|Delimiter
“|单引号|`

**使用printf格式化日期**

printf方法可以很轻松地格式化时间和日期

转换符|说明|示例
-|-|-
c|包括全部日期和时间信息|星期六 十月 27 14:21:20 CST 2007
F|"年-月-日"格式| 2007-10-27
D|"月/日/年"格式| 10/27/07
r|"HH:MM:SS PM"格式（12时制）| 02:25:51 下午
T|"HH:MM:SS"格式（24时制）| 14:28:16
R|"HH:MM"格式（24时制）| 14:28

```java
import java.util.Date;
 
public class DateDemo {
 
  public static void main(String args[]) {
     // 初始化 Date 对象
     Date date = new Date();
 
     //c的使用  
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
  }
}
```

如果你需要重复提供日期，那么利用这种方式来格式化它的每一部分就有点复杂了。因此，可以利用一个格式化字符串指出要被格式化的参数的索引。索引必须紧跟在%后面，而且必须以$结束。例如：

```java
import java.util.Date;
  
public class DateDemo {
 
   public static void main(String args[]) {
       // 初始化 Date 对象
       Date date = new Date();
        
       // 使用toString()显示日期和时间
       System.out.printf("%1$s %2$tB %2$td, %2$tY", 
                         "Due date:", date);
   }
}
```

或者，你可以使用 < 标志。它表明先前被格式化的参数要被再次使用。例如：

```java
import java.util.Date;
  
public class DateDemo {
 
   public static void main(String args[]) {
       // 初始化 Date 对象
       Date date = new Date();
        
       // 显示格式化时间
       System.out.printf("%s %tB %<te, %<tY", 
                         "Due date:", date);
   }
}
```

以上实例编译运行结果如下:

```java
import java.util.*;
  
public class DateDemo {
   public static void main(String args[]) {
       Date date=new Date();                                      
        //b的使用，月份简称  
        String str=String.format(Locale.US,"英文月份简称：%tb",date);       
        System.out.println(str);                                                                              
        System.out.printf("本地月份简称：%tb%n",date);  
        //B的使用，月份全称  
        str=String.format(Locale.US,"英文月份全称：%tB",date);  
        System.out.println(str);  
        System.out.printf("本地月份全称：%tB%n",date);  
        //a的使用，星期简称  
        str=String.format(Locale.US,"英文星期的简称：%ta",date);  
        System.out.println(str);  
        //A的使用，星期全称  
        System.out.printf("本地星期的简称：%tA%n",date);  
        //C的使用，年前两位  
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);  
        //y的使用，年后两位  
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);  
        //j的使用，一年的天数  
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);  
        //m的使用，月份  
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);  
        //d的使用，日（二位，不够补零）  
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);  
        //e的使用，日（一位不补零）  
        System.out.printf("月份的日（前面不补0）：%te",date);  
   }
}
```

输出结果为：
```java
英文月份简称：May
本地月份简称：五月
英文月份全称：May
本地月份全称：五月
英文星期的简称：Thu
本地星期的简称：星期四
年的前两位数字（不足两位前面补0）：20
年的后两位数字（不足两位前面补0）：17
一年中的天数（即年的第几天）：124
两位数字的月份（不足两位前面补0）：05
两位数字的日（不足两位前面补0）：04
月份的日（前面不补0）：4
```

**解析字符串为时间**

SimpleDateFormat 类有一些附加的方法，特别是parse()，它试图按照给定的SimpleDateFormat 对象的格式化存储来解析字符串。例如：

```java
import java.util.*;
import java.text.*;
  
public class DateDemo {
 
   public static void main(String args[]) {
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
 
      String input = args.length == 0 ? "1818-11-11" : args[0]; 
 
      System.out.print(input + " Parses as "); 
 
      Date t; 
 
      try { 
          t = ft.parse(input); 
          System.out.println(t); 
      } catch (ParseException e) { 
          System.out.println("Unparseable using " + ft); 
      }
   }
}
```

**Java休眠(sleep)**

sleep()使当前线程进入停滞状态（阻塞当前线程），让出CPU的使用、目的是不让当前线程独自霸占该进程所获的CPU资源，以留一定时间给其他线程执行的机会。你可以让程序休眠一毫秒的时间或者到您的计算机的寿命长的任意段时间。例如，下面的程序会休眠3秒：

```java
import java.util.*;
  
public class SleepDemo {
   public static void main(String args[]) {
      try { 
         System.out.println(new Date( ) + "\n"); 
         Thread.sleep(1000*3);   // 休眠3秒
         System.out.println(new Date( ) + "\n"); 
      } catch (Exception e) { 
          System.out.println("Got an exception!"); 
      }
   }
}
```

**测量时间**

下面的一个例子表明如何测量时间间隔（以毫秒为单位）：

```java
import java.util.*;
  
public class DiffDemo {
 
   public static void main(String args[]) {
      try {
         long start = System.currentTimeMillis( );
         System.out.println(new Date( ) + "\n");
         Thread.sleep(5*60*10);
         System.out.println(new Date( ) + "\n");
         long end = System.currentTimeMillis( );
         long diff = end - start;
         System.out.println("Difference is : " + diff);
      } catch (Exception e) {
         System.out.println("Got an exception!");
      }
   }
}
```

**Calendar类**

Calendar类的功能要比Date类强大很多，而且在实现方式上也比Date类要复杂一些。

Calendar类是一个抽象类，在实际使用时实现特定的子类的对象，创建对象的过程对程序员来说是透明的，只需要使用getInstance方法创建即可。

**创建一个代表系统当前日期的Calendar对象**

```java
Calendar c = Calendar.getInstance();//默认是当前日期
```

**创建一个指定日期的Calendar对象**

使用Calendar类代表特定的时间，需要首先创建一个Calendar的对象，然后再设定该对象中的年月日参数来完成。

```java
//创建一个代表2009年6月12日的Calendar对象
Calendar c1 = Calendar.getInstance();
c1.set(2009, 6 - 1, 12);
```

**Calendar**

Calendar类中用以下这些常量表示不同的意义，jdk内的很多类其实都是采用的这种思想

常量|描述
-|-
Calendar.YEAR|年份
Calendar.MONTH|月份
Calendar.DATE|日期
Calendar.DAY_OF_MONTH|日期，和上面的字段意义完全相同
Calendar.HOUR|12小时制的小时
Calendar.HOUR_OF_DAY|24小时制的小时
Calendar.MINUTE|分钟
Calendar.SECOND|秒
Calendar.DAY_OF_WEEK|星期几

**Calendar类对象信息的设置**

```java
Calendar c1 = Calendar.getInstance();
```

调用:

```java
public final void set(int year,int month,int date)
```
```java
c1.set(2009, 6 - 1, 12);//把Calendar对象c1的年月日分别设这为：2009、6、12
```

**Calendar类对象信息的获得**

```java
Calendar c1 = Calendar.getInstance();
// 获得年份
int year = c1.get(Calendar.YEAR);
// 获得月份
int month = c1.get(Calendar.MONTH) + 1;
// 获得日期
int date = c1.get(Calendar.DATE);
// 获得小时
int hour = c1.get(Calendar.HOUR_OF_DAY);
// 获得分钟
int minute = c1.get(Calendar.MINUTE);
// 获得秒
int second = c1.get(Calendar.SECOND);
// 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
int day = c1.get(Calendar.DAY_OF_WEEK);
```

**GregorianCalendar类**

Calendar类实现了公历日历，GregorianCalendar是Calendar类的一个具体实现。

Calendar 的getInstance（）方法返回一个默认用当前的语言环境和时区初始化的GregorianCalendar对象。GregorianCalendar定义了两个字段：AD和BC。这是代表公历定义的两个时代。

下面列出GregorianCalendar对象的几个构造方法：

```java
import java.util.*;
  
public class GregorianCalendarDemo {
 
   public static void main(String args[]) {
      String months[] = {
      "Jan", "Feb", "Mar", "Apr",
      "May", "Jun", "Jul", "Aug",
      "Sep", "Oct", "Nov", "Dec"};
      
      int year;
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
   }
}
```

**Java正则表达式**

正则表达式定义了字符串的模式。

正则表达式可以用来搜索、编辑或处理文本。

正则表达式并不仅限于某一种语言，但是在每种语言中有细微的差别。

**正则表达式实例**

一个字符串其实就是一个简单的正则表达式，例如 Hello World 正则表达式匹配 "Hello World" 字符串。

.（点号）也是一个正则表达式，它匹配任何一个字符如："a" 或 "1"。

下表列出了一些正则表达式的实例及描述：

正则表达式|描述
-|-
this is text|匹配字符串 "this is text"
this\s+is\s+text|注意字符串中的 \s+。匹配单词 "this" 后面的 \s+ 可以匹配多个空格，之后匹配 is 字符串，再之后 \s+ 匹配多个空格然后再跟上 text 字符串。可以匹配这个实例：this is text
^\d+(\.\d+)?|^ 定义了以什么开始；\d+ 匹配一个或多个数字；? 设置括号内的选项是可选的；\. 匹配 "."；可以匹配的实例："5", "1.5" 和 "2.21"。

Java 正则表达式和 Perl 的是最为相似的。

java.util.regex 包主要包括以下三个类：

* **Pattern类**:pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
* **Matcher类**:Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
* **PatternStntaxException**:PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。

```java
import java.util.regex.*;
 
class RegexExample1{
   public static void main(String args[]){
      String content = "I am noob " +
        "from runoob.com.";
 
      String pattern = ".*runoob.*";
 
      boolean isMatch = Pattern.matches(pattern, content);
      System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
   }
}
```

**捕获组**

捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。

例如，正则表达式 (dog) 创建了单一分组，组里包含"d"，"o"，和"g"。

捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：

* ((A)(B(C)))
* (A)
* (B(C))
* (C)

可以通过调用 matcher 对象的 groupCount 方法来查看表达式有多少个分组。groupCount 方法返回一个 int 值，表示matcher对象当前有多个捕获组。

还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexMatches
{
    public static void main( String args[] ){
 
      // 按指定模式在字符串查找
      String line = "This order was placed for QT3000! OK?";
      String pattern = "(\\D*)(\\d+)(.*)";
 
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
   }
}
```

字符|说明
-|-
\ |将下一字符标记为特殊字符、文本、反向引用或八进制转义符。例如，"n"匹配字符"n"。"\n"匹配换行符。序列"\\\\"匹配"\\"，"\\("匹配"("。
^|匹配输入字符串开始的位置。如果设置了 RegExp 对象的 Multiline 属性，^ 还会与"\n"或"\r"之后的位置匹配。
$|匹配输入字符串结尾的位置。如果设置了 RegExp 对象的 Multiline 属性，$ 还会与"\n"或"\r"之前的位置匹配。
\*|零次或多次匹配前面的字符或子表达式。例如，zo\* 匹配"z"和"zoo"。\* 等效于 {0,}。
+|一次或多次匹配前面的字符或子表达式。例如，"zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+ 等效于 {1,}。
?|零次或一次匹配前面的字符或子表达式。例如，"do(es)?"匹配"do"或"does"中的"do"。? 等效于 {0,1}。
{n}|n 是非负整数。正好匹配 n 次。例如，"o{2}"与"Bob"中的"o"不匹配，但与"food"中的两个"o"匹配。
{n,}| 是非负整数。至少匹配 n 次。例如，"o{2,}"不匹配"Bob"中的"o"，而匹配"foooood"中的所有 o。"o{1,}"等效于"o+"。"o{0,}"等效于"o*"。
{n,m}|	m 和 n 是非负整数，其中 n <= m。匹配至少 n 次，至多 m 次。例如，"o{1,3}"匹配"fooooood"中的头三个 o。'o{0,1}' 等效于 'o?'。注意：您不能将空格插入逗号和数字之间。
?|当此字符紧随任何其他限定符（*、+、?、{n}、{n,}、{n,m}）之后时，匹配模式是"非贪心的"。"非贪心的"模式匹配搜索到的、尽可能短的字符串，而默认的"贪心的"模式匹配搜索到的、尽可能长的字符串。例如，在字符串"oooo"中，"o+?"只匹配单个"o"，而"o+"匹配所有"o"。
.|匹配除"\\r\\n"之外的任何单个字符。若要匹配包括"\\r\\n"在内的任意字符，请使用诸如"\[\\s\\S\]"之类的模式。
(pattern)|匹配 pattern 并捕获该匹配的子表达式。可以使用 $0…$9 属性从结果"匹配"集合中检索捕获的匹配。若要匹配括号字符 ( )，请使用"\\("或者"\\)"。
(?:pattern)|匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。这对于用"or"字符 (\|) 组合模式部件的情况很有用。例如，'industr(?:y\|ies) 是比 'industry\|industries' 更经济的表达式。
(?=pattern)|行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?=95\|98\|NT\|2000)' 匹配"Windows 2000"中的"Windows"，但不匹配"Windows 3.1"中的"Windows"。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
(?!pattern)|执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?!95\|98\|NT\|2000)' 匹配"Windows 3.1"中的 "Windows"，但不匹配"Windows 2000"中的"Windows"。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
x\|y|匹配 x 或 y。例如，'z|food' 匹配"z"或"food"。'(z\|f)ood' 匹配"zood"或"food"。
\[xyz\]|字符集。匹配包含的任一字符。例如，"\[abc\]"匹配"plain"中的"a"。
\[^xyz\]|反向字符集。匹配未包含的任何字符。例如，"\[^abc\]"匹配"plain"中"p"，"l"，"i"，"n"。
\[a-z\]|反向范围字符。匹配不在指定的范围内的任何字符。例如，"\[^a-z\]"匹配任何不在"a"到"z"范围内的任何字符。
\\b|	匹配一个字边界，即字与空格间的位置。例如，"er\b"匹配"never"中的"er"，但不匹配"verb"中的"er"。
\\B|非字边界匹配。"er\B"匹配"verb"中的"er"，但不匹配"never"中的"er"。
\\cx|匹配 x 指示的控制字符。例如，\\cM 匹配 Control-M 或回车符。x 的值必须在 A-Z 或 a-z 之间。如果不是这样，则假定 c 就是"c"字符本身。
\\d|数字字符匹配。等效于 \[0-9\]。
\\D|非数字字符匹配。等效于 \[^0-9\]。
\\f|换页符匹配。等效于 \\x0c 和 \\cL。
\\n|换行符匹配。等效于 \\x0a 和 \\cJ。
\\r|匹配一个回车符。等效于 \\x0d 和 \\cM。
\\s|匹配任何空白字符，包括空格、制表符、换页符等。与 [ \\f\\n\\r\\t\\v] 等效。
\\S|匹配任何非空白字符。与 [^ \\f\\n\\r\\t\\v] 等效。
\\t|制表符匹配。与 \\x09 和 \\cI 等效。
\\v|垂直制表符匹配。与 \\x0b 和 \\cK 等效。
\\w|匹配任何字类字符，包括下划线。与"\[A-Za-z0-9_\]"等效。
\\W|与任何非单词字符匹配。与"\[^A-Za-z0-9_\]"等效。
\\xn|匹配 n，此处的 n 是一个十六进制转义码。十六进制转义码必须正好是两位数长。例如，"\\x41"匹配"A"。"\\x041"与"\\x04"&"1"等效。允许在正则表达式中使用 ASCII 代码。
\\num|	匹配 num，此处的 num 是一个正整数。到捕获匹配的反向引用。例如，"(.)\1"匹配两个连续的相同字符。
\\n|标识一个八进制转义码或反向引用。如果 \n 前面至少有 n 个捕获子表达式，那么 n 是反向引用。否则，如果 n 是八进制数 (0-7)，那么 n 是八进制转义码。
\\nm|识一个八进制转义码或反向引用。如果 \\nm 前面至少有 nm 个捕获子表达式，那么 nm 是反向引用。如果 \\nm 前面至少有 n 个捕获，则 n 是反向引用，后面跟有字符 m。如果两种前面的情况都不存在，则 \\nm 匹配八进制值 nm，其中 n 和 m 是八进制数字 (0-7)。
\\nml|	当 n 是八进制数 (0-3)，m 和 l 是八进制数 (0-7) 时，匹配八进制转义码 nml。
\\un|	匹配 n，其中 n 是以四位十六进制数表示的 Unicode 字符。例如，\\u00A9 匹配版权符号 (©)。

**Matcher类的方法**

*索引方法*

序号|方法及说明
-|-
1| public int start() 返回以前匹配的初始索引。
2| public int start(int group) 返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引
3| public int end() 返回最后匹配字符之后的偏移量。
4|	public int end(int group) 返回在以前的匹配操作期间，由给定组所捕获子序列的最后字符之后的偏移量。

*研究方法*

序号|方法及说明
-|-
1| public boolean lookingAt() 尝试将从区域开头开始的输入序列与该模式匹配。
2| public boolean find() 尝试查找与该模式匹配的输入序列的下一个子序列。
3| public boolean find(int start）重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。
4|	public boolean matches() 尝试将整个区域与模式匹配。

*替换方法*

序号|方法及说明
-|-
1| public Matcher appendReplacement(StringBuffer sb, String replacement) 实现非终端添加和替换步骤。
2| public StringBuffer appendTail(StringBuffer sb) 实现终端添加和替换步骤。
3| public String replaceAll(String replacement) 替换模式与给定替换字符串相匹配的输入序列的每个子序列。
4|	public String replaceFirst(String replacement) 替换模式与给定替换字符串匹配的输入序列的第一个子序列。
5| public static String quoteReplacement(String s) 返回指定字符串的字面替换字符串。这个方法返回一个字符串，就像传递给Matcher类的appendReplacement 方法一个字面字符串一样工作。

*start和end方法*

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexMatches
{
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT =
                                    "cat cat cat cattie cat";
 
    public static void main( String args[] ){
       Pattern p = Pattern.compile(REGEX);
       Matcher m = p.matcher(INPUT); // 获取 matcher 对象
       int count = 0;
 
       while(m.find()) {
         count++;
         System.out.println("Match number "+count);
         System.out.println("start(): "+m.start());
         System.out.println("end(): "+m.end());
      }
   }
}
```

*matches 和 lookingAt 方法*

matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求。

lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。

这两个方法经常在输入字符串的开始使用。

我们通过下面这个例子，来解释这个功能：

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexMatches
{
    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static final String INPUT2 = "ooooofoooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;
    private static Matcher matcher2;
 
    public static void main( String args[] ){
       pattern = Pattern.compile(REGEX);
       matcher = pattern.matcher(INPUT);
       matcher2 = pattern.matcher(INPUT2);
 
       System.out.println("Current REGEX is: "+REGEX);
       System.out.println("Current INPUT is: "+INPUT);
       System.out.println("Current INPUT2 is: "+INPUT2);
 
 
       System.out.println("lookingAt(): "+matcher.lookingAt());
       System.out.println("matches(): "+matcher.matches());
       System.out.println("lookingAt(): "+matcher2.lookingAt());
   }
}
```

*replaceFirst 和 replaceAll 方法*

replaceFirst 和 replaceAll 方法用来替换匹配正则表达式的文本。不同的是，replaceFirst 替换首次匹配，replaceAll 替换所有匹配。

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexMatches
{
    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. " +
                                    "All dogs say meow.";
    private static String REPLACE = "cat";
 
    public static void main(String[] args) {
       Pattern p = Pattern.compile(REGEX);
       // get a matcher object
       Matcher m = p.matcher(INPUT); 
       INPUT = m.replaceAll(REPLACE);
       System.out.println(INPUT);
   }
}
```

*appendReplacement 和 appendTail 方法*

Matcher 类也提供了appendReplacement 和 appendTail 方法用于文本替换：

看下面的例子来解释这个功能：

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexMatches
{
   private static String REGEX = "a*b";
   private static String INPUT = "aabfooaabfooabfoobkkk";
   private static String REPLACE = "-";
   public static void main(String[] args) {
      Pattern p = Pattern.compile(REGEX);
      // 获取 matcher 对象
      Matcher m = p.matcher(INPUT);
      StringBuffer sb = new StringBuffer();
      while(m.find()){
         m.appendReplacement(sb,REPLACE);
      }
      m.appendTail(sb);
      System.out.println(sb.toString());
   }
}
```

**PatternSyntaxException 类的方法**

PatternSyntaxException 是一个非强制异常类，它指示一个正则表达式模式中的语法错误。

PatternSyntaxException 类提供了下面的方法来帮助我们查看发生了什么错误。

序号|方法及说明
-|-
1|	public String getDescription() 获取错误的描述。
2|	public int getIndex() 获取错误的索引。
3| public String getPattern() 获取错误的正则表达式模式。
4| public String getMessage() 返回多行字符串，包含语法错误及其索引的描述、错误的正则表达式模式和模式中错误索引的可视化指示。

**Java方法**

*System.out.println()* 是调用系统类 System 中的标准输出对象 out 中的方法 println()。

* println() 是一个方法
* System 是系统类
* out 是标准输出对象

Java方法是语句的集合，它们在一起执行一个功能。
* 方法是解决一类问题的步骤的有序组合
* 方法包含于类或对象中
* 方法在程序中被创建，在其他地方被引用

方法的优点
1. 使程序变得更简短而清晰。
2. 有利于程序维护。
3. 可以提高程序开发的效率。
4. 提高了代码的重用性。

方法的命名规则

* 方法的名字的第一个单词应以小写字母作为开头，后面的单词则用大写字母开头写，不使用连接符。例如：`addPerson`。

* 下划线可能出现在 JUnit 测试方法名称中用以分隔名称的逻辑组件。一个典型的模式是：`test<MethodUnderTest>_<state>`，例如 `testPop_emptyStack`。

方法包含一个方法头和一个方法体。下面是一个方法的所有部分：
* **修饰符：** 修饰符，这是可选的，告诉编译器如何调用该方法。定义了该方法的访问类型。
* **返回值类型 ：** 方法可能会返回值。returnValueType 是方法返回值的数据类型。有些方法执行所需的操作，但没有返回值。在这种情况下，returnValueType 是关键字void。
* **方法名：** 是方法的实际名称。方法名和参数表共同构成方法签名。
* **参数类型：** 参数像是一个占位符。当方法被调用时，传递值给参数。这个值被称为实参或变量。参数列表是指方法的参数类型、顺序和参数的个数。参数是可选的，方法可以不包含任何参数。
* **方法体：** 方法体包含具体的语句，定义该方法的功能。

```java
public class TestMax {
   /** 主方法 */
   public static void main(String[] args) {
      int i = 5;
      int j = 2;
      int k = max(i, j);
      System.out.println( i + " 和 " + j + " 比较，最大值是：" + k);
   }
 
   /** 返回两个整数变量较大的值 */
   public static int max(int num1, int num2) {
      int result;
      if (num1 > num2)
         result = num1;
      else
         result = num2;
 
      return result; 
   }
}
```

```java
public class TestVoidMethod {
  public static void main(String[] args) {
    printGrade(78.5);
  }
 
  public static void printGrade(double score) {
    if (score >= 90.0) {
       System.out.println('A');
    }
    else if (score >= 80.0) {
       System.out.println('B');
    }
    else if (score >= 70.0) {
       System.out.println('C');
    }
    else if (score >= 60.0) {
       System.out.println('D');
    }
    else {
       System.out.println('F');
    }
  }
}
```

**Java方法可以重载同名函数**

如果你调用max方法时传递的是int型参数，则 int型参数的max方法就会被调用；

如果传递的是double型参数，则double类型的max方法体会被调用，这叫做方法重载；

就是说一个类的两个方法拥有相同的名字，但是有不同的参数列表。

Java编译器根据方法签名判断哪个方法应该被调用。

方法重载可以让程序更清晰易读。执行密切相关任务的方法应该使用相同的名字。

重载的方法必须拥有不同的参数列表。你不能仅仅依据修饰符或者返回类型的不同来重载方法。

**变量作用域**

变量的范围是程序中该变量可以被引用的部分。

方法内定义的变量被称为局部变量。

局部变量的作用范围从声明开始，直到包含它的块结束。

局部变量必须声明才可以使用。

方法的参数范围涵盖整个方法。参数实际上是一个局部变量。

for循环的初始化部分声明的变量，其作用范围在整个循环。

但循环体内声明的变量其适用范围是从它声明到循环体结束。它包含如下所示的变量声明：

**可变参数**

JDK 1.5 开始，Java支持传递同类型的可变参数给一个方法。

```java
typeName... parameterName
```

```java
public class VarargsDemo {
    public static void main(String args[]) {
        // 调用可变参数的方法
        printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});
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
}
```

**finalize() 方法**

Java 允许定义这样的方法，它在对象被垃圾收集器析构(回收)之前调用，这个方法叫做 finalize( )，它用来清除回收对象。

例如，你可以使用 finalize() 来确保一个对象打开的文件被关闭了。

在 finalize() 方法里，你必须指定在对象销毁时候要执行的操作。

finalize() 一般格式是：

```java

public class FinalizationDemo {  
  public static void main(String[] args) {  
    Cake c1 = new Cake(1);  
    Cake c2 = new Cake(2);  
    Cake c3 = new Cake(3);  
      
    c2 = c3 = null;  
    System.gc(); //调用Java垃圾收集器
  }  
}  
 
class Cake extends Object {  
  private int id;  
  public Cake(int id) {  
    this.id = id;  
    System.out.println("Cake Object " + id + "is created");  
  }  
    
  protected void finalize() throws java.lang.Throwable {  
    super.finalize();  
    System.out.println("Cake Object " + id + "is disposed");  
  }  
}

```
