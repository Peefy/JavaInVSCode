
**1. Java对象重写equals时为什么同时重写hashcode函数**

因为Object的equal方法默认是两个对象的引用的比较，意思就是指向同一内存,地址则相等，否则不相等；如果你现在需要利用对象里面的值来判断是否相等，则重载equal方法。 

一般的地方不需要重载hashCode，只有当类需要放在HashTable、HashMap、HashSet等等hash结构的集合时才会 重载hashCode，那么为什么要重载hashCode呢？就HashMap来说，好比HashMap就是一个大内存块，里面有很多小内存块，小内存块 里面是一系列的对象，可以利用hashCode来查找小内存块hashCode%size(小内存块数量)，所以当equal相等时，hashCode必 须相等，而且如果是object对象，必须重载hashCode和equal方法。

因为是按照hashCode来访问小内存块，所以hashCode必须相等。

之所以hashCode相等，却可以equal不等，就比如ObjectA和ObjectB他们都有属性name，那么hashCode都以name计算，所以hashCode一样，但是两个对象属于不同类型，所以equal为false。

**2. 说一下map的分类和常见的情况**

* **HashMap**-最常用的Map，根据键的hashcode值来存储数据，根据键可以直接获得他的值（因为相同的键hashcode值相同，在地址为hashcode值的地方存储的就是值，所以根据键可以直接获得值），具有很快的访问速度，遍历时，取得数据的顺序完全是随机的，HashMap最多只允许一条记录的键为null，允许多条记录的值为null，HashMap不支持线程同步，即任意时刻可以有多个线程同时写HashMap，这样对导致数据不一致，如果需要同步，可以使用synchronziedMap的方法使得HashMap具有同步的能力或者使用concurrentHashMap
* **HashTable**-与HashMap类似，不同的是，它不允许记录的键或值为空，支持线程同步，即任意时刻只能有一个线程写HashTable，因此也导致HashTable在写入时比较慢!
* **LinkedHashMap**-是HahsMap的一个子类，但它保持了记录的插入顺序，遍历时先得到的肯定是先插入的，也可以在构造时带参数，按照应用次数排序，在遍历时会比HahsMap慢，不过有个例外，当HashMap的容量很大，实际数据少时，遍历起来会比LinkedHashMap慢（因为它是链啊），因为HashMap的遍历速度和它容量有关，LinkedHashMap遍历速度只与数据多少有关
* **TreeMap**-实现了sortMap接口，能够把保存的记录按照键排序（默认升序），也可以指定排序比较器，遍历时得到的数据是排过序的

什么情况用什么类型的Map：

* 在Map中插入，删除，定位元素：`HashMap`
* 要按照自定义顺序或自然顺序遍历：`TreeMap`
* 要求输入顺序和输出顺序相同：`LinkedHashMap`

**3. Object若不重写hashCode()的话，hashCode()如何计算出来的？**

Object的hashcode()方法是本地方法，也就是用c语言或c++实现的，该方法直接返回对象的内存地址。

**4. Java中==运算符比较的是什么？**

* 对于`基本类型变量`==操作比较的是两个变量的值是否相等，对于`引用型变量`表示的是两个变量在堆中存储的地址是否相同，即栈中的内容是否相同。

*注意：比较运算符==用于判断字符串的地址是否相同，即使字符串内容相同，但是对象不同，返回值仍是false。*

* equals操作表示的两个变量是否是对同一个对象的引用，即堆中的内容是否相同。

**5. 若对一个类不重写，它的equals()方法是如何比较的？**

如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；此时跟使用==没有任何区别

**6. java8新特性**

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

**7. Java Lambda表达式的优缺点。**

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

**8. Java一个十进制的数在内存中是怎么存的？**

二进制补码的形式存储

**9. 为啥有时会出现4.0-3.6=0.40000001这种现象？**

在二进制系统中无法精确地表示分数1/10，这就好像十进制无法精确地表示分数1/3一样。如果在数值计算中不允许有任何舍入误差 ，就应该使用BigDecimal类。

**10. Java支持的数据类型有哪些？什么是自动拆装箱？**

Java中有八种基本数据类型以及引用类型

基本数据类型：byte（1字节），short（2字节），int（4字节），long（8字节），char（2字节），boolean（不确定，取值是true/false），float（4字节），double（8字节）

引用数据类型：包括数组，集合，字符串，接口以及类等

自动装箱/自动拆箱：就是指基本数据类型可以和其对应包装类之间自动转换

**11. Java值传递和引用传递？**

java中是没有指针的，java中只存在值传递。然而我们经常看到对于对象（数组，类，接口）的传递似乎有点像引用传递，可以改变对象中某个属性的值，实际上这个传入函数的值是对象引用的拷贝，即传递的是引用的地址值，所以还是按值传递。

**12. 数组(Array)和列表(ArrayList)有什么区别？什么时候应该使用Array而不是ArrayList？**

下面列出了Array和ArrayList的不同点：
* Array可以包含基本类型和对象类型，ArrayList只能包含对象类型。
* Array大小是固定的，ArrayList的大小是动态变化的。
* ArrayList提供了更多的方法和特性，比如：addAll()，removeAll()，iterator()等等。
对于基本类型数据，集合使用自动装箱来减少编码工作量。但是，当处理固定大小的基本数据类型的时候，这种方式相对比较慢。

arraylist扩充机制：newCapacity=oldCapacity+(oldCapacity>>1)（注： >>1:右移1位，相当于除以2，例如10>>1 得到的就是5）但由于源码里（不再分析，这里简要略过）传过来的minCapcatiy的值是size+1，能够实现grow方法调用就肯定是(size+1)>elementData.length的情况，所以size就是初始最大容量或上一次扩容后达到的最大容量，所以才会进行扩容。因此，扩容后的大小应该是原来的1.5倍+1

**13. 你了解大O符号(big-O notation)么？你能给出不同数据结构的例子么？**

大O符号表示当数据结构的元素增加的时候，算法规模或者性能在最坏场景下有多好。

大O符号也可以用来描述其他行为，比如说内存消耗。因为集合实际上就是一种数据结构，我们一
般用大O符号基于时间、性能、内存消耗来选择最好的实现。

如列表的插入时间为0(1)、二叉搜索树的插入时间为O(lgn)、哈希表的查找时间为O(1)

**14. Java String是最基本的数据类型吗?**

不是。Java中的基本数据类型只有8个：boolean、char、byte、short、int、long、float、double；除了基本数据类型（primitive type）和枚举类型（enumeration type），剩下的都是引用类型（reference type）。

**15. int 和 Integer 有什么区别**

**int**

int是我们常说的整型数字，是Java的8个原始数据类型（Primitive Type：boolean、byte、short、char、int、float、double、long）之一。Java语言虽然号称一切都是对象，但原始数据是例外。

**Integer**

Integer是int对应的包装类，它有一个int类型的字段存储数据，并且提供了基本操作，比如数学运算，int和字符串之间转换等。在Java5中引入了自动装箱和自动拆箱功能，Java可以根据上下文，自动进行转换，极大的简化了相关编程。

**16. String/StringBuffer/StringBuilder的区别**

这三个类之间的区别主要是在两个方面，即*运行速度*和*线程安全*这两方面。

1.首先说运行速度，或者说是执行速度，在这方面运行速度快慢为：StringBuilder > StringBuffer > String. String最慢的原因：String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，所以速度要比String快很多。

2.再来说线程安全:在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的

* String：适用于少量的字符串操作的情况
* StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
* StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况

**17. 我们在web应用开发过程中经常遇到输出某种编码的字符，如iso8859-1等，如何输出一个某种编码的字符串？**

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

**18. &和&&的区别？**

两种解释

(&,\|)它们是逻辑操作，(&&,\|\|)它们是条件操作。
&是位运算符，表示按位与运算，&&是逻辑运算符，表示逻辑运算与（and）.
\|\| 按位或运算符 ，表示按位或运算，\|\|是逻辑或算符，表示逻辑或运算。
条件操作只能操作布尔型的,而逻辑操作不仅可以操作布尔型,而且可以操作数值型的。
不同点：
对于A&B，不管a是否为假，仍然要判断B。
对于A\|B，不管a是否为真，仍然要判断B。
而对于A&&B，A\|\|B在以上情况就不会去判断B了。

**19. 在Java中，如何跳出当前的多重嵌套循环？**

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

**20. Java和JavaSciprt的异同？**

JavaScript 与Java是两个公司开发的不同的两个产品。Java 是原Sun Microsystems公司推出的面向对象的程序设计语言，特别适合于互联网应用程序开发；而JavaScript是Netscape公司的产品，为了扩展Netscape浏览器的功能而开发的一种可以嵌入Web页面中运行的基于对象和事件驱动的解释性语言。JavaScript的前身是LiveScript；而Java的前身是Oak语言。
下面对两种语言间的异同作如下比较：

* 基于对象和面向对象：Java是一种真正的面向对象的语言，即使是开发简单的程序，必须设计对象；JavaScript是种脚本语言，它可以用来制作与网络无关的，与用户交互作用的复杂软件。它是一种基于对象（Object-Based）和事件驱动（Event-Driven）的编程语言，因而它本身提供了非常丰富的内部对象供设计人员使用。
* 解释和编译：Java的源代码在执行之前，必须经过编译。JavaScript是一种解释性编程语言，其源代码不需经过编译，由浏览器解释执行。（目前的浏览器几乎都使用了JIT（即时编译）技术来提升JavaScript的运行效率）
* 强类型变量和类型弱变量：Java采用强类型变量检查，即所有变量在编译之前必须作声明；JavaScript中变量是弱类型的，甚至在使用变量前可以不作声明，JavaScript的解释器在运行时检查推断其数据类型。
* 代码格式不一样。

**21. 简述正则表达式及其用途。**

在编写处理字符串的程序时，经常会有查找符合某些复杂规则的字符串的需要。正则表达式就是用于描述这些规则的工具。换句话说，正则表达式就是记录文本规则的代码。

**22. Java中是如何支持正则表达式操作的？**

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

**23. Java和PHP的区别？**

Java是一门计算机编程语言，和C++、Python等编程语言一样，Java如今依旧应用广泛。从我们日常用的安卓手机APP到大部分网站或管理信息系统的应用服务器程序都是用Java这中语言来写的。它之所以应用广泛，笔者认为与Java能顺应面向对象这一主流的编程思想有很大的关系，将数据结构及其处理方法集成起来可以减少代码量，让程序员更多地把精力放在对程序的设计上，增加程序的功能性；同时减少了C类语言中指针、多继承等概念，引入了多线程、分布式与嵌入式概念，并且配合虚拟机的使用，让Java成为最佳的跨平台语言。

PHP是Hypertext Preprocessor的缩写，是一种计算机脚本语言（Script languages）。脚本语言不需要像编程语言那样在编译时生成二进制可执行文件，而是直接对写好的PHP代码执行以达到效果。和同样的脚本语言JavaScript一样，PHP也是一种解释型语言，即可直接解释执行。与其说PHP是编程语言，不如说是一组命令。我们之所以用PHP和Java做比较是因为它也是面向对象的，同时也用到编程语言当中的一些变量，但他并没有像编程语言那样严格。正因为他是一组命令，可嵌入到Html中，实现网页特效，于是PHP被广泛应用到Web当中。

* java是纯面向对象开发,功能强大,分支众多,没有java不能做的软件,PHP有他独特的领域,那就是WEB在这方面没有可以和他相比较,其与java相比较之下在这一方面基本上完胜java 因其专注的领域不同 所以没有太大可比性,P
* 数据库访问比较. Java通过JDBC来访问数据库,通过不同的数据库厂商提供的数据库驱动方便地访问数据库。访问数据库的接口比较统一。PHP对于不同的数据库采用不同的数据库访问接口,所以数据库访问代码的通用性不强。
* 在开发上的区别:php在开发上比较快即写即用java则需要编译;Php占用内存少 而java比较占用内存;Java远程调用方便java的同语言调用不是采用纯粹的http调用,而且维护一定的连接,从而大大   提高性能。而php也有远程调用,但是相对来说就弱许多了。
* PHP的开发程序在别人拿到代码后,可以很容易的进行修改。而Java开发的程序由于无法看到完整的源代码,只能看到一些编译好的类文件.class,所以底层架构的诸多隐患都无法提前预知,一旦发生灾难性的错误,后果必将及其严重。
* 在循环测试中java执行的时间远远低于php所以  java的性能比较好
PHP适合于快速开发,中小型应用系统,开发成本低,能够对变动的需求作出快速的反应。而Java适合于开发大型的应用系统,应用的前景比较广阔,系统易维护、可复用性较好。
* php开发周期短  java开发过程相对较缓慢   前者代码运用比较混乱不会区分大小写   因此在后期开发当中一些命名较混乱不易区分  而Java是区分大小写的命名比较规范在之后的开发过程当中不易混乱 

**24. 介绍一下Syncronized锁，如果用这个关键字修饰一个静态方法，锁住了什么？如果修饰成员方法，锁住了什么？**

Synchronized是Java并发编程中最常用的用于保证线程安全的方式，其使用相对也比较简单。
Synchronized是Java中解决并发问题的一种最常用的方法，也是最简单的一种方法。Synchronized的作用主要有三个：（1）确保线程互斥的访问同步代码（2）保证共享变量的修改能够及时可见（3）有效解决重排序问题。从语法上讲，Synchronized总共有三种用法：
* 修饰普通方法
* 修饰静态方法
* 修饰代码块

**25. 介绍一下volatile？**

在并发编程中，我们通常会遇到以下三个问题：`原子性问题`，`可见性问题`，`有序性问题`。我们先看具体看一下这三个概念：

* 原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行
* 可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
* 有序性：即程序执行的顺序按照代码的先后顺序执行。举个简单的例子，看下面这段代码：

一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义
* 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的
* 禁止进行指令重排序。

**26. 锁有了解嘛，说一下Synchronized和lock**

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

**27. 讲一讲Java里面的final关键字怎么用的？**

* 修饰类当用final去修饰一个类的时候，表示这个类不能被继承。注意：a. 被final修饰的类，final类中的成员变量可以根据自己的实际需要设计为fianl。b. final类中的成员方法都会被隐式的指定为final方法。说明：在自己设计一个类的时候，要想好这个类将来是否会被继承，如果可以被继承，则该类不能使用fianl修饰，在这里呢，一般来说工具类我们往往都会设计成为一个fianl类。在JDK中，被设计为final类的有String、System等。
* 被final修饰的方法不能被重写。 一个类的private方法会隐式的被指定为final方法,如果父类中有final修饰的方法，那么子类不能去重写。
* 修饰成员变量,必须要赋初始值，而且是只能初始化一次。 如果修饰的成员变量是一个引用类型，则是说这个引用的地址的值不能修改，但是这个引用所指向的对象里面的内容还是可以改变的。

**28. wait方法底层原理**

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

**29. Java有哪些特性，举个多态的例子。**

1.java三大基本数据类型:`封装`,`继承`,`多态`.
2.多态的定义：指允许不同类的对象对同一消息做出响应,即同一消息可以根据发送对象的不同而采用多种不同的行为方式。

依赖注入IConfig接口，使用FileConfig类或者ConsoleConfig

**30. String为啥不可变？**

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

**31. 类和对象的区别**

* 类是一个抽象的概念，它不存在于现实中的时间/空间里，类只是为所有的对象定义了抽象的属性与行为。就好像“Person（人）”这个类，它虽然可以包含很多个体，但它本身不存在于现实世界上。
* 对象是类的一个具体。它是一个实实在在存在的东西。
* 类是一个静态的概念，类本身不携带任何数据。当没有为类创建任何对象时，类本身不存在于内存空间中
* 对象是一个动态的概念。每一个对象都存在着有别于其它对象的属于自己的独特的属性和行为。对象的属性可以随着它自己的行为而发生改变。

**32. 请列举你所知道的Object类的方法。**

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

**33. 重载和重写的区别？相同参数不同返回值能重载吗？**

方法重载是让类以统一的方式处理不同类型数据的一种手段。多个同名函数同时存在，具有不同的参数个数/类型。Java的方法重载，就是在类中可以创建多个方法，它们具有相同的名字，但具有不同的参数和不同的定义。重载的时候，方法名要一样，但是参数类型和个数不一样，返回值类型可以相同也可以不相同。无法以返回型别作为重载函数的区分标准。

