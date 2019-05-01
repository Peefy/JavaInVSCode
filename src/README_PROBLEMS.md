
1. Java对象重写equals时为什么同时重写hashcode函数

因为Object的equal方法默认是两个对象的引用的比较，意思就是指向同一内存,地址则相等，否则不相等；如果你现在需要利用对象里面的值来判断是否相等，则重载equal方法。 

一般的地方不需要重载hashCode，只有当类需要放在HashTable、HashMap、HashSet等等hash结构的集合时才会 重载hashCode，那么为什么要重载hashCode呢？就HashMap来说，好比HashMap就是一个大内存块，里面有很多小内存块，小内存块 里面是一系列的对象，可以利用hashCode来查找小内存块hashCode%size(小内存块数量)，所以当equal相等时，hashCode必 须相等，而且如果是object对象，必须重载hashCode和equal方法。

因为是按照hashCode来访问小内存块，所以hashCode必须相等。

之所以hashCode相等，却可以equal不等，就比如ObjectA和ObjectB他们都有属性name，那么hashCode都以name计算，所以hashCode一样，但是两个对象属于不同类型，所以equal为false。

2. 说一下map的分类和常见的情况

* **HashMap**-最常用的Map，根据键的hashcode值来存储数据，根据键可以直接获得他的值（因为相同的键hashcode值相同，在地址为hashcode值的地方存储的就是值，所以根据键可以直接获得值），具有很快的访问速度，遍历时，取得数据的顺序完全是随机的，HashMap最多只允许一条记录的键为null，允许多条记录的值为null，HashMap不支持线程同步，即任意时刻可以有多个线程同时写HashMap，这样对导致数据不一致，如果需要同步，可以使用synchronziedMap的方法使得HashMap具有同步的能力或者使用concurrentHashMap
* **HashTable**-与HashMap类似，不同的是，它不允许记录的键或值为空，支持线程同步，即任意时刻只能有一个线程写HashTable，因此也导致HashTable在写入时比较慢!
* **LinkedHashMap**-是HahsMap的一个子类，但它保持了记录的插入顺序，遍历时先得到的肯定是先插入的，也可以在构造时带参数，按照应用次数排序，在遍历时会比HahsMap慢，不过有个例外，当HashMap的容量很大，实际数据少时，遍历起来会比LinkedHashMap慢（因为它是链啊），因为HashMap的遍历速度和它容量有关，LinkedHashMap遍历速度只与数据多少有关
* **TreeMap**-实现了sortMap接口，能够把保存的记录按照键排序（默认升序），也可以指定排序比较器，遍历时得到的数据是排过序的

什么情况用什么类型的Map：

* 在Map中插入，删除，定位元素：`HashMap`
* 要按照自定义顺序或自然顺序遍历：`TreeMap`
* 要求输入顺序和输出顺序相同：`LinkedHashMap`

3. Object若不重写hashCode()的话，hashCode()如何计算出来的？

Object的hashcode()方法是本地方法，也就是用c语言或c++实现的，该方法直接返回对象的内存地址。

4. Java中==运算符比较的是什么？

* 对于`基本类型变量`==操作比较的是两个变量的值是否相等，对于`引用型变量`表示的是两个变量在堆中存储的地址是否相同，即栈中的内容是否相同。

*注意：比较运算符==用于判断字符串的地址是否相同，即使字符串内容相同，但是对象不同，返回值仍是false。*

* equals操作表示的两个变量是否是对同一个对象的引用，即堆中的内容是否相同。

5. 若对一个类不重写，它的equals()方法是如何比较的？

如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；此时跟使用==没有任何区别

6. java8新特性

* **Lambda 表达式**  Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中。
* **方法引用**  方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
方法引用使用一对冒号 :: 
* **函数式接口**
函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
* **默认方法** 默认方法就是一个在接口里面有了一个实现的方法。
* **新工具** 新的编译工具，如：Nashorn引擎 jjs、 类依赖分析器jdeps。
* **Stream API** 新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
* **Date Time API** 加强对日期与时间的处理。
* **Optional 类** Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。
* **Nashorn, JavaScript 引擎** Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。
* **Base64**