重写（Overriding）。父类与子类之间的多态性，对父类的函数进行重新定义。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。在Java中，子类可继承父类中的方法，而不需要重新编写相同的方法。若子类中的方法与父类中的某一方法具有相同的方法名、返回类型和参数表，则新方法将覆盖原有的方法。如需父类中原有的方法，可使用super关键字，该关键字引用了当前类的父类。

**34. ”static”关键字是什么意思？Java中是否可以覆盖(override)一个private或者是static的方法？**

* static方法：static方法一般称作静态方法，由于静态方法不依赖于任何对象就可以进行访问，因此对于静态方法来说，是没有this的，因为它不依附于任何对象，既然都没有对象，就谈不上this了。并且由于这个特性，在静态方法中不能访问类的非静态成员变量和非静态成员方法，因为非静态成员方法/变量都是必须依赖具体的对象才能够被调用。
* static变量：static变量也称作静态变量，静态变量和非静态变量的区别是：静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。static成员变量的初始化顺序按照定义的顺序进行初始化。
* static关键字还有一个比较关键的作用就是 用来形成静态代码块以优化程序性能。static块可以置于类中的任何地方，类中可以有多个static块。在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次

**35. String能继承吗？**

不能被继承，因为String类有final修饰符，而final修饰的类是不能被继承的。

```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    // 省略...　
}
```

**36. String、StringBuffer和StringBuilder有什么区别，底层实现上呢？**

这三个类之间的区别主要是在两个方面，即*运行速度*和*线程安全*这两方面。

1.首先说运行速度，或者说是执行速度，在这方面运行速度快慢为：StringBuilder > StringBuffer > String. String最慢的原因：String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，所以速度要比String快很多。

2.再来说线程安全:在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的

* String：适用于少量的字符串操作的情况
* StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
* StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况

**37. 类加载机制，双亲委派模型，好处是什么？**

Class文件由类装载器装载后，在JVM中将形成一份描述Class结构的元信息对象，通过该元信息对象可以获知Class的结构信息：如构造函数，属性和方法等，Java允许用户借由这个Class相关的元信息对象间接调用Class对象的功能。

虚拟机把描述类的数据从class文件加载到内存，并对数据进行校验，转换解析和初始化，最终形成可以被虚拟机直接使用的Java类型，这就是虚拟机的类加载机制。

双亲委派模型工作过程：如果一个类加载器接收到了类加载的请求，它首先把这个请求委托给他的父类加载器去完成，每个层次的类加载器都是如此，因此所有的加载请求都应该传送到顶层的启动类加载器中，只有当父加载器反馈自己无法完成这个加载请求（它在搜索范围中没有找到所需的类）时，子加载器才会尝试自己去加载。

**38. Java静态变量存在哪?**

从JVMS角度而言是在方法区（Method Area），对于特定的实现的话，例如Oracle HotSpot而言是在持久区（Permanent Area）,HotSpot后续版本中会移除掉持久区的概念。 

**39. 讲讲什么是Java泛型？**

泛型在java中有很重要的地位，在面向对象编程及各种设计模式中有非常广泛的应用。泛型，即“参数化类型”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。
顾名思义，就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），

然后在使用/调用时传入具体的类型（类型实参）。

泛型的本质是为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）。也就是说在泛型使用过程中，

操作的数据类型被指定为一个参数，这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法。

泛型类

```java
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T extends Number>{ 
    //key这个成员变量的类型为T,T的类型由外部指定  
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
}
```

泛型方法

```java
/**
 * 泛型方法的基本介绍
 * @param tClass 传入的泛型实参
 * @return T 返回值为T类型
 * 说明：
 *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
 *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
 *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
 *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
 */
public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
  IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
}
```

**40. 解释extends 和super 泛型限定符(上界不存下界不取)**

`extends` 指定上界限，只能传入本类和子类
`super` 指定下界限，只能传入本类和父类

extends上限通配符，用来限制类型的上限。super下限通配符，用来限制类型的下限

**41. 是否可以在static环境中访问非static变量？**

这个要从java的内存机制去分析，首先当你New 一个对象的时候，并不是先在堆中为对象开辟内存空间，而是先将类中的静态方法（带有static修饰的静态函数）的代码加载到一个叫做方法区的地方，然后再在堆内存中创建对象。所以说静态方法会随着类的加载而被加载。当你new一个对象时，该对象存在于对内存中，this关键字一般指该对象，但是如果没有new对象，而是通过类名调用该类的静态方法也可以。

**42. 谈谈如何通过反射创建对象？**

JAVA反射机制是在运行状态中，对于任意一个类。都能都知道这个类的所有属性和方法，对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称之为java语言的反射机制；

newInstance()方法 ---> 获取class类型之后,可以创建该类型的对象

**43. Java支持多继承么？**

java不支持多继承，只支持单继承（即一个类只能有一个父类）。但是java接口支持多继承，即一个子接口可以有多个父接口。（接口的作用是用来扩展对象的功能，一个子接口继承多个父接口，说明子接口扩展了多个功能，当类实现接口时，类就扩展了相应的功能）

**44. 接口和抽象类的区别是什么？**

参数|抽象类|接口
-|-|-
默认的方法实现|它可以有默认的方法实现|接口完全是抽象的。它根本不存在方法的实现
实现|子类使用extends关键字来继承抽象类。如果子类不是抽象类的话，它需要提供抽象类中所有声明的方法的实现。|子类使用关键字implements来实现接口。它需要提供接口中所有声明的方法的实现
构造器|抽象类可以有构造器|接口不能有构造器
与正常Java类的区别|除了不能实例化抽象类之外，它和普通Java类没有任何区别|接口是完全不同的类型
访问修饰符|抽象方法可以有public、protected和default这些修饰符|接口方法默认修饰符是public,不可以使用其它修饰符。
main方法|抽象方法可以有main方法并且我们可以运行它|接口没有main方法，因此不能运行它。
多继承|抽象方法可以继承一个类和实现多个接口|接口只可以继承一个或多个其它接口
速度|比接口速度要快|接口是稍微有点慢的，因为它需要时间去寻找在类中实现的方法。
添加新方法|如果你往抽象类中添加新的方法，可以给它提供默认的实现。因此不需要改变你现在的代码。|如果往接口中添加方法，那么必须改变实现该接口的类。

Java8中的默认方法和静态方法：默认方法和静态方法，以此来减少抽象类和接口之间的差异。

**45. Comparable和Comparator接口区别。**

Comparable是排序接口。若一个类实现了Comparable接口，就意味着该类支持排序。实现了Comparable接口的类的对象的列表或数组可以通过Collections.sort或Arrays.sort进行自动排序。

Comparator是比较接口，我们如果需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)，那么我们就可以建立一个“该类的比较器”来进行排序，这个“比较器”只需要实现Comparator接口即可。也就是说，我们可以通过实现Comparator来新建一个比较器，然后通过这个比较器对类进行排序。该接口定义如下：

*区别*

Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。而Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。

Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。

两种方法各有优劣， 用Comparable 简单， 只要实现Comparable 接口的对象直接就成为一个可以比较的对象，但是需要修改源代码。 用Comparator 的好处是不需要修改源代码， 而是另外实现一个比较器， 当某个自定义的对象需要作比较的时候，把比较器和对象一起传递过去就可以比大小了， 并且在Comparator 里面用户可以自己实现复杂的可以通用的逻辑，使其可以匹配一些比较简单的对象，那样就可以节省很多重复劳动了。

**46. 面向对象的特征有哪些方面**

三大特征是：`封装`、`继承`和`多态`。

* 封装是指将某事物的属性和行为包装到对象中，这个对象只对外公布需要公开的属性和行为，而这个公布也是可以有选择性的公布给其它对象。在java中能使用private、protected、public三种修饰符或不用（即默认defalut）对外部对象访问该对象的属性和行为进行限制。
* 继承是子对象可以继承父对象的属性和行为，亦即父对象拥有的属性和行为，其子对象也就拥有了这些属性和行为。这非常类似大自然中的物种遗传。
* 多态不是很好解释：更倾向于使用java中的固定用法，即overriding（重写）和overload（重载）。多态则是体现在overriding（重写）上，而overload（重载）则不属于面向对象中多态的范畴，因为overload（重载）概念在非面向对象中也存在。overriding（重写）是面向对象中的多态，因为overriding（重写）是与继承紧密联系，是面向对象所特有的。多态是指父对象中的同一个行为能在其多个子对象中有不同的表现。也就是说子对象可以使用重写父对象中的行为，使其拥有不同于父对象和其它子对象的表现，这就是overriding（重写）。

**47. final, finally, finalize的区别。**

* 在java中，final可以用来修饰类，方法和变量（成员变量或局部变量）。防止修改的作用
* finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块
* finalize()是在java.lang.Object里定义的，也就是说每一个对象都有这么个方法。这个方法在gc启动，该对象被回收的时候被调用。其实gc可以回收大部分的对象（凡是new出来的对象，gc都能搞定，一般情况下我们又不会用new以外的方式去创建对象），所以一般是不需要程序员去实现finalize的。 

**48. Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型?**

Overload是重载的意思，Override是覆盖的意思，也就是重写。

重载Overload：在同一个类中，允许存在一个以上的同名函数，只要他们的参数个数或者参数类型不同即可。

重载的特点：与返回值类型无关，只看参数列表。

重写Override表示子类中的方法可以与父类中的某个方法的名称和参数完全相同，通过子类创建的实例对象调用这个方法时，将调用子类中定义的方法，这相当于把父类中定义的那个完全相同的方法给覆盖掉了，这也是面向对象编程的多态的一种表现。子类覆盖父类方法时只能抛出父类的异常或者异常的子类或者父类异常的子集，因为子类可以解决父类的一些问题，但不能比父类有更多的问题。还有，子类方法的访问权限只能比父类的更大，不能更小。如果父类的方法是private类型，则子类中根本不存在覆盖，即子类中和父类的private的同名的方法没有覆盖的关系，因为private的访问权限只限于同一类中，而子类就不会访问到private的方法，所以是子类中增加的一个全新的方法。

重载overload的特点就是与返回值无关，只看参数列表，所以重载的方法是可以改变返回值类型的。所以，如果两个方法的参数列表完全一样，是不能通过让他们的返回值类型不同来实现重载的。我们可以用反证法来说明这个问题，因为我们有时候调用一个方法时也可以不定义返回结果变量，即不要关心其返回结果，例如，我们调用map.remove(key)方法时，虽然remove方法有返回值，但是我们通常都不会定义接收返回结果的变量，这时候假设该类中有两个名称和参数列表完全相同的方法，仅仅是返回类型不同，java就无法确定编程者倒底是想调用哪个方法了，因为它无法通过返回结果类型来判断。

**49. JDK里的设计模式**

* **结构型模型**

1. **适配器**-用来把一个接口转化成另一个接口，如 java.util.Arrays#asList()。
2. **桥接模式**-这个模式将抽象和抽象操作的实现进行了解耦，这样使得抽象和实现可以独立地变化，如JDBC；
3. **组合模式**-使得客户端看来单个对象和对象的组合是同等的。换句话说，某个类型的方法同时也接受自身类型作为参数，如 Map.putAll，List.addAll、Set.addAll。
4. **装饰者模式**-动态的给一个对象附加额外的功能，这也是子类的一种替代方式，如 java.util.Collections#checkedList\|Map\|Set\|SortedSet\|SortedMap。
5. **享元模式**-使用缓存来加速大量小对象的访问时间，如 valueOf(int)。
6. **代理模式**-代理模式是用一个简单的对象来代替一个复杂的或者创建耗时的对象，如 java.lang.reflect.Proxy

* **创建模式**

1. **抽象工厂模式**-抽象工厂模式提供了一个协议来生成一系列的相关或者独立的对象，而不用指定具体对象的类型，如 java.util.Calendar#getInstance()。
2. **建造模式(Builder)**-定义了一个新的类来构建另一个类的实例，以简化复杂对象的创建，如：java.lang.StringBuilder#append()。
3. **工厂方法**-就是 一个返* 回具体对象的方法，而不是多个，如 java.lang.Object#toString()、java.lang.Class#newInstance()。
4. **原型模式**-使得类的实例能够生成自身的拷贝、如：java.lang.Object#clone()。
5. **单例模式**-全局只有一个实例，如 java.lang.Runtime#getRuntime()。

* **行为模式**

1. **责任链模式**-通过把请求从一个对象传递到链条中下一个对象的方式，直到请求被处理完毕，以实现对象间的解耦。如 javax.servlet.Filter#doFilter()。
2. **命令模式**-将操作封装到对象内，以便存储，传递和返回，如：java.lang.Runnable。
3. **解释器模式**-定义了一个语言的语法，然后解析相应语法的语句，如，java.text.Format，java.text.Normalizer。
4. **迭代器模式**-提供一个一致的方法来顺序访问集合中的对象，如 java.util.Iterator。
5. **中介者模式**-通过使用一个中间对象来进行消息分发以及减少类之间的直接依赖，java.lang.reflect.Method#invoke()。
6. **空对象模式**-如 java.util.Collections#emptyList()。
7. **观察者模式**-它使得一个对象可以灵活的将消息发送给感兴趣的对象，如 java.util.EventListener。
8. **模板方法模式**-让子类可以重写方法的一部分，而不是整个重写，如 java.util.Collections#sort()。

**50. Static Nested Class(嵌套类) 和 Inner Class(内部类)的不同**

Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。

Inner Class（内部类）定义在类中的类。 
Nested Class（嵌套类）是静态（static）内部类。1. 要创建嵌套类的对象，并不需要其外围类的对象。 2. 不能从嵌套类的对象中访问非静态的外围类对象。

**51. 当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递?**

答:是值传递。Java 编程语言只有值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是该对象的引用一个副本。指向同一个对象,对象的内容可以在被调用的方法中改变，但对象的引用(不是引用的副本)是永远不会改变的。
　　Java参数，不管是原始类型还是引用类型，传递的都是副本(有另外一种说法是传值，但是说传副本更好理解吧，传值通常是相对传址而言)。
　　如果参数类型是原始类型，那么传过来的就是这个参数的一个副本，也就是这个原始参数的值，这个跟之前所谈的传值是一样的。如果在函数中改变了副本的值不会改变原始的值.
　　如果参数类型是引用类型，那么传过来的就是这个引用参数的副本，这个副本存放的是参数的地址。如果在函数中没有改变这个副本的地址，而是改变了地址中的 值，那么在函数内的改变会影响到传入的参数。如果在函数中改变了副本的地址，如new一个，那么副本就指向了一个新的地址，此时传入的参数还是指向原来的 地址，所以不会改变参数的值。

**52. Java的接口和C++的虚类的相同和不同处。**

C++虚类相当于java中的抽象类，与接口的不同之处是：
* 一个子类只能继承一个抽象类（虚类），但能实现多个接口
* 一个抽象类可以有构造方法，接口没有构造方法
* 一个抽象类中的方法不一定是抽象方法，即其中的方法可以有实现（有方法体），接口中的方法都是抽象方法，不能有方法体，只有声明
* 一个抽象类可以是public、private、protected、default，接口只有public
* 一个抽象类中的方法可以是public、private、protected、default，接口中的方法只能是public和default

C++虚类和Java接口相同之处是都不能实例化

*P.S. 接口是一类特殊的抽象类，是更抽象的抽象类，你可能这样理解。抽象类是一个不完整的类，接口只是定义了一些功能。*

**53. JAVA语言如何进行异常处理，关键字：throws,throw,try,catch,finally分别代表什么意义？在try块中可以抛出异常吗？**

* throws是获取异常
* throw是抛出异常
* try是将会发生异常的语句括起来，从而进行异常的处理
* catch是如果有异常就会执行他里面的语句
* 而finally不论是否有异常都会进行执行的语句

*throw和throws的详细区别如下：*throw是语句抛出一个异常。
throws是方法可能抛出异常的声明。(用在声明方法时，表示该方法可能要抛出异常)
语法：\[(修饰符)\](返回值类型)(方法名)(\[参数列表\])\[throws(异常类)\]{......}
            public void doA(int a) throws Exception1,Exception3{......}

**54. 内部类可以引用他包含类的成员吗？有没有什么限制？**

完全可以。如果不是静态内部类，那没有什么限制！ 一个内部类对象可以访问创建它的外部类对象的成员包括私有成员。如果你把静态嵌套类当作内部类的一种特例，那在这种情况下不可以访问外部类的普通成员变量，而只能访问外部类中的静态成员

* **静态内部类**：它是用static修饰的，在访问限制上它只能访问外部类中的static所修饰的成员变量或者是方法：
* **成员内部类**：成员内部类是最普通的内部类，它可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
* **局部内部类**：局部内部类是定义在外围类的方法中的，在访问的时候它可以直接访问外围类的所有成员！但是不能随便访问局部变量，除非这个局部变量被final修饰。
* **匿名内部类**：匿名内部类其实就是局部内部类的简写格式，只能使用一次。内部类必须是继承一个类或者实现接口。

**55. 两个对象值相同(x.equals(y) == true)，但却可有不同的hash code说法是否正确？**

不对。Java语言的定义：
1. 对象相等则hashCode一定相等
2. hashCode相等对象未必相等

*注意：String等等类型equals是比较实际内容*

**56. Java如何通过反射获取和设置对象私有字段的值？**

可以通过类对象的getDeclaredField()方法字段（Field）对象，然后再通过字段对象的setAccessible(true)将其设置为可以访问，接下来就可以通过get/set方法来获取/设置字段的值了。

**57. 面向对象的"六原则一法则"**

六原则

* **单一职责原则**-一个类只做它该做的事情。
* **开闭原则**-软件实体应当对扩展开放，对修改关闭。
* **依赖倒转原则**-面向接口编程。该原则说得直白和具体一些就是声明方法的参数类型、方法的返回类型、变量的引用类型时，尽可能使用抽象类型而不用具体类型，因为抽象类型可以被它的任何一个子类型所替代，请参考下面的里氏替换原则。
* **里氏替换原则**-任何时候都可以用子类型替换掉父类型。
* **接口隔离原则**-接口要小而专，绝不能大而全。
* **合成聚合复用原则**-优先使用聚合或合成关系复用代码。

一法则

* **迪米特法则**-迪米特法则又叫最少知识原则，一个对象应当对其他对象有尽可能少的了解。迪米特法则简单的说就是如何做到"低耦合"，门面模式和调停者模式就是对迪米特法则的践行。

**58. 请问Query接口的list方法和iterate方法有什么区别？**

对于Query接口的list()方法与iterate()方法来说，都可以实现获取查询的对象，但是list()方法返回的每个对象都是完整的（对象中的每个属性都被表中的字段填充上了），而iterator()方法所返回的对象中仅包含了主键值（标识符），只有当你对iterator中的对象进行操作时，Hibernate才会向数据库再次发送SQL语句来获取该对象的属性值。

**59. Java中，什么是构造函数？什么是构造函数重载？什么是复制构造函数？**

当新对象被创建的时候，构造函数会被调用。每一个类都有构造函数。在程序员没有提供构造函数的情况下，Java编译器会为这个类创建一个默认的构造函数。

Java中的构造函数重载和方法重载很类似，可以为一个类创建多个构造函数。每一个构造函数都必须有它自己唯一的参数列表

**60. hashCode()和equals()方法有什么联系？**

* 不会创建“类对应的散列表”这里所说的“不会创建类对应的散列表”是说：我们不会在HashSet, Hashtable, HashMap等等这些本质是散列表的数据结构中，用到该类。例如，不会创建该类的HashSet集合。在这种情况下，该类的“hashCode() 和 equals() ”没有关系的！这种情况下，equals() 用来比较该类的两个对象是否相等。而hashCode() 则根本没有任何作用，所以，不用理会hashCode()。
* 这里所说的“会创建类对应的散列表”是说：我们会在HashSet, Hashtable, HashMap等等这些本质是散列表的数据结构中，用到该类。例如，会创建该类的HashSet集合。在这种情况下，该类的“hashCode() 和 equals() ”是有关系的：1)、如果两个对象相等，那么它们的hashCode()值一定相同。这里的相等是指，通过equals()比较两个对象时返回true。2)、如果两个对象hashCode()相等，它们并不一定相等。因为在散列表中，hashCode()相等，即两个键值对的哈希值相等。然而哈希值相等，并不一定能得出键值对相等。补充说一句：“两个不同的键值对，哈希值相等”，这就是哈希冲突。此外，在这种情况下。若要判断两个对象是否相等，除了要覆盖equals()之外，也要覆盖hashCode()函数。否则，equals()无效。例如，创建Person类的HashSet集合，必须同时覆盖Person类的equals() 和 hashCode()方法。如果单单只是覆盖equals()方法。我们会发现，equals()方法没有达到我们想要的效果。

**61. Map和ConcurrentHashMap的区别？**

*(01)* `Map` 是“键值对”映射的抽象接口。

*(02)* `AbstractMap` 实现了Map中的绝大部分函数接口。它减少了“Map的实现类”的重复编码。

*(03)* `SortedMap` 有序的“键值对”映射接口。

*(04)* `NavigableMap` 是继承于SortedMap的，支持导航函数的接口。

*(05)* `HashMap`, `Hashtable`, `TreeMap`, `WeakHashMap`这4个类是“键值对”映射的实现类。它们各有区别！

* `HashMap` 是基于“拉链法”实现的散列表。一般用于单线程程序中。
* `Hashtable` 也是基于“拉链法”实现的散列表。它一般用于多线程程序中。
* `WeakHashMap` 也是基于“拉链法”实现的散列表，它一般也用于单线程程序中。相比HashMap，WeakHashMap中的键是“弱键”，当“弱键”被GC回收时，它对应的键值对也会被从WeakHashMap中删除；而HashMap中的键是强键。
* `TreeMap` 是有序的散列表，它是通过红黑树实现的。它一般用于单线程中存储有序的映射。

**62. hashMap内部具体如何实现的？**

HashMap是基于哈希表的Map接口实现，提供了所有可选的映射操作，并允许使用null值和null建，不同步且不保证映射顺序。下面记录一下研究HashMap实现原理。

在HashMap内部，通过维护一个 瞬时变量数组table (又称：桶) 来存储所有的键值对关系，桶 是个Entry对象数组，桶 的大小可以按需调整大小，长度必须是2的次幂。如下代码：

```java
/**
     * 一个空的entry数组，桶 的默认值
     */
    static final Entry<?,?>[] EMPTY_TABLE = {};

    /**
     * 桶，按需调整大小，但必须是2的次幂
     */
    transient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;
```

*初始容量与负载因子*

HashMap有两个参数影响性能，初始容量和负载因子。容量是哈希表中 桶 的数量，初始容量只是哈希表在创建时的容量，负载因子是哈希表在其容量自动增加之前可以达到多满的一种尺度。当哈希表中条目数超出了负载因子与当前容量的乘积时，则要对该Hash表进行rehash操作（即重建内部数据结构），重建时以当前容量的两倍数目新建。可以通过构造器设置初始容量与负载因子，默认初始容量是16个条目，最大容量是2^30次方个条目，默认负载因子是0.75

桶 就像一个存水的水桶，它默认的初始存水容量是16个单位的水，默认在灌水灌到16*0.75时，在下次添加数据时会先扩充容量，扩充到32单位。0.75就是负载因子，初始容量与负载因子可以通过创建水桶的时候进行设置。水桶最大的容量是2的30次方个单位的水。当初始容量设置的数量大于最大容量时，以最大容量为准。当扩展时如果大于等于最大容量时则直接返回。

如下为HashMap的部分源码，定义了默认初始容量、负载因子及其他一些常量：

```java
/**
     * 默认初始化容量，必须为2的次幂The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * 最大容量，如果通过构造函数参数中传递初始化容量大于该最大容量了，也会使用该容量为初始化容量     * 必须是2的次幂且小于等于2的30次方     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 默认的负载因子，可以通过构造函数指定
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 一个空的数组表，当 桶没有初始化的时候
     */
    static final Entry<?,?>[] EMPTY_TABLE = {};

    /**
     * 桶 , 存储所有的键值对条目，可以按需调整大小，长度大小必须为2的次幂 
     */
    transient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;

    /**
     * Map中键值对的数量，在每次新增或删除的时候都会对size进行+1或者-1操作.
     */
    transient int size;

    /**
     * 负载值，需要调整大小的临界值，为：(capacity * load factor).在每次调整大小后会使用新的容量计算一下
     * @serial
     */
    // If table == EMPTY_TABLE then this is the initial capacity at which the
    // table will be created when inflated.
    int threshold;

    /**
     * 负载因子，如果构造函数中没有指定，则采用默认的负载因子，
     *
     * @serial
     */
    final float loadFactor;

    /**
     * HashMap结构修改次数，结构修改时改变HashMap中的映射数量或修改其内部结构（例如，* rehash方法，重建内部数据结构），此字段用于在     * HashMap的集合视图上生成的迭代器都处理成快速失败的
     */
    transient int modCount;
```

*初始容量与负载因子性能调整*

通常，默认负载因子（0.75）在时间和空间成本上寻求一种折中。负载因子过高虽然减少了空间开销，但同时也增加了查询成本（在大多数HashMap类的操作中，包括get和put操作，都反映了这一点）。在设置初始容量时应该考虑到映射中所需的条目数及其负载因子，以便最大限度的减少rehash操作次数。如果初始容量大于最大条目数除以加载因子，则不会发生rehash操作。

如果很多映射关系要存储在HashMap实例中，则相对于按需执行自动的rehash操作以增大表的容量来说，使用足够大的初始容量创建它将使得映射关系能更有效的存储。

如下为重建HashMap数据结构的代码：

```java
void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) { // 如果容量已达最大限制，则设置下负载值后直接返回
            threshold = Integer.MAX_VALUE;
            return;
        }
        // 创建新的table存储数据
        Entry[] newTable = new Entry[newCapacity];
        // 将旧table中的数据转存到新table中去，这一步会花费比较多的时间
        transfer(newTable, initHashSeedAsNeeded(newCapacity));
        table = newTable;
        // 最后设置下下次调整大小的负载值
        threshold = (int) Math.min(newCapacity * loadFactor,
                MAXIMUM_CAPACITY + 1);
}
```

第四个构造方法是以已经存在的Map创建一个新的HashMap，稍后再说，前三个构造方法，其实最终调用的都是第三个带两个参数的方法，如果没有传递参数则使用默认的数值,代码如下：

```java
/**
     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
     * (16) and the default load factor (0.75).
     */
    public HashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    /**
     * Constructs an empty <tt>HashMap</tt> with the specified initial
     * capacity and the default load factor (0.75).
     *
     * @param  initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the specified initial
     * capacity and load factor.
     *
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the load factor is nonpositive
     */
    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);

        this.loadFactor = loadFactor;
        threshold = initialCapacity;
        init();
    }
```

*put方法*

```java
public V put(K key, V value) {
    // 对key的hashCode()做hash
    return putVal(hash(key), key, value, false, true);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    // tab为空则创建
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    // 计算index，并对null做处理
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        // 节点存在
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        // 该链为树
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        // 该链为链表
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        // 写入
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    // 超过load factor*current capacity，resize
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```

1. 首先put方法中，先判断 桶 是否为默认的未初始化状态，如果未初始化则调用 inflateTable 方法去初始化，然后判断参数key是否为null，如果为null，则调用putForNullKey专门进行放key为null的数据，putForNullKey方法与下面的第3步开始其实都是一样的，只不过key为null的数据默认存储位置就是第一个，即下标默认为0。
2. 如果key不是null,则调用hash()方法获取key的hash值，可以根据hash值、桶的长度通过indexFor方法计算该key可以放到桶的位置。
3. Entry对象中有一个属性next，可以形成一个单向链表，用来存储哈希值相同的元素。因此当计算出来key的hash值重复时，存储位置也会重复，只要判断一下存储位置的元素及该元素的next属性链表中是否与给定的key和key的hash值是否完全一致就可以了。如果有完全一致的，代表已经存在，则替换旧值，并把旧值做为返回值直接返回。
4. 把结构修改次数自增1
5. 调用addEntry方法将新的键值对增加到HashMap中。addEntity方法首先判断当前条目数据是否已经大于等于负载值（桶的容量*负载因子）且桶的指定位置不为null，如果已经大于且指定位置不为null，则调调整桶的容量为当前容量的2倍，调整桶的容量参照上面的初始容量与负载因子性能调整 目录。重新计算Hash值，计算存放位置。调用createEntry方法存放到 桶 中
6. 在 createEntry 方法中，首先获取指定位置的entry，然后新生成一个entry，在生成entry时把原有的entry存储到新生成的entry的next属性中（参考Entry的构造方法），并把指定位置的entry替换成新生成的。

```java
void addEntry(int hash, K key, V value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;
    }

   /**
    * Entry构造方法，创建一个新的Entry.
    */
    Entry(int h, K k, V v, Entry<K,V> n) {
        value = v;
        next = n;
        key = k;
        hash = h;
    }
```

get方法实现较简单，以下是几个步骤：

1. 首先判断key是否为null，如果为null，则调用 getForNullKey 方法来获取，如果不为null则调用 getEntry 方法来获取。getForNullKey方法与getEntity基本上一致，只不过少了一个步骤，就是默认的key为null的存储位置在第一个，即下标为0，没有去计算位置而已。
2. getEntity方法根据key计算哈希值，然后用哈希值、桶的长度计算存储位置。
3. getEntity以获取指定位置的entry作为遍历的开始，遍历entry的next单链表，如果entry的哈希值与计算的哈希值一致且entry的key与指定的相等则返回entry
4. 根据getEntity返回的值，get方法返回对应的值。

```java
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}
final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        // 直接命中
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            return first;
        // 未命中
        if ((e = first.next) != null) {
            // 在树中get
            if (first instanceof TreeNode)
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            // 在链表中get
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    return null;
}
```

**63. 如果hashMap的key是一个自定义的类，怎么办？**

如果hashMap的key是一个自定义的类，必须重写该类的hashcode()方法和equals（）方法

**64. ArrayList和LinkedList的区别，如果一直在list的尾部添加元素，用哪个效率高？**

ArrayList 底层数据结构是一中线性的数据结构 ArrayList 可以理解为动态数组，它的容量能动态增长，该容量是指用来存储列表的数组的大小，随着向ArrayList中不断添加元素，其容量也自动增长， ArrayList 容许包括null在内所有的元素 ArrayList 是List接口的非同步实现 ArrayList 是有序 LinkedList 基于链表的list接口的非同步实现 LinkedList 是容许包括null在内的所有元素 LinkedList 是有序的 ArrayList 访问任意位置，效率高 LinkedList 两端数据操作效率高

**65. HashMap底层，负载因子，为啥是2^n？**

*初始容量与负载因子性能调整*

通常，默认负载因子（0.75）在时间和空间成本上寻求一种折中。负载因子过高虽然减少了空间开销，但同时也增加了查询成本（在大多数HashMap类的操作中，包括get和put操作，都反映了这一点）。在设置初始容量时应该考虑到映射中所需的条目数及其负载因子，以便最大限度的减少rehash操作次数。如果初始容量大于最大条目数除以加载因子，则不会发生rehash操作。

如果很多映射关系要存储在HashMap实例中，则相对于按需执行自动的rehash操作以增大表的容量来说，使用足够大的初始容量创建它将使得映射关系能更有效的存储。

如下为重建HashMap数据结构的代码：

**66. ConcurrentHashMap锁加在了哪些地方？**

ConcurrentHashMap是Java5中新增加的一个线程安全的Map集合。对于ConcurrentHashMap是如何提高其效率的，可能大多人只是知道它使用了多个锁代替HashTable中的单个锁，也就是锁分离技术（Lock Stripping）。实际上，ConcurrentHashMap对提高并发方面的优化，还有一些其它的技巧在里面（比如在get操作的时候它是否也使用了锁来保护？）。

它把区间按照并发级别(concurrentLevel)，分成了若干个segment。默认情况下内部按并发级别为16来创建。对于每个segment的容量，默认情况也是16。当然并发级别(concurrentLevel)和每个段(segment)的初始容量都是可以通过构造函数设定的。

```java
static final class Segment<K,V> extends ReentrantLock implements Serializable 
```

Segment继承了ReentrantLock，表明每个segment都可以当做一个锁。这样对每个segment中的数据需要同步操作的话都是使用每个segment容器对象自身的锁来实现。只有对全局需要改变时锁定的是所有的segment。