7. Java Lambda表达式的优缺点。

**优点**

* 简洁。
* 非常容易并行计算。
* 可能代表未来的编程趋势。
* 结合 hashmap 的 computeIfAbsent 方法，递归运算非常快。java有针对递归的专门优化。

**缺点**

* 若不用并行计算，很多时候计算速度没有比传统的 for 循环快。（并行计算有时需要预热才显示出效率优势，并行计算目前对 Collection 类型支持的好，对其他类型支持的一般）
* 不容易调试。
* 若其他程序员没有学过 lambda 表达式，代码不容易让其他语言的程序员看懂。
* 在 lambda 语句中强制类型转换貌似不方便，一定要搞清楚到底是 map 还是 mapToDouble 还是 mapToInt

8. Java一个十进制的数在内存中是怎么存的？

二进制补码的形式存储

9. 为啥有时会出现4.0-3.6=0.40000001这种现象？

在二进制系统中无法精确地表示分数1/10，这就好像十进制无法精确地表示分数1/3一样。如果在数值计算中不允许有任何舍入误差 ，就应该使用BigDecimal类。

10. Java支持的数据类型有哪些？什么是自动拆装箱？

Java中有八种基本数据类型以及引用类型

基本数据类型：byte（1字节），short（2字节），int（4字节），long（8字节），char（2字节），boolean（不确定，取值是true/false），float（4字节），double（8字节）

引用数据类型：包括数组，集合，字符串，接口以及类等

自动装箱/自动拆箱：就是指基本数据类型可以和其对应包装类之间自动转换

11. Java值传递和引用传递？

java中是没有指针的，java中只存在值传递。然而我们经常看到对于对象（数组，类，接口）的传递似乎有点像引用传递，可以改变对象中某个属性的值，实际上这个传入函数的值是对象引用的拷贝，即传递的是引用的地址值，所以还是按值传递。

12. 数组(Array)和列表(ArrayList)有什么区别？什么时候应该使用Array而不是ArrayList？

下面列出了Array和ArrayList的不同点：
* Array可以包含基本类型和对象类型，ArrayList只能包含对象类型。
* Array大小是固定的，ArrayList的大小是动态变化的。
* ArrayList提供了更多的方法和特性，比如：addAll()，removeAll()，iterator()等等。
对于基本类型数据，集合使用自动装箱来减少编码工作量。但是，当处理固定大小的基本数据类型的时候，这种方式相对比较慢。

arraylist扩充机制：newCapacity=oldCapacity+(oldCapacity>>1)（注： >>1:右移1位，相当于除以2，例如10>>1 得到的就是5）但由于源码里（不再分析，这里简要略过）传过来的minCapcatiy的值是size+1，能够实现grow方法调用就肯定是(size+1)>elementData.length的情况，所以size就是初始最大容量或上一次扩容后达到的最大容量，所以才会进行扩容。因此，扩容后的大小应该是原来的1.5倍+1

13. 你了解大O符号(big-O notation)么？你能给出不同数据结构的例子么？

大O符号表示当数据结构的元素增加的时候，算法规模或者性能在最坏场景下有多好。

大O符号也可以用来描述其他行为，比如说内存消耗。因为集合实际上就是一种数据结构，我们一
般用大O符号基于时间、性能、内存消耗来选择最好的实现。

如列表的插入时间为0(1)、二叉搜索树的插入时间为O(lgn)、哈希表的查找时间为O(1)

14. Java String是最基本的数据类型吗?

不是。Java中的基本数据类型只有8个：boolean、char、byte、short、int、long、float、double；除了基本数据类型（primitive type）和枚举类型（enumeration type），剩下的都是引用类型（reference type）。

15. int 和 Integer 有什么区别

**int**

int是我们常说的整型数字，是Java的8个原始数据类型（Primitive Type：boolean、byte、short、char、int、float、double、long）之一。Java语言虽然号称一切都是对象，但原始数据是例外。

**Integer**