上面的这种做法，就称之为“分离锁（lock striping）”。

分拆锁(lock spliting)就是若原先的程序中多处逻辑都采用同一个锁，但各个逻辑之间又相互独立，就可以拆(Spliting)为使用多个锁，每个锁守护不同的逻辑。
分拆锁有时候可以被扩展，分成可大可小加锁块的集合，并且它们归属于相互独立的对象，这样的情况就是分离锁(lock striping)。（摘自《Java并发编程实践》）

**67. TreeMap底层，红黑树原理？**

TreeMap继承AbstractMap，实现NavigableMap、Cloneable、Serializable三个接口。其中AbstractMap表明TreeMap为一个Map即支持key-value的集合， NavigableMap（更多）则意味着它支持一系列的导航方法，具备针对给定搜索目标返回最接近匹配项的导航方法 。

```java
public class TreeMap<K,V>
    extends AbstractMap<K,V>
    implements NavigableMap<K,V>, Cloneable, java.io.Serializable
```

红黑树又称红-黑二叉树，它首先是一颗二叉树，它具体二叉树所有的特性。同时红黑树更是一颗自平衡的排序二叉树。

我们知道一颗基本的二叉树他们都需要满足一个基本性质--即树中的任何节点的值大于它的左子节点，且小于它的右子节点。按照这个基本性质使得树的检索效率大大提高。我们知道在生成二叉树的过程是非常容易失衡的，最坏的情况就是一边倒（只有右/左子树），这样势必会导致二叉树的检索效率大大降低（O(n)），所以为了维持二叉树的平衡，大牛们提出了各种实现的算法，如：AVL，SBT，伸展树，TREAP ，红黑树等等。

红黑树顾名思义就是节点是红色或者黑色的平衡二叉树，它通过颜色的约束来维持着二叉树的平衡。对于一棵有效的红黑树二叉树而言我们必须增加如下规则：

* 每个节点都只能是红色或者黑色

* 根节点是黑色

* 每个叶节点（NIL节点，空节点）是黑色的。

* 如果一个结点是红的，则它两个子节点都是黑的。也就是说在一条路径上不能出现相邻的两个红色结点。

* 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。

**68. concurrenthashmap有啥优势**

采取了分离锁，即在HashMap的每个桶上分离加锁，提高了并发的性能

**69. ArrayList是否会越界？**

ArrayList是线程不安全的，如使用多个线程向ArrayList中添加数据。越界异常基本都发生在数组扩容之时

**70. 什么是TreeMap?**

TreeMap继承AbstractMap，实现NavigableMap、Cloneable、Serializable三个接口。其中AbstractMap表明TreeMap为一个Map即支持key-value的集合， NavigableMap（更多）则意味着它支持一系列的导航方法，具备针对给定搜索目标返回最接近匹配项的导航方法 。

```java
public class TreeMap<K,V>
    extends AbstractMap<K,V>
    implements NavigableMap<K,V>, Cloneable, java.io.Serializable
```

**71. ConcurrentHashMap的原理是什么？**

ConcurrentHashMap是Java5中新增加的一个线程安全的Map集合。对于ConcurrentHashMap是如何提高其效率的，可能大多人只是知道它使用了多个锁代替HashTable中的单个锁，也就是锁分离技术（Lock Stripping）。实际上，ConcurrentHashMap对提高并发方面的优化，还有一些其它的技巧在里面（比如在get操作的时候它是否也使用了锁来保护？）。

它把区间按照并发级别(concurrentLevel)，分成了若干个segment。默认情况下内部按并发级别为16来创建。对于每个segment的容量，默认情况也是16。当然并发级别(concurrentLevel)和每个段(segment)的初始容量都是可以通过构造函数设定的。

```java
static final class Segment<K,V> extends ReentrantLock implements Serializable 
```

Segment继承了ReentrantLock，表明每个segment都可以当做一个锁。这样对每个segment中的数据需要同步操作的话都是使用每个segment容器对象自身的锁来实现。只有对全局需要改变时锁定的是所有的segment。

**72. Java集合类框架的基本接口有哪些？**

总共有两大接口：Collection 和Map ，一个元素集合，一个是键值对集合； 其中List和Set接口继承了Collection接口，一个是有序元素集合，一个是无序元素集合； 而ArrayList和 LinkedList 实现了List接口，HashSet实现了Set接口，这几个都比较常用； HashMap 和HashTable实现了Map接口，并且HashTable是线程安全的，但是HashMap性能更好；

**73. 为什么集合类没有实现Cloneable和Serializable接口？**

Java集合类里最基本的接口有：

**Collection**：单列集合的根接口

**List**：元素有序  可重复 

**ArrayList**：类似一个长度可变的数组 。适合查询，不适合增删

**LinkedList**：底层是双向循环链表。适合增删，不适合查询。

**Set**：元素无序，不可重复

**HashSet**：根据对象的哈希值确定元素在集合中的位置

**TreeSet**: 以二叉树的方式存储元素，实现了对集合中的元素排序

**Map**：双列集合的根接口，用于存储具有键（key）、值（value）映射关系的元素。

**HashMap**：用于存储键值映射关系，不能出现重复的键key

**TreeMap**：用来存储键值映射关系，不能出现重复的键key，所有的键按照二叉树的方式排列

仅仅是接口不实现，留给具体实现类实现。

**74. 什么是迭代器？**

在Java中Iterator为一个接口，它只提供了迭代的基本规则。在JDK中它是这样定义的：对Collection进行迭代的迭代器。迭代器取代了Java Collection Framework中的Enumeration。迭代器与枚举有两点不同:

迭代器在迭代期间可以从集合中移除元素。

方法名得到了改进，Enumeration的方法名称都比较长。

Java中还提供了一个Iterable接口，Iterable接口实现后的功能是‘返回’一个迭代器，我们常用的实现了该接口的子接口有:Collection<E>、List<E>、Set<E>等。该接口的iterator()方法返回一个标准的Iterator实现。实现Iterable接口允许对象成为Foreach语句的目标。就可以通过foreach语句来遍历你的底层序列。

**75. Iterator和ListIterator的区别是什么？**

* Iterator可用来遍历Set和List集合，但是ListIterator只能用来遍历List
* Iterator对集合只能是前向遍历，ListIterator既可以前向也可以后向
* ListIterator实现了Iterator接口，并包含其他的功能，比如：增加元素，替换元素，获取前一个和后一个元素的索引，等等

**76. Iterator快速失败(fail-fast)和安全失败(fail-safe)的区别是什么？**

Iterator的安全失败是基于对底层集合做拷贝，因此，它不受源集合上修改的影响。java.util包下面的所有的集合类都是快速失败的，而java.util.concurrent包下面的所有的类都是安全失败的。快速失败的迭代器会抛出ConcurrentModificationException异常，而安全失败的迭代器永远不会抛出这样的异常。

fail-fast机制，是一种错误检测机制。它只能被用来检测错误，因为JDK并不保证fail-fast机制一定会发生。若在多线程环境下使用fail-fast机制的集合，建议使用“java.util.concurrent包下的类”去取代“java.util包下的类”。

**77. ArrayList和CopyOnWriteArrayList的区别**

* 和ArrayList继承于AbstractList不同，CopyOnWriteArrayList没有继承于AbstractList，它仅仅只是实现了List接口
* ArrayList的iterator()函数返回的Iterator是在AbstractList中实现的；而CopyOnWriteArrayList是自己实现Iterator
* ArrayList的Iterator实现类中调用next()时，会“调用checkForComodification()比较‘expectedModCount’和‘modCount’的大小”；但是，CopyOnWriteArrayList的Iterator实现类中，没有所谓的checkForComodification()，更不会抛出ConcurrentModificationException异常！

**78. ArrayList,Vector,LinkedList的存储性能和特性是什么？**

ArrayList 和Vector他们底层的实现都是一样的，都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢。

Vector中的方法由于添加了synchronized修饰，因此Vector是线程安全的容器，但性能上较ArrayList差，因此已经是Java中的遗留容器。

LinkedList使用双向链表实现存储（将内存中零散的内存单元通过附加的引用关联起来，形成一个可以按序号索引的线性结构，这种链式存储方式与数组的连续存储方式相比，内存的利用率更高），按序号索引数据需要进行前向或后向遍历，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快。            

Vector属于遗留容器（Java早期的版本中提供的容器，除此之外，Hashtable、Dictionary、BitSet、Stack、Properties都是遗留容器），已经不推荐使用，但是由于ArrayList和LinkedListed都是非线程安全的，如果遇到多个线程操作同一个容器的场景，则可以通过工具类Collections中的synchronizedList方法将其转换成线程安全的容器后再使用（这是对装潢模式的应用，将已有对象传入另一个类的构造器中创建新的对象来增强实现）。

**79. Collection 和 Collections的区别。**

java.util.Collection 是一个集合接口（集合类的一个顶级接口）。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java 类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式，其直接继承接口有List与Set。

Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。

**80. 你所知道的集合类都有哪些？主要方法？**

* 排序(Sort)：使用sort方法可以根据元素的自然顺序 对指定列表按升序进行排序。列表中的所有元素都必须实现 Comparable 接口。此列表内的所有元素都必须是使用指定比较器可相互比较的
* 混排(Shuffling)：混排算法所做的正好与 sort 相反: 它打乱在一个 List 中可能有的任何排列的踪迹。也就是说，基于随机源的输入重排该 List, 这样的排列具有相同的可能性（假设随机源是公正的）。这个算法在实现一个碰运气的游戏中是非常有用的。例如，它可被用来混排代表一副牌的 Card 对象的一个 List 。另外，在生成测试案例时，它也是十分有用的。
* 反转(Reverse)：使用Reverse方法可以根据元素的自然顺序 对指定列表按降序进行排序。
* 替换所以的元素(Fill)：使用指定元素替换指定列表中的所有元素。
* 拷贝(Copy)：用两个参数，一个目标 List 和一个源 List, 将源的元素拷贝到目标，并覆盖它的内容。目标 List 至少与源一样长。如果它更长，则在目标 List 中的剩余元素不受影响。Collections.copy(list,li): 前面一个参数是目标列表 ,后一个是源列表。
* 返回Collections中最小元素(min)：根据指定比较器产生的顺序，返回给定 collection 的最小元素。collection 中的所有元素都必须是通过指定比较器可相互比较的。
Collections.min(list)
* 返回Collections中最小元素(max)：根据指定比较器产生的顺序，返回给定 collection 的最大元素。collection 中的所有元素都必须是通过指定比较器可相互比较的。
* lastIndexOfSubList：返回指定源列表中最后一次出现指定目标列表的起始位置
* IndexOfSubList：返回指定源列表中第一次出现指定目标列表的起始位置
int count = Collections.indexOfSubList(list,li);
* Rotate：根据指定的距离循环移动指定列表中的元素

**81. List、Set、Map是否继承自Collection接口？**

List，Set是，Map不是。

**Collection**：List, LinkedList, ArrayList, Vector, Stack, Set

**Map**：Hashtable, HashMap, WeakHashMap

**82. List、Set、Map三个接口存取元素时，各有什么特点？**

List与Set都是单列元素的集合，它们有一个功共同的父接口Collection。

Set里面不允许有重复的元素，

存元素：add方法有一个boolean的返回值，当集合中没有某个元素，此时add方法可成功加入该元素时，则返回true；当集合含有与某个元素equals相等的元素时，此时add方法无法加入该元素，返回结果为false。

取元素：没法说取第几个，只能以Iterator接口取得所有的元素，再逐一遍历各个元素。

List表示有先后顺序的集合，

存元素：多次调用add(Object)方法时，每次加入的对象按先来后到的顺序排序，也可以插队，即调用add(int index,Object)方法，就可以指定当前对象在集合中的存放位置。

取元素：方法1：Iterator接口取得所有，逐一遍历各个元素. 方法2：调用get(index i)来明确说明取第几个。

Map是双列的集合，存放用put方法:put(obj key,obj value)，每次存储时，要存储一对key/value，不能存储重复的key，这个重复的规则也是按equals比较相等。

取元素：用get(Object key)方法根据key获得相应的value。也可以获得所有的key的集合，还可以获得所有的value的集合，还可以获得key和value组合成的Map.Entry对象的集合。

**83. 多线程中的i++线程安全吗？为什么？**

不安全。请参考以下几种解决方案。

1、对 i++ 操作的方法加同步锁，同时只能有一个线程执行 i++ 操作；

2、使用支持原子性操作的类，如 java.util.concurrent.atomic.AtomicInteger，它使用的是 CAS 算法，效率优于第 1 种；

**84. 如何线程安全的实现一个计数器？**

AtomicInteger

```java
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 一个循环计数器，每天从1开始计数，隔天重置为1。
 * 可以创建一个该类的全局对象，然后每次使用时候调用其get方法即可，可以保证线程安全性
 */
public class CircularCounter {

    private static final AtomicReferenceFieldUpdater<CircularCounter, AtomicInteger> valueUpdater =
            AtomicReferenceFieldUpdater.newUpdater(CircularCounter.class, AtomicInteger.class, "value");
    //保证内存可见性
    private volatile String key;
    //保证内存可见性
    private volatile AtomicInteger value;
    private static final String DATE_PATTERN = "yyyy-MM-dd";


    public CircularCounter() {
        /**
         * 这里将key设置为getCurrentDateString() + "sssssssssss" 是为了测试addAndGet()方法中日期发生变化的情况
         * 正常使用应该将key初始化为getCurrentDateString()
         */
        this.key = getCurrentDateString() + "sssssssssss";
        this.value = new AtomicInteger(0);
    }


    /**
     * 获取计数器加1以后的值
     *
     * @return
     */
    public Integer addAndGet() {

        AtomicInteger oldValue = value;
        AtomicInteger newInteger = new AtomicInteger(0);

        int newVal = -1;
        String newDateStr = getCurrentDateString();
        //日期一致，计数器加1后返回
        if (isDateEquals(newDateStr)) {
            newVal = add(1);
            return newVal;
        }

        //日期不一致，保证有一个线程重置技术器
        reSet(oldValue, newInteger, newDateStr);
        this.key = newDateStr;
        //重置后加1返回
        newVal = add(1);
        return newVal;
    }

    /**
     * 获取计数器的当前值
     * @return
     */
    public Integer get() {
        return value.get();
    }

    /**
     * 判断当前日期与老的日期（也即key成员变量记录的值）是否一致
     *
     * @return
     */
    private boolean isDateEquals(String newDateStr) {
        String oldDateStr = key;
        if (!isBlank(oldDateStr) && oldDateStr.equals(newDateStr)) {
            return true;
        }

        return false;
    }


    /**
     * 如果日期发生变化，重置计数器，也即将key设置为当前日期，并将value重置为0，重置后才能接着累加，
     */
    private void reSet(AtomicInteger oldValue, AtomicInteger newValue, String newDateStr) {
        if(valueUpdater.compareAndSet(this, oldValue, newValue)) {
            System.out.println("线程" + Thread.currentThread().getName() + "发现日期发生变化");
        }
    }

    /**
     * 获取当前日期字符串
     *
     * @return
     */
    private String getCurrentDateString() {
        Date date = new Date();
        String newDateStr = new SimpleDateFormat(DATE_PATTERN).format(date);
        return newDateStr;
    }

    /**
     * 计数器的值加1。采用CAS保证线程安全性
     *
     * @param increment
     */
    private int add(int increment) {
       return value.addAndGet(increment);
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if(cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static void test() {
        CircularCounter c = new CircularCounter();
        AtomicInteger count = new AtomicInteger(0);
        List<Thread> li = new ArrayList<Thread>();
        int size = 10;
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            Thread t = new Thread(new CounterRunner(c, latch1, latch2, count), "thread-" + i);
            li.add(t);
            t.start();
        }
        System.out.println("start");
        latch1.countDown();

        try {
            latch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.get());
        System.out.println(c.get());
        if(count.get() == c.get()) {
            System.out.println("该计数器是线程安全的！！！");
        }

    }

    public static void main(String... args) {
        for(int i = 0; i < 15; i++) {
            test();
        }
    }


}


/**
 * 测试使用的Runnable对象
 */
class CounterRunner implements Runnable {
    private CircularCounter counter;
    private CountDownLatch latch1;
    private CountDownLatch latch2;
    private AtomicInteger count;

    public CounterRunner(CircularCounter counter, CountDownLatch latch1, CountDownLatch latch2, AtomicInteger count) {
        this.latch1 = latch1;
        this.latch2 = latch2;
        this.counter = counter;
        this.count = count;
    }

    @Override
    public void run() {

        try {
            latch1.await();
            System.out.println("****************");

            for (int i = 0; i < 20; i++) {
                counter.addAndGet();
                count.addAndGet(1);
            }
            latch2.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

**85. 多线程同步的方法**

* 同步方法：即有synchronized关键字修饰的方法。 由于java的每个对象都有一个内置锁，当用此关键字修饰方法时， 内置锁会保护整个方法。在调用该方法前，需要获得内置锁，否则就处于阻塞状态。注： synchronized关键字也可以修饰静态方法，此时如果调用该静态方法，将会锁住整个类。
* 同步代码块：即有synchronized关键字修饰的语句块。 被该关键字修饰的语句块会自动被加上内置锁，从而实现同步
```java
synchronized(object){ 
}
```
* wait与notify:wait():使一个线程处于等待状态，并且释放所持有的对象的lock。sleep():使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要捕捉InterruptedException异常。notify():唤醒一个处于等待状态的线程，注意的是在调用此方法的时候，并不能确切的唤醒某一个等待状态的线程，而是由JVM确定唤醒哪个线程，而且不是按优先级。Allnotity():唤醒所有处入等待状态的线程，注意并不是给所有唤醒线程一个对象的锁，而是让它们竞争。
* 使用特殊域变量(volatile)实现线程同步
* ReentrantLock类是可重入、互斥、实现了Lock接口的锁，它与使用synchronized方法和快具有相同的基本行为和语义，并且扩展了其能力。ReenreantLock类的常用方法有：lock(),unlock()
* 如果使用ThreadLocal管理变量，则每一个使用该变量的线程都获得该变量的副本，副本之间相互独立，这样每一个线程都可以随意修改自己的变量副本，而不会对其他线程产生影响。
* 使用阻塞队列实现线程同步:BlockingQueue<E>定义了阻塞队列的常用方法，尤其是三种添加元素的方法，我们要多加注意，当队列满时：
* 原子元素：原子操作就是指将读取变量值、修改变量值、保存变量值看成一个整体来操作即-这几种行为要么同时完成，要么都不完成。在java的util.concurrent.atomic包中提供了创建了原子类型变量的工具类，使用该类可以简化线程同步。其中AtomicInteger 表可以用原子方式更新int的值，可用在应用程序中(如以原子方式增加的计数器)，但不能用于替换Integer；

**86. 介绍一下生产者消费者模式？**

生产者消费者模型具体来讲，就是在一个系统中，存在生产者和消费者两种角色，他们通过内存缓冲区进行通信，生产者生产消费者需要的资料，消费者把资料做成产品。生产消费者模式如下图。生产者是一堆线程，消费者是另一堆线程，内存缓冲区可以使用List数组队列，数据类型只需要定义一个简单的类就好。关键是如何处理多线程之间的协作。这其实也是多线程通信的一个范例。在这个模型中，最关键就是内存缓冲区为空的时候消费者必须等待，而内存缓冲区满的时候，生产者必须等待。其他时候可以是个动态平衡。值得注意的是多线程对临界区资源的操作时候必须保证在读写中只能存在一个线程，所以需要设计锁的策略。

```java