Integer是int对应的包装类，它有一个int类型的字段存储数据，并且提供了基本操作，比如数学运算，int和字符串之间转换等。在Java5中引入了自动装箱和自动拆箱功能，Java可以根据上下文，自动进行转换，极大的简化了相关编程。

16. String/StringBuffer/StringBuilder的区别

这三个类之间的区别主要是在两个方面，即*运行速度*和*线程安全*这两方面。

1.首先说运行速度，或者说是执行速度，在这方面运行速度快慢为：StringBuilder > StringBuffer > String. String最慢的原因：String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，所以速度要比String快很多。

2.再来说线程安全:在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的

* String：适用于少量的字符串操作的情况
* StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
* StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况

17. 我们在web应用开发过程中经常遇到输出某种编码的字符，如iso8859-1等，如何输出一个某种编码的字符串？

```java
public String translate(String str){//对传入的str字符串进行转换
    String tempStr = "";
    try{
        tempStr = new String(str.getBytes("ISO-8859-1"), "GBK");//把"ISO-8859-1"转化为“GBK”编码
        tempStr = tempStr.trim();
    }catch (Exception e){
        System.err.println(e.getMessage());
    }
    return tempStr;
}
```

18. &和&&的区别？

两种解释

(&,|)它们是逻辑操作，(&&,||)它们是条件操作。
&是位运算符，表示按位与运算，&&是逻辑运算符，表示逻辑运算与（and）.
|| 按位或运算符 ，表示按位或运算，||是逻辑或算符，表示逻辑或运算。
条件操作只能操作布尔型的,而逻辑操作不仅可以操作布尔型,而且可以操作数值型的。
不同点：
对于A&B，不管a是否为假，仍然要判断B。
对于A|B，不管a是否为真，仍然要判断B。
而对于A&&B，A||B在以上情况就不会去判断B了。

19. 在Java中，如何跳出当前的多重嵌套循环？

```java
ok:
for(int i=0;i<10;i++)
{
     for(int j=0;j<10;j++)
{
     system.out.println("i="+i+",j="+j);
     if(j==5)break ok;
}
}
```

```java
int arr[][]={{1,2,2},{2,2,5},{4,4}};
boolean found =false;
for(int i=0;i<arr.length&&!found;i++)
{
    for(int j=0;j<arr[i].length;j++)
{
    system.out.println("i="+i+",j="+j);
    if(arr[i][j]==5)
{     
    found=true;
    break;
}
}
}
```

20. Java和JavaSciprt的异同？

JavaScript 与Java是两个公司开发的不同的两个产品。Java 是原Sun Microsystems公司推出的面向对象的程序设计语言，特别适合于互联网应用程序开发；而JavaScript是Netscape公司的产品，为了扩展Netscape浏览器的功能而开发的一种可以嵌入Web页面中运行的基于对象和事件驱动的解释性语言。JavaScript的前身是LiveScript；而Java的前身是Oak语言。
下面对两种语言间的异同作如下比较：

* 基于对象和面向对象：Java是一种真正的面向对象的语言，即使是开发简单的程序，必须设计对象；JavaScript是种脚本语言，它可以用来制作与网络无关的，与用户交互作用的复杂软件。它是一种基于对象（Object-Based）和事件驱动（Event-Driven）的编程语言，因而它本身提供了非常丰富的内部对象供设计人员使用。
* 解释和编译：Java的源代码在执行之前，必须经过编译。JavaScript是一种解释性编程语言，其源代码不需经过编译，由浏览器解释执行。（目前的浏览器几乎都使用了JIT（即时编译）技术来提升JavaScript的运行效率）
* 强类型变量和类型弱变量：Java采用强类型变量检查，即所有变量在编译之前必须作声明；JavaScript中变量是弱类型的，甚至在使用变量前可以不作声明，JavaScript的解释器在运行时检查推断其数据类型。
* 代码格式不一样。

21. 简述正则表达式及其用途。

在编写处理字符串的程序时，经常会有查找符合某些复杂规则的字符串的需要。正则表达式就是用于描述这些规则的工具。换句话说，正则表达式就是记录文本规则的代码。

22. Java中是如何支持正则表达式操作的？

Java中的String类提供了支持正则表达式操作的方法，包括：matches()、replaceAll()、replaceFirst()、split()。此外，Java中可以用Pattern类表示正则表达式对象，它提供了丰富的API进行各种正则表达式操作，请参考下面面试题的代码。

如果要从字符串中截取第一个英文左括号之前的字符串，例如：北京市(朝阳区)(西城区)(海淀区)，截取结果为：北京市，那么正则表达式怎么写？

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
class RegExpTest {
    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}
```

23. Java和PHP的区别？

Java是一门计算机编程语言，和C++、Python等编程语言一样，Java如今依旧应用广泛。从我们日常用的安卓手机APP到大部分网站或管理信息系统的应用服务器程序都是用Java这中语言来写的。它之所以应用广泛，笔者认为与Java能顺应面向对象这一主流的编程思想有很大的关系，将数据结构及其处理方法集成起来可以减少代码量，让程序员更多地把精力放在对程序的设计上，增加程序的功能性；同时减少了C类语言中指针、多继承等概念，引入了多线程、分布式与嵌入式概念，并且配合虚拟机的使用，让Java成为最佳的跨平台语言。

PHP是Hypertext Preprocessor的缩写，是一种计算机脚本语言（Script languages）。脚本语言不需要像编程语言那样在编译时生成二进制可执行文件，而是直接对写好的PHP代码执行以达到效果。和同样的脚本语言JavaScript一样，PHP也是一种解释型语言，即可直接解释执行。与其说PHP是编程语言，不如说是一组命令。我们之所以用PHP和Java做比较是因为它也是面向对象的，同时也用到编程语言当中的一些变量，但他并没有像编程语言那样严格。正因为他是一组命令，可嵌入到Html中，实现网页特效，于是PHP被广泛应用到Web当中。

* java是纯面向对象开发,功能强大,分支众多,没有java不能做的软件,PHP有他独特的领域,那就是WEB在这方面没有可以和他相比较,其与java相比较之下在这一方面基本上完胜java 因其专注的领域不同 所以没有太大可比性,P
* 数据库访问比较. Java通过JDBC来访问数据库,通过不同的数据库厂商提供的数据库驱动方便地访问数据库。访问数据库的接口比较统一。PHP对于不同的数据库采用不同的数据库访问接口,所以数据库访问代码的通用性不强。
* 在开发上的区别:php在开发上比较快即写即用java则需要编译;Php占用内存少 而java比较占用内存;Java远程调用方便java的同语言调用不是采用纯粹的http调用,而且维护一定的连接,从而大大   提高性能。而php也有远程调用,但是相对来说就弱许多了。
* PHP的开发程序在别人拿到代码后,可以很容易的进行修改。而Java开发的程序由于无法看到完整的源代码,只能看到一些编译好的类文件.class,所以底层架构的诸多隐患都无法提前预知,一旦发生灾难性的错误,后果必将及其严重。
* 在循环测试中java执行的时间远远低于php所以  java的性能比较好
PHP适合于快速开发,中小型应用系统,开发成本低,能够对变动的需求作出快速的反应。而Java适合于开发大型的应用系统,应用的前景比较广阔,系统易维护、可复用性较好。
* php开发周期短  java开发过程相对较缓慢   前者代码运用比较混乱不会区分大小写   因此在后期开发当中一些命名较混乱不易区分  而Java是区分大小写的命名比较规范在之后的开发过程当中不易混乱 

24. 介绍一下Syncronized锁，如果用这个关键字修饰一个静态方法，锁住了什么？如果修饰成员方法，锁住了什么？

Synchronized是Java并发编程中最常用的用于保证线程安全的方式，其使用相对也比较简单。
Synchronized是Java中解决并发问题的一种最常用的方法，也是最简单的一种方法。Synchronized的作用主要有三个：（1）确保线程互斥的访问同步代码（2）保证共享变量的修改能够及时可见（3）有效解决重排序问题。从语法上讲，Synchronized总共有三种用法：
* 修饰普通方法
* 修饰静态方法
* 修饰代码块

25. 介绍一下volatile？

在并发编程中，我们通常会遇到以下三个问题：`原子性问题`，`可见性问题`，`有序性问题`。我们先看具体看一下这三个概念：

* 原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行
* 可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
* 有序性：即程序执行的顺序按照代码的先后顺序执行。举个简单的例子，看下面这段代码：

一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义
* 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的
* 禁止进行指令重排序。

26. 锁有了解嘛，说一下Synchronized和lock

synchronized的缺陷：
* 获取锁的线程执行完了该代码块，然后线程释放对锁的占有；
* 线程执行发生异常，此时JVM会让线程自动释放锁。

ReentrantLock，意思是“可重入锁”，关于可重入锁的概念在下一节讲述。ReentrantLock是唯一实现了Lock接口的类，并且ReentrantLock提供了更多的方法。下面通过一些实例看具体看一下如何使用ReentrantLock。

由于在前面讲到如果采用Lock，必须主动去释放锁，并且在发生异常时，不会自动释放锁。因此一般来说，使用Lock必须在try{}catch{}块中进行，并且将释放锁的操作放在finally块中进行，以保证锁一定被被释放，防止死锁的发生。通常使用Lock来进行同步的话，是以下面这种形式去使用的：

```java
Lock lock = ...;
lock.lock();
try{
    //处理任务
}catch(Exception ex){
     
}finally{
    lock.unlock();   //释放锁
}
```

27. 讲一讲Java里面的final关键字怎么用的？

* 修饰类当用final去修饰一个类的时候，表示这个类不能被继承。注意：a. 被final修饰的类，final类中的成员变量可以根据自己的实际需要设计为fianl。b. final类中的成员方法都会被隐式的指定为final方法。说明：在自己设计一个类的时候，要想好这个类将来是否会被继承，如果可以被继承，则该类不能使用fianl修饰，在这里呢，一般来说工具类我们往往都会设计成为一个fianl类。在JDK中，被设计为final类的有String、System等。
* 被final修饰的方法不能被重写。 一个类的private方法会隐式的被指定为final方法,如果父类中有final修饰的方法，那么子类不能去重写。
* 修饰成员变量,必须要赋初始值，而且是只能初始化一次。 如果修饰的成员变量是一个引用类型，则是说这个引用的地址的值不能修改，但是这个引用所指向的对象里面的内容还是可以改变的。

28. wait方法底层原理

JDK在Object对象中提供了2个非常重要的接口线程方法wait方法和notify方法，也就是所有Java对象都有这2个方法，意思就是当在一个实例Java对象上调用wait方法，那么当前线程就会从执行状态转变成等待状态，同时释放在实例对象上的锁，直到其它线程在刚才那个实例对象上调用notify方法并且释放实例对象上的锁，那么刚才那个当前线程才会再次获取实例对象锁并且继续执行。这样我们通过object对象就可以让多线程之间进行有效通信。

那么这2个方法是如何工作的呢？比如我们有一个person对象，如果一个线程T1调用person.wait（）,那么这个线程a就会进入person对象的等待队列，在这个等待队列中可能还有线程T2,线程T3,线程T4,因为系统可能通过4个线程来等待person实例对象，当我们调用person.notify（）方法，它就会从这个等待队列中随机选一个线程，并将其唤醒，在这里这个选择是不公平的，也就是选择线程T1,T2,T3,T4是随机的，当然了也可以调用person,notifyAll()方法，这个方法会把线程T1,T2,T3,T4全部唤醒。

需要注意的是person.wait()方法并不是随便调用的，它必须包含在对应的synchronzied中，无论是wait（）方法还是notify()方法都需要首先获取目标对象上的一个监视器,如下图所示

```java
public class Demo{
    final static Object person =new Object();
    public static class T1 extends Thread{
        public void run(){
            synchronized (person){
                System.out.println(System.currentTimeMillis()+"T1 come");
                try{
                    System.out.println(System.currentTimeMillis()+"T1 wait");
                    person.wait();
                }catch (InterruptedException r){
                    r.getStackTrace();
                }
                System.out.println(System.currentTimeMillis()+"T1 over");
            }
        }
    }
    public static class T2 extends Thread{
        public void run(){
            synchronized (person){
                System.out.println(System.currentTimeMillis()+"T2 come");
                person.notify();
                System.out.println(System.currentTimeMillis()+"T2 over");
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException r){
                    r.getStackTrace();
                }
 
            }
        }
    }
 
    public static void main(String args[]){
        try{
            Thread thread1=new T1();
            Thread thread2=new T2();
            thread1.start();
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
 
    }
}
```

29. Java有哪些特性，举个多态的例子。

1.java三大基本数据类型:`封装`,`继承`,`多态`.
2.多态的定义：指允许不同类的对象对同一消息做出响应,即同一消息可以根据发送对象的不同而采用多种不同的行为方式。

依赖注入IConfig接口，使用FileConfig类或者ConsoleConfig

30. String为啥不可变？

字符串常量类型
每次改变都会产生新的对象,内部字段都是`final`类型的，但是通过反射方式更改

```java
public final class String
    implements java.io.Serializable, Comparable<string>, CharSequence{
    /** The value is used for character storage. */
    private final char value[];
 
    /** The offset is the first index of the storage that is used. */
    private final int offset;
 
    /** The count is the number of characters in the String. */
    private final int count;
 
    /** Cache the hash code for the string */
    private int hash; // Default to 0</string>
```

31. 类和对象的区别

* 类是一个抽象的概念，它不存在于现实中的时间/空间里，类只是为所有的对象定义了抽象的属性与行为。就好像“Person（人）”这个类，它虽然可以包含很多个体，但它本身不存在于现实世界上。
* 对象是类的一个具体。它是一个实实在在存在的东西。
* 类是一个静态的概念，类本身不携带任何数据。当没有为类创建任何对象时，类本身不存在于内存空间中
* 对象是一个动态的概念。每一个对象都存在着有别于其它对象的属于自己的独特的属性和行为。对象的属性可以随着它自己的行为而发生改变。

32. 请列举你所知道的Object类的方法。

基本描述
* Object类位于java.lang包中，java.lang包包含着Java最基础和核心的类，在编译时会自动导入；
* Object类是所有Java类的祖先。每个类都使用 Object 作为超类。所有对象（包括数组）都实现这个类的方法。可以使用类型为Object的变量指向任意类型的对象

Object类方法
* **registerNatives();**：一个本地方法，具体是用C（C++）在DLL中实现的，然后通过JNI调用。
* **hashCode()**：Java中的hashCode方法就是根据一定的规则将与对象相关的信息（比如对象的存储地址，对象的字段等）映射成一个数值，这个数值称作为散列值。    
* **equals()**：比较两个对象是否相等。我们知道所有的对象都拥有标识(内存地址)和状态(数据)，同时“==”比较两个对象的的内存地址，所以说使用Object的equals()方法是比较两个对象的内存地址是否相等，即若object1.equals(object2)为true，则表示equals1和equals2实际上是引用同一个对象。
* **clone()**：快速创建一个已有对象的副本
* **toString()**：toString 方法会返回一个“以文本方式表示”此对象的字符串。结果应是一个简明但易于读懂的信息表达式。
* **finalize()**：垃圾回收器准备释放内存的时候，会先调用finalize()。

33. 重载和重写的区别？相同参数不同返回值能重载吗？

方法重载是让类以统一的方式处理不同类型数据的一种手段。多个同名函数同时存在，具有不同的参数个数/类型。Java的方法重载，就是在类中可以创建多个方法，它们具有相同的名字，但具有不同的参数和不同的定义。重载的时候，方法名要一样，但是参数类型和个数不一样，返回值类型可以相同也可以不相同。无法以返回型别作为重载函数的区分标准。

重写（Overriding）。父类与子类之间的多态性，对父类的函数进行重新定义。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。在Java中，子类可继承父类中的方法，而不需要重新编写相同的方法。若子类中的方法与父类中的某一方法具有相同的方法名、返回类型和参数表，则新方法将覆盖原有的方法。如需父类中原有的方法，可使用super关键字，该关键字引用了当前类的父类。

34. ”static”关键字是什么意思？Java中是否可以覆盖(override)一个private或者是static的方法？

* static方法：static方法一般称作静态方法，由于静态方法不依赖于任何对象就可以进行访问，因此对于静态方法来说，是没有this的，因为它不依附于任何对象，既然都没有对象，就谈不上this了。并且由于这个特性，在静态方法中不能访问类的非静态成员变量和非静态成员方法，因为非静态成员方法/变量都是必须依赖具体的对象才能够被调用。
* static变量：static变量也称作静态变量，静态变量和非静态变量的区别是：静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。static成员变量的初始化顺序按照定义的顺序进行初始化。
* static关键字还有一个比较关键的作用就是 用来形成静态代码块以优化程序性能。static块可以置于类中的任何地方，类中可以有多个static块。在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次

35. String能继承吗？

不能被继承，因为String类有final修饰符，而final修饰的类是不能被继承的。

```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    // 省略...　
}
```

36. String、StringBuffer和StringBuilder有什么区别，底层实现上呢？

这三个类之间的区别主要是在两个方面，即*运行速度*和*线程安全*这两方面。

1.首先说运行速度，或者说是执行速度，在这方面运行速度快慢为：StringBuilder > StringBuffer > String. String最慢的原因：String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，所以速度要比String快很多。

2.再来说线程安全:在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的

* String：适用于少量的字符串操作的情况
* StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
* StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况

37. 类加载机制，双亲委派模型，好处是什么？

Class文件由类装载器装载后，在JVM中将形成一份描述Class结构的元信息对象，通过该元信息对象可以获知Class的结构信息：如构造函数，属性和方法等，Java允许用户借由这个Class相关的元信息对象间接调用Class对象的功能。

虚拟机把描述类的数据从class文件加载到内存，并对数据进行校验，转换解析和初始化，最终形成可以被虚拟机直接使用的Java类型，这就是虚拟机的类加载机制。

双亲委派模型工作过程：如果一个类加载器接收到了类加载的请求，它首先把这个请求委托给他的父类加载器去完成，每个层次的类加载器都是如此，因此所有的加载请求都应该传送到顶层的启动类加载器中，只有当父加载器反馈自己无法完成这个加载请求（它在搜索范围中没有找到所需的类）时，子加载器才会尝试自己去加载。

38. Java静态变量存在哪?

39. 讲讲什么是Java泛型？

40. 解释extends 和super 泛型限定符-上界不存下界不取

41. 是否可以在static环境中访问非static变量？

42. 谈谈如何通过反射创建对象？

43. Java支持多继承么？

44. 接口和抽象类的区别是什么？

45. Comparable和Comparator接口是干什么的？列出它们的区别。

46. 面向对象的特征有哪些方面

47. final, finally, finalize的区别。

48. Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型?

49. abstract class和interface有什么区别?

50. Static Nested Class 和 Inner Class的不同

51. 当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递?

52. Java的接口和C++的虚类的相同和不同处。

53. JAVA语言如何进行异常处理，关键字：throws,throw,try,catch,finally分别代表什么意义？在try块中可以抛出异常吗？

54. 内部类可以引用他包含类的成员吗？有没有什么限制？

55. 两个对象值相同(x.equals(y) == true)，但却可有不同的hash code说法是否正确？

56. 如何通过反射获取和设置对象私有字段的值？

57. 谈一下面向对象的"六原则一法则"。

58. 请问Query接口的list方法和iterate方法有什么区别？

59. Java中，什么是构造函数？什么是构造函数重载？什么是复制构造函数？

60. hashCode()和equals()方法有什么联系？

61. Map和ConcurrentHashMap的区别？

62. hashMap内部具体如何实现的？

63. 如果hashMap的key是一个自定义的类，怎么办？

64. ArrayList和LinkedList的区别，如果一直在list的尾部添加元素，用哪个效率高？

65. HashMap底层，负载因子，为啥是2^n？

66. ConcurrentHashMap锁加在了哪些地方？

67. TreeMap底层，红黑树原理？

68. concurrenthashmap有啥优势，1.7，1.8区别？

69. ArrayList是否会越界？

70. 什么是TreeMap?

71. ConcurrentHashMap的原理是什么？

72. Java集合类框架的基本接口有哪些？

73. 为什么集合类没有实现Cloneable和Serializable接口？

74. 什么是迭代器？

75. Iterator和ListIterator的区别是什么？

76. 快速失败(fail-fast)和安全失败(fail-safe)的区别是什么？

77. HashMap和Hashtable有什么区别？

78. ArrayList,Vector,LinkedList的存储性能和特性是什么？

79. Collection 和 Collections的区别。

80. 你所知道的集合类都有哪些？主要方法？

81. List、Set、Map是否继承自Collection接口？

82. List、Set、Map三个接口存取元素时，各有什么特点？

83. 多线程中的i++线程安全吗？为什么？

84. 如何线程安全的实现一个计数器？

85. 多线程同步的方法

86. 介绍一下生产者消费者模式？

87. 线程，进程，然后线程创建有很大开销，怎么优化？

88. 线程池运行流程，参数，策略

89. 讲一下AQS吧

90. 创建线程的方法，哪个更好，为什么？

91. Java中有几种方式启动一个线程？

92. Java中有几种线程池？

93. 线程池有什么好处？

94. cyclicbarrier和countdownlatch的区别

95. 如何理解Java多线程回调方法？

96. 创建线程有几种不同的方式？你喜欢哪一种？为什么？

97. 概括的解释下线程的几种可用状态。

98. 同步方法和同步代码块的区别是什么？

99. 启动线程有哪几种方式，线程池有哪几种？

100. 在监视器(Monitor)内部，是如何做线程同步的？程序应该做哪种级别的同步？

101. sleep() 和 wait() 有什么区别？

102. 同步和异步有何异同，在什么情况下分别使用他们？举例说明。

103. 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。使用内部类实现线程，对j增减的时候没有考虑顺序问题。

104. 启动一个线程是用run()还是start()?

105. 请说出你所知道的线程同步的方法

106. 多线程有几种实现方法,都是什么?同步有几种实现方法,都是什么?

107. java中有几种方法可以实现一个线程？用什么关键字修饰同步方法? stop()和suspend()方法为何不推荐使用？

108. 线程的sleep()方法和yield()方法有什么区别？

109. 当一个线程进入一个对象的synchronized方法A之后，其它线程是否可进入此对象的synchronized方法B？

110. 请说出与线程同步以及线程调度相关的方法。

111. 举例说明同步和异步

112. 什么是线程池（thread pool）？

113. 说说线程的基本状态以及状态之间的关系？

114. 如何保证线程安全？

115. 讲一下非公平锁和公平锁在reetrantlock里的实现。

116. 讲一下synchronized，可重入怎么实现。

117. 锁和同步的区别。

118. 什么是死锁(deadlock)？

119. 如何确保N个线程可以访问N个资源同时又不导致死锁？

120. 请你简述synchronized和java.util.concurrent.locks.Lock的异同？

121. Java中的LongAdder和AtomicLong的区别

122. JDK和JRE的区别是什么？

123. 反射的实现与作用

124. 

125. 

126. 

127. 

128. 

129. 

130. 

131. 

132. 

133. 

134. 

135. 

136. 

137. 

138. 

139. 

140. 

141. 

142. 

143. 

144. 

145. 

146. 

147. 

148. 

149. 

150. 

151. 

152. 

153. 

154. 

155. 

156. 

157. 

158. 

159. 

160. 

161. 

162. 

163. 

164. 

165. 

166. 

167. 

168. 

169. 

170. 

171. 

172. 

173. 

174. 

175. 

176. 

177. 

178. 

179. 

180. 

181. 

182. 

183. 

184. 

185. 

186. 

187. 

188. 

189. 

190. 

191. 

192. 

193. 

194. 

195. 

196. 

197. 

198. 

199. 