import java.util.List;

/**
 * 消费者
 * 
 * @author ctk
 *
 */
public class Consumer implements Runnable {
    private List<PCData> queue;

    public Consumer(List<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted())
                    break;
                PCData data = null;
                synchronized (queue) {
                    if (queue.size() == 0) {
                        queue.wait();
                        queue.notifyAll();
                    }
                    data = queue.remove(0);
                }
                System.out.println(
                        Thread.currentThread().getId() + " 消费了:" + data.get() + " result:" + (data.get() * data.get()));
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

import java.util.List;
import java.util.Random;

/**
 * 生产者
 * 
 * @author MacBook
 *
 */
public class Producer implements Runnable {
    private List<PCData> queue;
    private int length;

    public Producer(List<PCData> queue, int length) {
        this.queue = queue;
        this.length = length;
    }

    @Override
    public void run() {
        try {
            while (true) {

                if (Thread.currentThread().isInterrupted())
                    break;
                Random r = new Random();
                long temp = r.nextInt(100);
                System.out.println(Thread.currentThread().getId() + " 生产了：" + temp);
                PCData data = new PCData();
                data.set(temp);
                synchronized (queue) {
                    if (queue.size() >= length) {
                        queue.notifyAll();
                        queue.wait();
                    } else
                        queue.add(data);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<PCData> queue = new ArrayList<PCData>();
        int length = 10;
        Producer p1 = new Producer(queue,length);
        Producer p2 = new Producer(queue,length);
        Producer p3 = new Producer(queue,length);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(c1);
        service.execute(c2);
        service.execute(c3); 
    }
}

/**
 * 基本数据类型
 * @author ctk
 *
 */
public class PCData {
    private long value;
    public void set(long value){
        this.value = value;
        
    }
    public long get(){
        return value;
    }
}
```

**87. 然后线程创建有很大开销，怎么优化？**

线程池，预先创建好一定的线程，根据任务的不同，使用现有的线程执行不同的任务

**88. 线程池运行流程，参数，策略**

首先判断核心线程池里的线程是否都在执行任务，如果不是则直接从核心线程池中创建一个线程来执行，如果都在忙则判断任务队列是否也满了，没满的话将任务放进去等待执行，满了就判断线程池的全部线程是否都在忙，如果都在忙就交给饱和策略来处理，否则就创建一个线程来帮助核心线程处理任务。

重要参数：   

* CorePoolSize:核心线程池大小
* MaximumPoolSize：最大线程数
* WorkQueue：任务缓存队列
* ThreadFactory：线程工厂，主要用来创建线程
* Handler：饱和处理策略

饱和处理策略：

* ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
* ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
* ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
* ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务

**89. Java AQS**

AQS是AbustactQueuedSynchronizer的简称，它是一个Java提高的底层同步工具类，用一个int类型的变量表示同步状态，并提供了一系列的CAS操作来管理这个同步状态。AQS的主要作用是为Java中的并发同步组件提供统一的底层支持，例如ReentrantLock，CountdowLatch就是基于AQS实现的，用法是通过继承AQS实现其模版方法，然后将子类作为同步组件的内部类。

*同步队列*

同步队列是AQS很重要的组成部分，它是一个双端队列，遵循FIFO原则，主要作用是用来存放在锁上阻塞的线程，当一个线程尝试获取锁时，如果已经被占用，那么当前线程就会被构造成一个Node节点假如到同步队列的尾部，队列的头节点是成功获取锁的节点，当头节点线程是否锁时，会唤醒后面的节点并释放当前头节点的引用。

*独占锁的获取和释放流程*

获取
* 调用入口方法acquire(arg)
* 调用模版方法tryAcquire(arg)尝试获取锁，若成功则返回，若失败则走下一步
* 将当前线程构造成一个Node节点，并利用CAS将其加入到同步队列到尾部，然后该节点对应到线程进入自旋状态
* 自旋时，首先判断其前驱节点释放为头节点&是否成功获取同步状态，两个条件都成立，则将当前线程的节点设置为头节点，如果不是，则利用LockSupport.park(this)将当前线程挂起 ,等待被前驱节点唤醒

释放
* 调用入口方法release(arg)
* 调用模版方法tryRelease(arg)释放同步状态
* 获取当前节点的下一个节点
* 利用`LockSupport.unpark(currentNode.next.thread)`唤醒后继节点（接获取的第四步） 

*共享锁的获取和释放流程*

获取
* 调用acquireShared(arg)入口方法
* 进入tryAcquireShared(arg)模版方法获取同步状态，如果返返回值>=0，则说明同步状态(state)有剩余，获取锁成功直接返回
* 如果tryAcquireShared(arg)返回值<0，说明获取同步状态失败，向队列尾部添加一个共享类型的Node节点，随即该节点进入自旋状态
* 自旋时，首先检查前驱节点释放为头节点&tryAcquireShared()是否>=0(即成功获取同步状态)
* 如果是，则说明当前节点可执行，同时把当前节点设置为头节点，并且唤醒所有后继节点
* 如果否，则利用`LockSupport.unpark(this)`挂起当前线程，等待被前驱节点唤醒

释放
* 调用releaseShared(arg)模版方法释放同步状态
* 如果释放成，则遍历整个队列，利用`LockSupport.unpark(nextNode.thread)`唤醒所有后继节点 

*独占锁和共享锁在实现上的区别*

* 独占锁的同步状态值为1，即同一时刻只能有一个线程成功获取同步状态
* 共享锁的同步状态>1，取值由上层同步组件确定
* 独占锁队列中头节点运行完成后释放它的直接后继节点
* 共享锁队列中头节点运行完成后释放它后面的所有节点
* 共享锁中会出现多个线程（即同步队列中的节点）同时成功获取同步状态的情况

*重入锁*

重入锁指的是当前线成功获取锁后，如果再次访问该临界区，则不会对自己产生互斥行为。Java中对`ReentrantLock`和`synchronized`都是可重入锁，`synchronized`由jvm实现可重入即使，`ReentrantLock`都可重入性基于AQS实现。

同时，`ReentrantLock`还提供`公平锁`和`非公平锁`两种模式。

非公平锁的实现逻辑
```java
final boolean nonfairTryAcquire(int acquires) {
    //获取当前线程
    final Thread current = Thread.currentThread();
    //通过AQS获取同步状态
    int c = getState();
    //同步状态为0，说明临界区处于无锁状态，
    if (c == 0) {
        //修改同步状态，即加锁
        if (compareAndSetState(0, acquires)) {
            //将当前线程设置为锁的owner
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    //如果临界区处于锁定状态，且上次获取锁的线程为当前线程
    else if (current == getExclusiveOwnerThread()) {
        //则递增同步状态
        int nextc = c + acquires;
        if (nextc < 0) // overflow
            throw new Error("Maximum lock count exceeded");
            setState(nextc);
            return true;
    }
    return false;
}
```
公平锁的实现逻辑
```java
protected final boolean tryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    if (c == 0) {
        //此处为公平锁的核心，即判断同步队列中当前节点是否有前驱节点
        if (!hasQueuedPredecessors() &&
            compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    else if (current == getExclusiveOwnerThread()) {
        int nextc = c + acquires;
        if (nextc < 0)
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}
```

**90. 创建线程的方法，哪个更好，为什么？**

需要从Java.lang.Thread类派生一个新的线程类，重载它的run()方法； 实现Runnalbe接口，重载Runnalbe接口中的run()方法。 实现Runnalbe接口更好，使用实现Runnable接口的方式创建的线程可以处理同一资源，从而实现资源的共享.

线程池：可重复利用线程，节约资源，4种基本线程池，或者自定义线程池
```java
public ThreadPoolExecutor(int corePoolSize,//线程池中保留数量
   int maximumPoolSize,//线程池中最大数量
     long keepAliveTime,//空闲线程保留时间
     TimeUnit unit,//保留时间单位
    BlockingQueue<Runnable> workQueue,//保存任务队列
   ThreadFactory threadFactory,//创建线程的工厂
   RejectedExecutionHandler handler) {//当前线程池中线程数量>maximumPoolSize，再次添加线程时执行的策略，默认为拒绝
```

**91. Java中有几种方式启动一个线程？**

* 继承Thread类
* 实现Runnable接口

**92. Java中有几种线程池？**

* **newCachedThreadPool**-创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolExecutorTest {
 public static void main(String[] args) {
  ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
  for (int i = 0; i < 10; i++) {
   final int index = i;
   try {
    Thread.sleep(index * 1000);
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
   cachedThreadPool.execute(new Runnable() {
    public void run() {
     System.out.println(index);
    }
   });
  }
 }
}
```

* **newFixedThreadPool**-创建一个指定工作线程数量的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中。

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolExecutorTest {
 public static void main(String[] args) {
  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
  for (int i = 0; i < 10; i++) {
   final int index = i;
   fixedThreadPool.execute(new Runnable() {
    public void run() {
     try {
      System.out.println(index);
      Thread.sleep(2000);
     } catch (InterruptedException e) {
      e.printStackTrace();
     }
    }
   });
  }
 }
}
```

* **newSingleThreadExecutor**-创建一个单线程化的Executor，即只创建唯一的工作者线程来执行任务，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。如果这个线程异常结束，会有另一个取代它，保证顺序执行。单工作线程最大的特点是可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolExecutorTest {
 public static void main(String[] args) {
  ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
  for (int i = 0; i < 10; i++) {
   final int index = i;
   singleThreadExecutor.execute(new Runnable() {
    public void run() {
     try {
      System.out.println(index);
      Thread.sleep(2000);
     } catch (InterruptedException e) {
      e.printStackTrace();
     }
    }
   });
  }
 }
}
```

* **newScheduleThreadPool**-创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class ThreadPoolExecutorTest {
 public static void main(String[] args) {
  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
  scheduledThreadPool.schedule(new Runnable() {
   public void run() {
    System.out.println("delay 3 seconds");
   }
  }, 3, TimeUnit.SECONDS);
 }
}
```

**93. 线程池有什么好处？**

除了创建和销毁线程的开销之外，活动的线程也消耗系统资源。在一个 JVM 里创建太多的线程可能会导致系统由于过度消耗内存而用完内存或“切换过度”。为了防止资源不足，服务器应用程序需要一些办法来限制任何给定时刻处理的请求数目。

线程池为线程生命周期开销问题和资源不足问题提供了解决方案。通过对多个任务重用线程，线程创建的开销被分摊到了多个任务上。其好处是，因为在请求到达时线程已经存在，所以无意中也消除了线程创建所带来的延迟。这样，就可以立即为请求服务，使应用程序响应更快。而且，通过适当地调整线程池中的线程数目，也就是当请求的数目超过某个阈值时，就强制其它任何新到的请求一直等待，直到获得一个线程来处理为止，从而可以防止资源不足。

**94. CyclicBarrier和CountDownLatch的区别**

CountDownLatch和CyclicBarrier都是java.util.concurrent包下面的多线程工具类。

从字面上理解，CountDown表示减法计数，Latch表示门闩的意思，计数为0的时候就可以打开门闩了。Cyclic Barrier表示循环的障碍物。两个类都含有这一个意思：对应的线程都完成工作之后再进行下一步动作，也就是大家都准备好之后再进行下一步。然而两者最大的区别是，进行下一步动作的动作实施者是不一样的。这里的“动作实施者”有两种，一种是主线程（即执行main函数），另一种是执行任务的其他线程，后面叫这种线程为“其他线程”，区分于主线程。对于CountDownLatch，当计数为0的时候，下一步的动作实施者是main函数；对于CyclicBarrier，下一步动作实施者是“其他线程”。

总结：CountDownLatch和CyclicBarrier都有让多个线程等待同步然后再开始下一步动作的意思，但是CountDownLatch的下一步的动作实施者是主线程，具有不可重复性；而CyclicBarrier的下一步动作实施者还是“其他线程”本身，具有往复多次实施动作的特点。

**95. 如何理解Java多线程回调方法？**

所谓回调，就是客户程序C调用服务程序S中的某个方法A，然后S又在某个时候反过来调用C中的某个方法B，对于C来说，这个B便叫做回调方法。

或者回调的思想为如下：
* 类A的a()方法调用类B的b()方法
* 类B的b()方法执行完毕主动调用类A的callback()方法

可以采用如下方法实现回调：
* 传入回调对象的引用地址

**96. 创建线程有几种不同的方式？你喜欢哪一种？为什么？**

* 需要从`java.lang.Thread`类派生一个新的线程类，重载它的run()方法； 
* 实现`Runnalbe`接口，重载`Runnalbe`接口中的`run()`方法。 实现Runnalbe接口更好，使用实现Runnable接口的方式创建的线程可以处理同一资源，从而实现资源的共享.
* 通过`Callable`和`Future`创建线程.
* 线程池：可重复利用线程，节约资源，4种基本线程池，或者自定义线程池
```java
public ThreadPoolExecutor(int corePoolSize,//线程池中保留数量
   int maximumPoolSize,//线程池中最大数量
     long keepAliveTime,//空闲线程保留时间
     TimeUnit unit,//保留时间单位
    BlockingQueue<Runnable> workQueue,//保存任务队列
   ThreadFactory threadFactory,//创建线程的工厂
   RejectedExecutionHandler handler) {//当前线程池中线程数量>maximumPoolSize，再次添加线程时执行的策略，默认为拒绝
```

**97. 概括的解释下线程的几种可用状态。**

线程是一个动态执行的过程，它也有一个从产生到死亡的过程。

* **新建状态**:使用 `new` 关键字和 `Thread` 类或其子类建立一个线程对象后，该线程对象就处于新建状态。它保持这个状态直到程序 `start()` 这个线程。

* **就绪状态**:当线程对象调用了start()方法之后，该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度。

* **运行状态**:如果就绪状态的线程获取 CPU 资源，就可以执行 `run()`，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。

* **阻塞状态**:如果一个线程执行了`sleep`（睡眠）、`suspend`（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。在睡眠时间已到或获得设备资源后可以重新进入就绪状态。可以分为三种：

1. *等待阻塞*：运行状态中的线程执行 `wait()` 方法，使线程进入到等待阻塞状态
2. *同步阻塞*：线程在获取 `synchronized` 同步锁失败(因为同步锁被其他线程占用)。
3. *其他阻塞*：通过调用线程的 `sleep()` 或 `join()` 发出了 I/O 请求时，线程就会进入到阻塞状态。当`sleep()` 状态超时，`join()` 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。

* **死亡状态**:一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。

**98. 同步方法和同步代码块的区别是什么？**

同步方法使用synchronized修饰方法，在调用该方法前，需要获得内置锁（java每个对象都有一个内置锁），否则就处于阻塞状态

.同步代码块使用synchronized(object){}进行修饰，在调用该代码块时，需要获得内置锁，否则就处于阻塞状态

*注：同步是一种高开销的操作，因此应该尽量减少同步的内容。 通常没有必要同步整个方法，使用synchronized代码块同步关键代码即可。*

**99. 启动线程有哪几种方式，线程池有哪几种？**

* 需要从`java.lang.Thread`类派生一个新的线程类，重载它的run()方法； 
* 实现`Runnalbe`接口，重载`Runnalbe`接口中的`run()`方法。 实现Runnalbe接口更好，使用实现Runnable接口的方式创建的线程可以处理同一资源，从而实现资源的共享.
* 通过`Callable`和`Future`创建线程.

* **newCachedThreadPool**-创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
* **newFixedThreadPool**-创建一个指定工作线程数量的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中。
* **newSingleThreadExecutor**-创建一个单线程化的Executor，即只创建唯一的工作者线程来执行任务，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。如果这个线程异常结束，会有另一个取代它，保证顺序执行。单工作线程最大的特点是可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。
* **newScheduleThreadPool**-创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。

**100. 在监视器(Monitor)内部，是如何做线程同步的？程序应该做哪种级别的同步？**

监视器和锁在Java虚拟机中是一块使用的。监视器监视一块同步代码块，确保一次只有一个线程执行同步代码块。每一个监视器都和一个对象引用相关联。线程在获取锁之前不允许执行同步代码。

在 java 虚拟机中, 每个对象( Object 和 class )通过某种逻辑关联监视器,每个监视器和一个对象引用相关联, 为了实现监视器的互斥功能, 每个对象都关联着一把锁.

一旦方法或者代码块被 synchronized 修饰, 那么这个部分就放入了监视器的监视区域, 确保一次只能有一个线程执行该部分的代码, 线程在获取锁之前不允许执行该部分的代码

另外 java 还提供了显式监视器( Lock )和隐式监视器( synchronized )两种锁方案

**101. sleep() 和 wait() 有什么区别？**

对于sleep()方法，我们首先要知道该方法是属于Thread类中的。而wait()方法，则是属于Object类中的。

sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态

在调用sleep()方法的过程中，线程不会释放对象锁。

而当调用wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用notify()方法后本线程才进入对象锁定池准备

**102. 同步和异步有何异同，在什么情况下分别使用他们？举例说明。**

如果数据将在线程间共享。例如正在写的数据以后可能被另一个线程读到，或者正在读的数据可能已经被另一个线程写过了，那么这些数据就是共享数据，必须进行同步存取。

当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方法的返回时，就应该使用异步编程，在很多情况下采用异步途径往往更有效率。

**103. 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。使用内部类实现线程，对j增减的时候没有考虑顺序问题。**

非线程安全的实现方式，建立四个线程即可，线程安全的方式可以使用`AtomicInteger`

```java
public class ManyThreads {

    private int j;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ManyThreads many = new ManyThreads();
        Inc inc = many.new Inc();
        Dec dec = many.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }

    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "inc" + j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "dec" + j);
    }

    class Inc implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 0; i < 20; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 0; i < 20; i++) {
                dec();
            }
        }
    }
}
```

**104. 启动一个线程是用run()还是start()?**

使用`start()`方法，`run()`方法是`Thread`类的一个方法，当线程start()方法被调用后，异步执行`Thread`类的`run()`方法

**105. 请说出你所知道的线程同步的方法**

* **同步方法**-即有`synchronized`关键字修饰的方法。由于java的每个对象都有一个内置锁，当用此关键字修饰方法时， 内置锁会保护整个方法。在调用该方法前，需要获得内置锁，否则就处于阻塞状态。
* **同步代码块**-即有synchronized关键字修饰的语句块。被该关键字修饰的语句块会自动被加上内置锁，从而实现同步
* **使用特殊域变量(volatile)实现线程同步**-
* **使用重入锁实现线程同步**-
* ****-java.util.concurrent包来支持同步。ReentrantLock类是可重入、互斥、实现了Lock接口的锁， 
* **使用局部变量实现线程同步**-如果使用ThreadLocal管理变量，则每一个使用该变量的线程都获得该变量的副本，副本之间相互独立，这样每一个线程都可以随意修改自己的变量副本，而不会对其他线程产生影响。
* **使用阻塞队列实现线程同步**-使用`LinkedBlockingQueue<E>`来实现线程的同步。LinkedBlockingQueue<E>是一个基于已连接节点的，范围任意的blocking queue。队列是先进先出的顺序（FIFO），
* **使用原子变量实现线程同步**-在java的util.concurrent.atomic包中提供了创建了原子类型变量的工具类，其中AtomicInteger 表可以用原子方式更新int的值，可用在应用程序中(如以原子方式增加的计数器)，但不能用于替换Integer；可扩展Number，允许那些处理机遇数字类的工具和实用工具进行统一访问。

**106. 多线程有几种实现方法,都是什么?同步有几种实现方法,都是什么?**

*多线程的实现方法*

* **继承Thread类创建线程**
* **实现Runnable接口创建线程**
* **实现Callable接口通过FutureTask包装器来创建Thread线程**
* **使用ExecutorService、Callable、Future实现有返回结果的线程**
* **线程池ThreadPoolExecutor**

*线程同步的方法*

* **同步方法**-即有`synchronized`关键字修饰的方法。由于java的每个对象都有一个内置锁，当用此关键字修饰方法时， 内置锁会保护整个方法。在调用该方法前，需要获得内置锁，否则就处于阻塞状态。
* **同步代码块**-即有synchronized关键字修饰的语句块。被该关键字修饰的语句块会自动被加上内置锁，从而实现同步
* **使用特殊域变量(volatile)实现线程同步**-
* **使用重入锁实现线程同步**-
* ****-java.util.concurrent包来支持同步。ReentrantLock类是可重入、互斥、实现了Lock接口的锁， 
* **使用局部变量实现线程同步**-如果使用ThreadLocal管理变量，则每一个使用该变量的线程都获得该变量的副本，副本之间相互独立，这样每一个线程都可以随意修改自己的变量副本，而不会对其他线程产生影响。
* **使用阻塞队列实现线程同步**-使用`LinkedBlockingQueue<E>`来实现线程的同步。LinkedBlockingQueue<E>是一个基于已连接节点的，范围任意的blocking queue。队列是先进先出的顺序（FIFO），
* **使用原子变量实现线程同步**-在java的util.concurrent.atomic包中提供了创建了原子类型变量的工具类，其中AtomicInteger 表可以用原子方式更新int的值，可用在应用程序中(如以原子方式增加的计数器)，但不能用于替换Integer；可扩展Number，允许那些处理机遇数字类的工具和实用工具进行统一访问。

**107. java线程stop()和suspend()方法为何不推荐使用？**

对使用stop()，是因为它不安全。它会解除由线程获取的所有锁定，当在一个线程对象上调用stop()方法时，这个线程对象所运行的线程就会立即停止，

suspend()方法容易发生死锁。调用suspend()的时候，目标线程会停下来，但却仍然持有在这之前获得的锁定。此时，其他任何线程都不能访问锁定的资源，除非被”挂起”的线程恢复运行。

**108. 线程的sleep()方法和yield()方法有什么区别？**

* sleep()方法给其他线程运行机会时不考虑线程的优先级，因此会给低优先级的线程以运行的机会；yield()方法只会给相同优先级或更高优先级的线程以运行的机会；
* 线程执行sleep()方法后转入阻塞（blocked）状态，而执行yield()方法后转入就绪（ready）状态；
* sleep()方法声明抛出InterruptedException，而yield()方法没有声明任何异常；
* sleep()方法比yield()方法（跟操作系统CPU调度相关）具有更好的可移植性。

**109. 当一个线程进入一个对象的synchronized方法A之后，其它线程是否可进入此对象的synchronized方法B？**

是不能的,其他线程只能访问该对象的非同步方法,同步方法则不能进入;因为非静态方法上的synchronized修饰符要求执行方法时要获得对象的锁,如果已经进入A方法,说明对象锁已经被取

**110. 请说出与线程同步以及线程调度相关的方法。**

* **wait()**-使一个线程处于等待（阻塞）状态，并且释放所持有的对象的锁；
* **sleep()**-使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要处理InterruptedException异常；
* **notify()**-唤醒一个处于等待状态的线程，当然在调用此方法的时候，并不能确切的唤醒某一个等待状态的线程，而是由JVM确定唤醒哪个线程，而且与优先级无关；
* **notityAll()**-唤醒所有处于等待状态的线程，该方法并不是将对象的锁给所有线程，而是让它们竞争，只有获得锁的线程才能进入就绪状态；

**111. 举例说明同步和异步**

如果数据将在线程间共享。例如正在写的数据以后可能被另一个线程读到，或者正在读的数据可能已经被另一个线程写过了，那么这些数据就是共享数据，必须进行同步存取。

当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方法的返回时，就应该使用异步编程，在很多情况下采用异步途径往往更有效率。

**112. 什么是线程池（thread pool）**

一个线程池包括以下四个基本组成

* **线程池管理器（ThreadPool）**-用于创建并管理线程池，包括 创建线程池，销毁线程池，添加新任务；
* **工作线程（PoolWorker）**-线程池中线程，在没有任务时处于等待状态，可以循环的执行任务；
* **任务接口（Task）**-每个任务必须实现的接口，以供工作线程调度任务的执行，它主要规定了任务的入口，任务执行完后的收尾工作，任务的执行状态等；
* **任务队列（taskQueue）**-用于存放没有处理的任务。提供一种缓冲机制。

假设一个服务器完成一项任务所需时间为：T1 创建线程时间，T2 在线程中执行任务的时间，T3 销毁线程时间。如果：T1 + T3 远大于 T2，则可以采用线程池，以提高服务器性能。

**113. 说说线程的基本状态以及状态之间的关系？**

线程的基本概念：线程指在程序执行过程中，能够执行程序代码的一个执行单位，每个程序至少都有一个线程，也就是程序本身

Java中的线程有五种状态分别是：运行、就绪、阻塞、wait和sleep挂起、结束。就绪，运行，synchronize阻塞，wait和sleep挂起，结束。wait必须在synchronized内部调用。调用线程的start方法后线程进入就绪状态，线程调度系统将就绪状态的编程转为运行状态，遇到synchronized语句时，由运行状态转为阻塞，当synchronized获得锁后，由阻塞转为运行，在这种情况下可以调用wait方法转为挂起状态，当线程关联的代码执行完后，线程变为结束状态。

**114. 如何保证线程安全？**

*线程安全的三个方面*

* **原子性**-提供互斥访问，同一时刻只能有一个线程对数据进行操作，（atomic,synchronized）；JDK里面提供了很多atomic类，AtomicInteger,AtomicLong,AtomicBoolean等，synchronized是一种同步锁，通过锁实现原子操作。
* **可见性**-一个线程对主内存的修改可以及时地被其他线程看到，（synchronized,volatile）；可见性，JVM提供了synchronized和volatile。这里我们看volatile。
* **有序性**-一个线程观察其他线程中的指令执行顺序，由于指令重排序，该观察结果一般杂乱无序，（happens-before原则）。在JMM中，允许编译器和处理器对指令进行重排序，但是重排序过程不会影响到单线程程序的执行，却会影响到多线程并发执行的正确性。可以通过volatile、synchronized、lock保证有序性。

**115. 讲一下非公平锁和公平锁在reetrantlock里的实现。**

* 非公平锁: 当线程争夺锁的过程中，会先进行一次CAS尝试获取锁，若失败，则进入acquire(1)函数，进行一次tryAcquire再次尝试获取锁，若再次失败，那么就通过addWaiter将当前线程封装成node结点加入到Sync队列，这时候该线程只能乖乖等前面的线程执行完再轮到自己了。
* 公平锁: 当线程在获取锁的时候，会先判断Sync队列中是否有在等待获取资源的线程。若没有，则尝试获取锁，若有，那么就那么就通过addWaiter将当前线程封装成node结点加入到Sync队列中。

**116. 讲一下synchronized，可重入怎么实现。**

*可重入条件*

* 不在函数内使用静态或全局数据。
* 不返回静态或全局数据，所有数据都由函数的调用者提供。
* 使用本地数据（工作内存），或者通过制作全局数据的本地拷贝来保护全局数据。
* 不调用不可重入函数。

synchronized是可重入锁,每个锁关联一个线程持有者和一个计数器。当计数器为0时表示该锁没有被任何线程持有，那么任何线程都都可能获得该锁而调用相应方法。当一个线程请求成功后，JVM会记下持有锁的线程，并将计数器计为1。此时其他线程请求该锁，则必须等待。而该持有锁的线程如果再次请求这个锁，就可以再次拿到这个锁，同时计数器会递增。当线程退出一个synchronized方法/块时，计数器会递减，如果计数器为0则释放该锁

**117. 锁和同步的区别。**

线程同步：java允许多线程并发控制，当多个线程同时操作一个可共享的资源变量时（如数据的增删改查）， 将会导致数据不准确，相互之间产生冲突，因此加入同步锁以避免在该线程没有完成操作之前，被其他线程的调用，从而保证了该变量的唯一性和准确性。

锁是实现线程同步的一种方式

**118. 什么是死锁(deadlock)？**

多线程以及多进程改善了系统资源的利用率并提高了系统 的处理能力。然而，并发执行也带来了新的问题——死锁。所谓死锁是指多个线程因竞争资源而造成的一种僵局（互相等待），若无外力作用，这些进程都将无法向前推进。所谓死锁是指两个或两个以上的线程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们都将无法推进下去。

死锁产生的原因

* **系统资源的竞争**-通常系统中拥有的不可剥夺资源，其数量不足以满足多个进程运行的需要，使得进程在运行过程中，会因争夺资源而陷入僵局，如磁带机、打印机等。只有对不可剥夺资源的竞争才可能产生死锁，对可剥夺资源的竞争是不会引起死锁的。
* **进程推进顺序非法**-进程在运行过程中，请求和释放资源的顺序不当，也同样会导致死锁。例如，并发进程 P1、P2分别保持了资源R1、R2，而进程P1申请资源R2，进程P2申请资源R1时，两者都会因为所需资源被占用而阻塞。

**119. 如何确保N个线程可以访问N个资源同时又不导致死锁？**

使用多线程时，一种非常简单的避免死锁的方式就是：指定锁的顺序，并强制线程按照指定的顺序获取锁。因此所有的线程都是以同样的加锁和释放锁，就不会出现死锁了

**120. 请你简述synchronized和java.util.concurrent.locks.Lock的异同？**

主要相同点：Lock能完成synchronized所实现的所有功能

主要不同点：Lock有比synchronized更精确的线程语义和更好的性能。synchronized会自动释放锁，而Lock一定要求程序员手工释放，并且必须在finally从句中释放。

*区别*

* synchronized是java内置关键字，在jvm层面，Lock是个java类；
* synchronized无法判断是否获取锁的状态，Lock可以判断是否获取到锁；
* synchronized会自动释放锁(a 线程执行完同步代码会释放锁 ；b 线程执行过程中发生异常会释放锁)，Lock需在finally中手工释放锁（unlock()方法释放锁），否则容易造成线程死锁；
* 用synchronized关键字的两个线程1和线程2，如果当前线程1获得锁，线程2线程等待。如果线程1阻塞，线程2则会一直等待下去，而Lock锁就不一定会等待下去，如果尝试获取不到锁，线程可以不用一直等待就结束了；
* synchronized的锁可重入、不可中断、非公平，而Lock锁可重入、可判断、可公平（两者皆可）
* Lock锁适合大量同步的代码的同步问题，synchronized锁适合代码少量的同步问题。

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest{
    private Lock lock = new ReentrantLock();
    /*
     * 使用完毕释放后其他线程才能获取锁
     */
    public void lockTest(Thread thread) {
        lock.lock(); //获取锁
        try {
            System.out.println("线程"+thread.getName() + "获取当前锁"); //打印当前锁的名称
            Thread.sleep(2000); //为看出执行效果，是线程此处休眠2秒
        } catch (Exception e) {
            System.out.println("线程"+thread.getName() + "发生了异常释放锁");
        }finally {
            System.out.println("线程"+thread.getName() + "执行完毕释放锁");
            lock.unlock(); //释放锁
        }
    }
     
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        // 声明一个线程 “线程一”
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.lockTest(Thread.currentThread());
            }
        }, "thread1");
        // 声明一个线程 “线程二”
        Thread thread2 = new Thread(new Runnable() {
 
            @Override
            public void run() {
                lockTest.lockTest(Thread.currentThread());
            }
        }, "thread2");
        // 启动2个线程
        thread2.start();
        thread1.start();
    }
}
```

**121. Java中的LongAdder和AtomicLong的区别**

LongAdder在AtomicLong的基础上将单点的更新压力分散到各个节点，在低并发的时候通过对base的直接更新可以很好的保障和AtomicLong的性能基本保持一致，而在高并发的时候通过分散提高了性能。 
 
缺点是LongAdder在统计的时候如果有并发更新，可能导致统计的数据有误差。

**122. JDK和JRE的区别是什么？**

* **JRE**-JRE是Java Runtime Environment的缩写，顾名思义是java运行时环境，包含了java虚拟机，java基础类库。是使用java语言编写的程序运行所需要的软件环境，是提供给想运行java程序的用户使用的，还有所有的Java类库的class文件，都在lib目录下，并且都打包成了jar。
* **JDK**-Jdk是Java Development Kit的缩写，顾名思义是java开发工具包，是程序员使用java语言编写java程序所需的开发工具包，是提供给程序员使用的。JDK包含了JRE，同时还包含了编译java源码的编译器javac，还包含了很多java程序调试和分析的工具：jconsole，jvisualvm等工具软件，还包含了java程序编写所需的文档和demo例子程序。

如果你需要运行java程序，只需安装JRE就可以了。如果你需要编写java程序，需要安装JDK。

**123. 反射的实现与作用**

反射机制是在运行状态中，对于任意的一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为反射

```java
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
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
        // System.out.println(Class.forName("src.dugu"));
        try {
            int i = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Constructor<?>[] conArray = oneClass.getConstructors();
        for(Constructor<?> con : conArray){
            System.out.println(con.toString());
            System.out.println(String.format("%s, %d", con.getName(), con.getParameterCount()));        
        }
        //Object obj = oneClass.getConstructor(null).newInstance();
        for(Field field: oneClass.getFields()){
            System.out.println(field);
        }

        for(Method field: oneClass.getMethods()){
            System.out.println(field);
        }

        for(Annotation field: oneClass.getAnnotations()){
            System.out.println(field);
        }
        //oneClass.getMethod("print").invoke(oneClass.newInstance());
    }
}
```

**124. JVM回收算法和回收器，CMS采用哪种回收算法，怎么解决内存碎片问题？** 

*JVM回收器*

* **Serial收集器**-Serial收集器是最基本、发展历史最悠久的收集器。是单线程的收集器。它在进行垃圾收集时，必须暂停其他所有的工作线程，直到它收集完成。Serial收集器依然是虚拟机运行在Client模式下默认新生代收集器，对于运行在Client模式下的虚拟机来说是一个很好的选择。
* **ParNew收集器**-ParNew收集器其实就是Serial收集器的多线程版本，除了使用多线程进行垃圾收集之外，其余行为包括Serial收集器可用的所有控制参数、收集算法、Stop The Worl、对象分配规则、回收策略等都与Serial 收集器完全一样。
* **Parallel Scavenge (并行回收) 收集器**-Parallel Scavenge收集器是一个新生代收集器，它也是使用复制算法的收集器，又是并行的多线程收集器该收集器的目标是达到一个可控制的吞吐量（Throughput）。
* **Serial Old 收集器**-Serial Old是Serial收集器的老年代版本，它同样是一个单线程收集器，使用标记整理算法。这个收集器的主要意义也是在于给Client模式下的虚拟机使用。
* **Parallel Old 收集器**-Parallel Old 是Parallel Scavenge收集器的老年代版本，使用多线程和“标记-整理”算法。这个收集器在1.6中才开始提供。
* **CMS收集器**-CMS(Concurrent Mark Sweep)收集器是一种以获取最短回收停顿时间为目标的收集器。目前很大一部分的Java应用集中在互联网站或者B/S系统的服务端上，这类应用尤其重视服务器的响应速度，希望系统停顿时间最短，以给用户带来较好的体验。CMS收集器就非常符合这类应用的需求。CMS收集器是基于**标记-清除**算法实现的。它的运作过程相对前面几种收集器来说更复杂一些，整个过程分为4个步骤：（1）初始标记;（2）并发标记;（3）重新标记;（4）并发清除;
* **G1收集器**-使用G1收集器时，Java堆的内存布局是整个规划为多个大小相等的独立区域（Region）,虽然还保留有新生代和老年代的概念，但新生代和老年代不再是物理隔离的了，它们都是一部分Region的集合。这种使用区域划分内存空间以及有优先级的区域回收方式，保证了G1收集器在有限的时间内可以获取尽量可能高的回机效率。

*JVM垃圾收集算法*

* **引用计数法**-给对象添加引用计数器，当引用对象时计数器+1，引用失效时，计数器-1，当计数器等于0时，对象失效，内存可以被回收。
* **根搜索法**-通过GC roots可达的对象路径称为引用链（reference chain），当一个对象没有引用链时（即从GC roots不可达）则视为不可用对象，内存可以被回收。java使用该算法进行垃圾收集。

*JVM垃圾回收算法*

* **复制算法**-将内存分为（大小相等）两部分，每次只使用其中一块进行内存分配，当内存使用完后，就出发GC，将存活的对象直接复制到另一块空闲的内存中，然后对当前使用的内存块一次性清除所有，然后转到另一块内存进行使用。 
* **标记-清除算法**-分两步进行，第一步标记出可以回收的对象，第二步统一清理可以回收的对象内存。缺点：首先标记和清除步骤效率都不高，其次会产生内存碎片。
* **标记-整理算法**-类似于标记-清除算法，但是第二步进行内存回收时，将存活的对象向内存一端移动，达到消除内存碎片问题。
* **分代收集算法**-java sun hotspot虚拟机将内存分为新生代（堆）、老年代（堆）、永久代（方法区、常量池、即时编译代码）几个区域，新生代主要使用基于复制算法的垃圾回收，老年代和永久代主要使用标记-整理算法进行垃圾回收。

*CMS采用哪种回收算法*

CMS收集器是基于**标记-清除**算法实现的。它的运作过程相对前面几种收集器来说更复杂一些，整个过程分为4个步骤：（1）初始标记;（2）并发标记;（3）重新标记;（4）并发清除;

*怎么解决内存碎片问题*

Mark-Compact标记-整理算法可以解决内存碎片问题，但是会增加停顿时间。

**125. Java类加载过程**

* **加载(Load)**-通过Class的全限定名获取Class的二进制字节流(加载方式不限于网络、文本等)，将Class的二进制内容加载到虚拟机的方法区，在内存中生成一个java.lang.Class对象表示这个Class
* **校验(Verify)**-验证一个Class的二进制内容是否合法，主要包括文件格式验证，元数据验证，字节码验证，符号引用验证。
* **准备(Prepare)**-虚拟机在方法区中为Class分配内存，并设置static成员变量的初始值为默认值。*注意:这里仅为static变量分配内存*
* **解析(Resolve)**-虚拟机会将常量池中的符号引用替换为直接引用，解析主要针对的是类、接口、方法、成员变量等符号引用。
* **初始化(Initialize)**-初始化阶段即开始在内存中构造一个Class对象来表示该类,即执行类构造器`\<clinit\>()`的过程。
* **使用(Use)**-
* **卸载(Unload)**-

**126. JVM分区**

* **线程私有的内存区**-
1. 程序计数器：当前线程所执行的字节码行号计数指示器，是线程私有的，即每个线程都有自己的程序计数器，*注意：若JVM执行的是Native代码，那么程序计数器为空*
2. JAVA虚拟机栈：存放栈帧的地方，每个JAVA方法执行的时候会创建一个栈帧，该栈帧保持的是该方法的相关信息(局部变量表等),栈帧随着方法的执行和跳出进栈和出栈，JAVA虚拟机栈是线程私有的，即每个线程都要自己的JAVA虚拟机栈
3. 本地方法栈：类似JAVA虚拟机栈，但是JAVA虚拟机栈是为JAVA方法提供服务的，而本地方法栈是为非JAVA方法提供服务的(Native方法）
* **线程共享的内存区**-
1. 堆：存放对象实例的地方，从GC（垃圾回收）的角度讲，又分为新生代和老年代，属于线程共享的内存区域
2. 方法区：方法区：储存已经被JVM加载的类信息，比如常量，静态变量，类的名称，方法信息等等，方法区中还包含运行时常量池和常量池，区别是运行时常量池是动态的，因为JAVA语言并不要求常量一定只能在编译期间生成，运行期间也有可能产生新的常量，这些常量就被放入运行常量池，这里所说的常量包括包装类和String类

**127. JVM中的新生代Eden和survivor区**

HotSpot JVM把年轻代分为了三部分：1个Eden区和2个Survivor区（分别叫from和to）。默认比例为8：1

在GC开始的时候，对象只会存在于Eden区和名为“From”的Survivor区，Survivor区“To”是空的。紧接着进行GC，Eden区中所有存活的对象都会被复制到“To”，而在“From”区中，仍存活的对象会根据他们的年龄值来决定去向。年龄达到一定值(年龄阈值，可以通过-XX:MaxTenuringThreshold来设置)的对象会被移动到年老代中，没有达到阈值的对象会被复制到“To”区域。经过这次GC后，Eden区和From区已经被清空。这个时候，“From”和“To”会交换他们的角色，也就是新的“To”就是上次GC前的“From”，新的“From”就是上次GC前的“To”。不管怎样，都会保证名为To的Survivor区域是空的。Minor GC会一直重复这样的过程，直到“To”区被填满，“To”区被填满之后，会将所有对象移动到年老代中。

**128. JAVA虚拟机的作用?**

Java虚拟机解释运行字节码程序消除平台的相关性。JVM将Java字节码解释为具体平台的具体指令。一般的高级语言如要在不同的平台上运行，至少需要编译成不同的目标代码。而引入JVM后，Java语言在不同平台上运行时不需要重新编译。

Java语言使用模式Java虚拟机屏蔽了与具体平台相关的信息，使得Java语言编译程序只需生成在Java虚拟机上运行的目标代码(字节码)，就可以在多种平台上不加修改地运行。Java虚拟机在执行字节码时，把字节码解释成具体平台上的机器指令执行。

**129. Java的GC中如何判断对象需要被回收？**

Java的GC用到垃圾回收机制算法，判断是否是垃圾，从而进行回收。引用可达法，程序运行从开始，每次引用对象，都将对引用的对象进行连接起来，到最后形成一张网，没有在这张网上的对象则被认为是垃圾对象。还使用引用计数法，对于对象的引用，每引用一次计数器加一，引用失败，计数器减一，当计数器一段时间为0，则可以被认为是垃圾。

**130. JAVA虚拟机中，哪些可作为ROOT对象？**

* 虚拟机栈(栈帧中的本地变量表)中引用的对象
* 本地方法栈中JNI(即一般说的native方法)引用的对象
* 方法区中的静态变量和常量引用的对象

**131. JVM内存模型是什么？**

* **方法区(Method Area)**-存放类似类定义、常量、编译后的代码、静态变量等。在JDK1.7中HotSpot VM的实现就是将其放在永久代中，这样的好处是可以直接使用堆中的GC算法来进行管理，坏处就是会经常出现内存溢出，即PermGen Space异常。所以在JDK1.8中，就取消了永久代，用元空间来取而代之，元空间直接使用本地内存，理论上电脑有多少内存它就可以使用多少内存，所以不会出现内存溢出。
* **堆(Heap)**-几乎所有对象、数组等都是在此分配内存的，在JVM内存中占的比例也是很大的，也是GC回收的主要阵地，平时我们说的新生代、老年代、永久代也是指这片区域。    
* **虚拟机栈(Java Stack)**-当JVM在执行方法时，会在此区域中创建一个栈帧来存放方法的各种信息，比如返回值，局部变量表和各种对象引用等。 方法开始之心就先创建栈帧，执行完后就出栈。
* **本地方法栈(Native Method Stack)**-和虚拟机栈类似，专门提供给Native方法用的
* **程序计数器**-占用很小的一片区域，JVM执行代码一行一行执行字节码，所以需要一个计数器来记录当前执行的行数。

**132. jvm如何实现线程？**

1. Java程序通过Thread t = new Thread(),调用t.start()启动一个线程，使该线程进入可运行(Runnale)的状态
2. 由JVM的决定去调度(Scheduler)在可运行状态(Runnable)下的线程，使该线程处于运行(Running)状态,由于JVM的调度会出现不可控性，即不是优先级高的先被调用，可能先调用也可能后调用的情况，运行状态(Runnable)下，调用礼让yield()方法，可使线程回到运行状态(Runnable)下，在次JVM调度(并不依赖优先级)
3. 线程在Running的过程可能会遇到阻塞(Blocking)情况
4. 线程run()运行结束或异常退出，线程达到死亡状态(Dead)

**133. jvm最大内存限制多少**

VM内存的最大值跟操作系统有很大的关系。简单的说就32位处理器虽然 可控内存空间有4GB,但是具体的操作系统会给一个限制，这个限制一般是2GB-3GB（一般来说Windows系统下为1.5G-2G，Linux系统 下为2G-3G），而64bit以上的处理器就不会有限制了

**134. 什么是Java虚拟机？为什么Java被称作是“平台无关的编程语言”？**

Java虚拟机解释运行字节码程序消除平台的相关性。JVM将Java字节码解释为具体平台的具体指令。一般的高级语言如要在不同的平台上运行，至少需要编译成不同的目标代码。而引入JVM后，Java语言在不同平台上运行时不需要重新编译。

**135. 描述一下JVM加载class文件的原理机制?**

Java中的所有类，都需要由类加载器装载到JVM中才能运行。类加载器本身也是一个类，而它的工作就是把class文件从硬盘读取到内存中。

类装载方式有两种

* 隐式装载：程序在运行过程中当碰到通过new等方式生成对象，隐式调用类装载器加载对应的类到jvm中
* 显式装载：通过class.forname()等方法，显式加载需要的类

**136. java中内存泄露是啥，什么时候出现内存泄露？**

Java导致内存泄露的原因：长生命周期的对象持有短生命周期对象的应用就很可能发生内存泄露，尽管短生命周期对象已经不再需要，但是因为长生命周期对象持有它的引用而导致不能被回收，这就是Java中内存泄露的发生场景。

发生内存泄露的场景
1. 集合类:集合类仅仅有添加元素的方法，而没有相应的删除机制，导致内存被占用。而如果这个集合类是全局性的变量（比如类中的静态属性，全局性的map等即有静态引用或final一直指向它），那么没有相应的删除机制，很可能导致集合所占用的内存只增不减，因此提供这样的删除机制或者定期清除策略非常必要。
2. 单例模式:不正确使用单例模式是引起内存泄露的一个常见问题，单例对象在被初始化后将在JVM的整个生命周期中存在（以静态变量的方式），如果单例对象持有外部对象的引用，那么这个外部对象将不能被jvm正常回收，导致内存泄露。

**137. minor gc如果运行的很频繁，可能是什么原因引起的，minor gc如果运行的很慢，可能是什么原因引起的?**

* minor gc运行的很频繁可能是什么原因引起的？
1. 产生了太多朝生夕灭的对象导致需要频繁minor gc
2. 新生代空间设置的比较小
* minor gc运行的很慢有可能是什么原因引起的？
1. 新生代空间设置过大
2. 对象引用链较长，进行可达性分析时间较长
3. 新生代survivor区设置的比较小，清理后剩余的对象不能装进去需要移动到老年代，造成移动开销
4. 内存分配担保失败，由minor gc转化为full gc
5. 采用的垃圾收集器效率较低，比如新生代使用serial收集器

**138. 阐述GC算法**

*JVM垃圾收集算法*

* **引用计数法**-给对象添加引用计数器，当引用对象时计数器+1，引用失效时，计数器-1，当计数器等于0时，对象失效，内存可以被回收。
* **根搜索法**-通过GC roots可达的对象路径称为引用链（reference chain），当一个对象没有引用链时（即从GC roots不可达）则视为不可用对象，内存可以被回收。java使用该算法进行垃圾收集。

*JVM垃圾回收算法*

* **复制算法**-将内存分为（大小相等）两部分，每次只使用其中一块进行内存分配，当内存使用完后，就出发GC，将存活的对象直接复制到另一块空闲的内存中，然后对当前使用的内存块一次性清除所有，然后转到另一块内存进行使用。 
* **标记-清除算法**-分两步进行，第一步标记出可以回收的对象，第二步统一清理可以回收的对象内存。缺点：首先标记和清除步骤效率都不高，其次会产生内存碎片。
* **标记-整理算法**-类似于标记-清除算法，但是第二步进行内存回收时，将存活的对象向内存一端移动，达到消除内存碎片问题。
* **分代收集算法**-java sun hotspot虚拟机将内存分为新生代（堆）、老年代（堆）、永久代（方法区、常量池、即时编译代码）几个区域，新生代主要使用基于复制算法的垃圾回收，老年代和永久代主要使用标记-整理算法进行垃圾回收。

**139. Java的GC是什么? 为什么要有GC?**

GC是垃圾收集的意思（Gabage Collection）,内存处理是编程人员容易出现问题的地方，忘记或者错误的内存回收会导致程序或系统的不稳定甚至崩溃。

Java提供的GC功能可以自动监测对象是否超过作用域从而达到自动回收内存的目的，Java语言没有提供释放已分配内存的显示操作方法。

**140. 垃圾回收的优点和原理。并考虑2种回收机制**

垃圾回收机制有效的防止了内存泄露，可以有效的使用可使用的内存。使java程序员在编写程序时不再考虑内存管理的问题。由于有这个垃圾回收机制，java中的对象不再有“作用域”的概念，只有引用的对象才有“作用域”。

垃圾回收有分代复制垃圾回收、标记垃圾回收、增量垃圾回收。

**141. java中会存在内存泄漏吗，请简单描述。**

Java导致内存泄露的原因：长生命周期的对象持有短生命周期对象的应用就很可能发生内存泄露，尽管短生命周期对象已经不再需要，但是因为长生命周期对象持有它的引用而导致不能被回收，这就是Java中内存泄露的发生场景。

发生内存泄露的场景
1. 集合类:集合类仅仅有添加元素的方法，而没有相应的删除机制，导致内存被占用。而如果这个集合类是全局性的变量（比如类中的静态属性，全局性的map等即有静态引用或final一直指向它），那么没有相应的删除机制，很可能导致集合所占用的内存只增不减，因此提供这样的删除机制或者定期清除策略非常必要。
2. 单例模式:不正确使用单例模式是引起内存泄露的一个常见问题，单例对象在被初始化后将在JVM的整个生命周期中存在（以静态变量的方式），如果单例对象持有外部对象的引用，那么这个外部对象将不能被jvm正常回收，导致内存泄露。

**142. 垃圾回收器的基本原理是什么？垃圾回收器可以马上回收内存吗？有什么办法主动通知虚拟机进行垃圾回收？（垃圾回收）**

对于GC来说，当程序员创建对象时，GC就开始监控这个对象的地址、大小以及使用情况。通常，GC采用有向图的方式记录和管理堆(heap)中的所有对象。通过这种方式确定哪些对象是"可达的"，哪些对象是"不可达的"。当GC确定一些对象为"不可达"时，GC就有责任回收这些内存空间。

可以。程序员可以手动执行System.gc()，通知GC运行，但是Java语言规范并不保证GC一定会执行。强制执行垃圾回收：System.gc()。Runtime.getRuntime().gc()

静态变量本身不会被回收，但是它所引用的对象应该是可以回收的。

gc只回收heap里的对象，对象都是一样的,只要没有对它的引用,就可以被回收(但是不一定被回收). 对象的回收和是否static没有什么关系!

垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存。垃圾回收器通常是作为一个单独的低级别的线程运行，不可预知的情况下对内存堆中已经死亡的或者长时间没有使用的对象进行清楚和回收，程序员不能实时的调用垃圾回收器对某个对象或所有对象进行垃圾回收。

**143. Java怎么打印日志？**

* 最简单的方式，就是system.println.out(error) ,这样直接在控制台打印消息了。

* Java.util.logging ; 在JDK 1.4 版本之后，提供了日志的API ，可以往文件中写日志了。

```java
import java.io.IOException;  
import java.util.Date;  
import java.util.logging.FileHandler;  
import java.util.logging.Formatter;  
import java.util.logging.Level;  
import java.util.logging.LogRecord;  
import java.util.logging.Logger;  

public class TestLogJava {  

    public static void main(String[] args) throws IOException{  
        Logger log = Logger.getLogger("tesglog");  
        log.setLevel(Level.ALL);  
        FileHandler fileHandler = new FileHandler("testlog.log");  
        fileHandler.setLevel(Level.ALL);  
        fileHandler.setFormatter(new LogFormatter());  
        log.addHandler(fileHandler);  
        log.info("This is test java util log");     
    }  
}  

class LogFormatter extends Formatter {  
    @Override  
    public String format(LogRecord record) {  
        Date date = new Date();  
        String sDate = date.toString();  
        return "[" + sDate + "]" + "[" + record.getLevel() + "]"  
                + record.getClass() + record.getMessage() + "\n";  
    }  
}  
```

* log4j , 最强大的记录日志的方式。 可以通过配置 .properties 或是 .xml 的文件， 配置日志的目的地，格式等等。

```java
import org.apache.log4j.Logger;  
import org.apache.log4j.PropertyConfigurator;  

public class TestLog4j {  

    public static void main(String[] args) {  
        // 1. create log  
        Logger log = Logger.getLogger(TestLog4j.class);  
        // 2. get log config file  
        PropertyConfigurator.configure("log4j.properties");  
        // 3. start log  
        log.debug("Here is some DEBUG");  
        log.info("Here is some INFO");  
        log.warn("Here is some WARN");  
        log.error("Here is some ERROR");  
        log.fatal("Here is some FATAL");  
    }  
}  
```

* commons-logging, 最综合和常见的日志记录方式， 经常是和log4j 结合起来使用。

```java
import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  

public class TestLogCom {  
    static Log log = LogFactory.getLog(TestLog.class);  
    public static void main(String[] args) {  
        log.debug("Here is some DEBUG");  
        log.info("Here is some INFO");  
        log.warn("Here is some WARN");  
        log.error("Here is some ERROR");  
        log.fatal("Here is some FATAL");  
    }  
}
```

**144. 运行时异常与一般异常有何异同？**

**145. error和exception有什么区别?** 

**146. 给我一个你最常见到的runtime exception**

**147. Java中的异常处理机制的简单原理和应用。**

**148. java中有几种类型的流？JDK为每种类型的流提供了一些抽象类以供继承，请说出他们分别是哪些类？**

**149. 什么是java序列化，如何实现java序列化？**

**150. 运行时异常与受检异常有什么区别？**

### JavaEE Spring部分

**151. 说一下IOC和AOP?**

**152. 介绍一下bean的生命周期**

**153. Spring里面注解用过没有？autowired 和resource区别？**

**154. @Controller和@RestController的区别？**

**155. 依赖注入的方式有几种，哪几种？**

**156. springIOC原理？自己实现IOC要怎么做，哪些步骤？**

**157. Spring中BeanFactory和ApplicationContext的区别？**

**158. 什么是IoC和DI？DI是如何实现的？**

**159. 请问Spring中Bean的作用域有哪些？**

**160. 谈谈Spring中自动装配的方式有哪些？**

**161. aop的应用场景？**

**162. AOP的原理是什么？**

**163. 你如何理解AOP中的连接点（Joinpoint）、切点（Pointcut）、增强（Advice）、引介（Introduction）、织入（Weaving）、切面（Aspect）这些概念？**

**164. Spring支持的事务管理类型有哪些？你在项目中使用哪种方式？**

**165. 介绍一下spring？**

**166. Struts拦截器和Spring AOP区别？**

**167. spring框架的优点？**

**168. 选择使用Spring框架的原因（Spring框架为企业级开发带来的好处有哪些）？**

**169. 持久层设计要考虑的问题有哪些？你用过的持久层框架有哪些？**

**170. 阐述实体对象的三种状态以及转换关系。**

**171. Hibernate中SessionFactory是线程安全的吗？Session是线程安全的吗（两个线程能够共享同一个Session吗）？**

**172. Hibernate中Session的load和get方法的区别是什么？**

**173. 如何理解Hibernate的延迟加载机制？在实际应用中，延迟加载与Session关闭的矛盾是如何处理的？**

**174. 简述Hibernate常见优化策略。**

**175. 锁机制有什么用？简述Hibernate的悲观锁和乐观锁机制**

**176. Hibernate如何实现分页查询**

**177. 谈一谈Hibernate的一级缓存、二级缓存和查询缓存。**

**178. 说说STRUTS的应用**

**179. 解释一下MyBatis中命名空间（namespace）的作用**

**180. MyBatis中的动态SQL是什么意思？**

**181. Spring MVC注解的优点**

**182. springmvc和spring-boot区别？**

**183. SpringMVC的运行机制，运行机制的每一部分的相关知识？**

**184. 谈谈Spring MVC的工作原理是怎样的？**

**185. Mybatis和Hibernate区别？**

**186. 介绍一下你了解的Java领域的Web Service框架。**

**187. EJB是基于哪些技术实现的？并说出SessionBean和EntityBean的区别，StatefulBean和StatelessBean的区别。**

**188. EJB与JAVA BEAN的区别？**

**189. EJB包括（SessionBean,EntityBean）说出他们的生命周期，及如何管理事务的？**

**190. EJB的角色和三个对象是什么？**

**191. 说说EJB规范规定EJB中禁止的操作有哪些？**

**192. EJB的激活机制是什么？**

**193. EJB的几种类型分别是什么**

**194. EJB需直接实现它的业务接口或Home接口吗，请简述理由。**

### Java Web编程

**195. 启动项目时如何实现不在链接里输入项目名就能启动?**

**196. 1分钟之内只能处理1000个请求，你怎么实现，手撕代码?**

**197. 什么时候用assert**

**198. JAVA应用服务器有那些？**

**199. JSP的内置对象及方法。**

**200. JSP和Servlet有哪些相同点和不同点，他们之间的联系是什么？（JSP）**

**201. 说一说四种会话跟踪技术**

**202. 讲讲Request对象的主要方法**

**203. 说说weblogic中一个Domain的缺省目录结构?比如要将一个简单的helloWorld.jsp放入何目录下,然后在浏览器上就可打入主机？**

**204. jsp有哪些动作?作用分别是什么?**

**205. 请谈谈JSP有哪些内置对象？作用分别是什么？**

**206. 说一下表达式语言（EL）的隐式对象及其作用**

**207. JSP中的静态包含和动态包含有什么区别？**

**208. 过滤器有哪些作用和用法？**

**209. 请谈谈你对Javaweb开发中的监听器的理解？**

**210. 说说web.xml文件中可以配置哪些内容？**

**211. forward与redirect区别，说一下你知道的状态码，redirect的状态码是多少？**

**212. servlet生命周期，是否单例，为什么是单例。**

**213. 说出Servlet的生命周期，并说出Servlet和CGI的区别。**

**214. Servlet执行时一般实现哪几个方法？**

**215. 阐述一下阐述Servlet和CGI的区别?**

**216. 说说Servlet接口中有哪些方法？**

**217. Servlet 3中的异步处理指的是什么？**

**218. 如何在基于Java的Web项目中实现文件上传和下载？**

**219. 服务器收到用户提交的表单数据，到底是调用Servlet的doGet()还是doPost()方法？**

**220. Servlet中如何获取用户提交的查询参数或表单数据？**

**221. Servlet中如何获取用户配置的初始化参数以及服务器上下文参数？**

**222. 讲一下redis的主从复制怎么做的？**

**223. redis为什么读写速率快性能好？**

**224. redis为什么是单线程？**

**225. 缓存的优点？**

**226. aof，rdb，优点，区别？**

**227. redis的List能用做什么场景？**

**228. 说说MVC的各个部分都有那些技术来实现?如何实现?**

**229. 什么是DAO模式？**

**230. 请问Java Web开发的Model 1和Model 2分别指的是什么？**

**231. 你的项目中使用过哪些JSTL标签？**

**232. 使用标签库有什么好处？如何自定义JSP标签？（JSP标签）**

**233. get和post区别？**

**234. 请谈谈转发和重定向的区别？**

**235. 说说你对get和post请求，并且说说它们之间的区别？**

**236. cookie 和session 的区别？**

**237. forward 和redirect的区别**

**238. BS与CS的联系与区别。**

**239. 如何设置请求的编码以及响应内容的类型？**

**240. 什么是Web Service（Web服务）？**

**241. 谈谈Session的save()、update()、merge()、lock()、saveOrUpdate()和persist()方法分别是做什么的？有什么区别？**

**242. 大型网站在架构上应当考虑哪些问题？**

**243. 请对J2EE中常用的名词进行解释(或简单描述)**

### JDBC编程

**244. 写SQL：找出每个城市的最新一条记录。**

**245. 一个学生表，一个课程成绩表，怎么找出学生课程的最高分数**

**246. 有一组合索引（A,B,C），会出现哪几种查询方式？tag:sql语句**

**247. 数据库水平切分，垂直切分**

**248. 数据库索引介绍一下。介绍一下什么时候用Innodb什么时候用MyISAM。**

**249. 数据库两种引擎**

**250. 索引了解嘛，底层怎么实现的，什么时候会失效**

**251. 问了数据库的隔离级别**

**252. 数据库乐观锁和悲观锁**

**253. 数据库的三范式？**

**254. 讲一下数据库ACID的特性？**

**255. mysql主从复制？**

**256. leftjoin和rightjoin的区别？**

**257. 数据库优化方法**

**258. 谈一下你对继承映射的理解。**

**259. 说出数据连接池的工作机制是什么?**

**260. 事务的ACID是指什么？**

**261. JDBC中如何进行事务处理？**

**262. JDBC的反射，反射都是什么？**

**263. Jdo是什么?**

**264. Statement和PreparedStatement有什么区别？哪个性能更好？**

**265. 使用JDBC操作数据库时，如何提升读取数据的性能？如何提升更新数据的性能？**

**266. **

**267. **

**268. **

**269. **

**270. **

**271. **

**272. **

**273. **

**274. **

**275. **

**276. **

**277. **

**278. **

**279. **

**280. **

**281. **

**282. **

**283. **

**284. **

**285. **

**286. **

**287. **

**288. **

**289. **

**290. **

**291. **

**292. **

**293. **

**294. **

**295. **

**296. **

**297. **

**298. **

**299. **
