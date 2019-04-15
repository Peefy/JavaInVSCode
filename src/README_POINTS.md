
# Java `Map`概述

*(01)* `Map` 是“键值对”映射的抽象接口。

*(02)* `AbstractMap` 实现了Map中的绝大部分函数接口。它减少了“Map的实现类”的重复编码。

*(03)* `SortedMap` 有序的“键值对”映射接口。

*(04)* `NavigableMap` 是继承于SortedMap的，支持导航函数的接口。

*(05)* `HashMap`, `Hashtable`, `TreeMap`, `WeakHashMap`这4个类是“键值对”映射的实现类。它们各有区别！

* `HashMap` 是基于“拉链法”实现的散列表。一般用于单线程程序中。
* `Hashtable` 也是基于“拉链法”实现的散列表。它一般用于多线程程序中。
* `WeakHashMap` 也是基于“拉链法”实现的散列表，它一般也用于单线程程序中。相比HashMap，WeakHashMap中的键是“弱键”，当“弱键”被GC回收时，它对应的键值对也会被从WeakHashMap中删除；而HashMap中的键是强键。
* `TreeMap` 是有序的散列表，它是通过红黑树实现的。它一般用于单线程中存储有序的映射。

**HashMap和Hashtable异同**

*相同点*
* `HashMap`和`Hashtable`都是存储“键值对(key-value)”的散列表，而且都是采用拉链法实现的。

*不同点*
* 继承和实现方式不同:HashMap 继承于AbstractMap，实现了Map、Cloneable、java.io.Serializable接口。Hashtable 继承于Dictionary，实现了Map、Cloneable、java.io.Serializable接口。
* 线程安全不同:Hashtable的几乎所有函数都是同步的，即它是线程安全的，支持多线程。
而HashMap的函数则是非同步的，它不是线程安全的
* 对null值的处理不同：HashMap的key、value都可以为null。Hashtable的key、value都不可以为null。
* 支持的遍历种类不同：HashMap只支持Iterator(迭代器)遍历。
而Hashtable支持Iterator(迭代器)和Enumeration(枚举器)两种方式遍历。
* 通过Iterator迭代器遍历时，遍历的顺序不同：HashMap是“从前向后”的遍历数组；再对数组具体某一项对应的链表，从表头开始进行遍历。Hashtabl是“从后往前”的遍历数组；再对数组具体某一项对应的链表，从表头开始进行遍历。
* 容量的初始值 和 增加方式都不一样：HashMap默认的容量大小是16；增加容量时，每次将容量变为“原始容量x2”。Hashtable默认的容量大小是11；增加容量时，每次将容量变为“原始容量x2 + 1”。装载因子均为0.75
* 部分API不同。Hashtable支持contains(Object value)方法，而且重写了toString()方法；而HashMap不支持contains(Object value)方法，没有重写toString()方法。

**HashMap和WeakHashMap异同异同**
*相同点*
1. 它们都是散列表，存储的是“键值对”映射。
2. 它们都继承于AbstractMap，并且实现Map基础。
3. 它们的构造函数都一样。
   它们都包括4个构造函数，而且函数的参数都一样。
4. 默认的容量大小是16，默认的加载因子是0.75。
5. 它们的“键”和“值”都允许为null。
6. 它们都是“非同步的”。

*不同点*
* HashMap实现了Cloneable和Serializable接口，而WeakHashMap没有
* HashMap的“键”是“强引用(StrongReference)”，而WeakHashMap的键是“弱引用(WeakReference)”。

**Java的初始化块、静态初始化块、构造函数的执行顺序及用途**

1. 父类的静态初始化块
2. 子类的静态初始化块
3. 父类的初始化块
4. 父类的构造函数
5. 子类的初始化块
6. 子类的构造函数

```java
class A {
    static {
        System.out.println("Static init A.");
    }

    {
        System.out.println("Instance init A.");
    }

    A() {
        System.out.println("Constructor A.");
    }
}

class B extends A {
    static {
        System.out.println("Static init B.");
    }

    {
        System.out.println("Instance init B.");
    }

    B() {
        System.out.println("Constructor B.");
    }
}

class C extends B {

    static {
        System.out.println("Static init C.");
    }

    {
        System.out.println("Instance init C.");
    }

    C() {
        System.out.println("Constructor C.");
    }
}

public class Main {

    static {
        System.out.println("Static init Main.");
    }

    {
        System.out.println("Instance init Main.");
    }

    public Main() {
        System.out.println("Constructor Main.");
    }

    public static void main(String[] args) {
        C c = new C();
        //B b = new B();
    }
}

```

```java
Static init Main.
Static init A.
Static init B.
Static init C.
Instance init A.
Constructor A.
Instance init B.
Constructor B.
Instance init C.
Constructor C.
```

**Java并发编程**

1. **在java中守护线程和本地线程区别？**

java中的线程分为两种：守护线程（Daemon）和用户线程（User）。任何线程都可以设置为守护线程和用户线程，通过方法Thread.setDaemon(bool on)；true则把该线程设置为守护线程，反之则为用户线程。Thread.setDaemon()必须在Thread.start()之前调用，否则运行时会抛出异常。

两者的区别： 
唯一的区别是判断虚拟机(JVM)何时离开，Daemon是为其他线程提供服务，如果全部的User Thread已经撤离，Daemon 没有可服务的线程，JVM撤离。也可以理解为守护线程是JVM自动创建的线程（但不一定），用户线程是程序创建的线程；比如JVM的垃圾回收线程是一个守护线程，当所有线程已经撤离，不再产生垃圾，守护线程自然就没事可干了，当垃圾回收线程是Java虚拟机上仅剩的线程时，Java虚拟机会自动离开。

2. **线程与进程的区别？**

进程是操作系统分配资源的最小单元，线程是操作系统调度的最小单元。

一个程序至少有一个进程,一个进程至少有一个线程。

3. **什么是多线程中的上下文切换？**

多线程会共同使用一组计算机上的CPU，而线程数大于给程序分配的CPU数量时，为了让各个线程都有执行的机会，就需要轮转使用CPU。不同的线程切换使用CPU发生的切换数据等就是上下文切换。

4. **死锁与活锁的区别，死锁与饥饿的区别？**

**死锁**：是指两个或两个以上的进程（或线程）在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们都将无法推进下去。 

产生死锁的必要条件： 

* **互斥条件**：所谓互斥就是进程在某一时间内独占资源。
请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。 
* **不剥夺条件**:进程已获得资源，在末使用完之前，不能强行剥夺。 
循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
活锁：任务或者执行者没有被阻塞，由于某些条件没有满足，导致一直重复尝试，失败，尝试，失败。

**活锁**和**死锁**的区别在于，处于活锁的实体是在不断的改变状态，所谓的“活”， 而处于死锁的实体表现为等待；活锁有可能自行解开，死锁则不能。

**饥饿**：一个或者多个线程因为种种原因无法获得所需要的资源，导致一直无法执行的状态。 

Java中导致饥饿的原因： 

* 高优先级线程吞噬所有的低优先级线程的CPU时间。 
* 线程被永久堵塞在一个等待进入同步块的状态，因为其他线程总是能在它之前持续地对该同步块进行访问。 
* 线程在等待一个本身也处于永久等待完成的对象(比如调用这个对象的wait方法)，因为其他线程总是被持续地获得唤醒。

5. **Java中用到的线程调度算法是什么？**

采用**时间片轮转**的方式。可以设置线程的优先级，会映射到下层的系统上面的优先级上，如非特别需要，尽量不要用，防止线程饥饿。

6. **什么是线程组，为什么在Java中不推荐使用？**

ThreadGroup类，可以把线程归属到某一个线程组中，线程组中可以有线程对象，也可以有线程组，组中还可以有线程，这样的组织结构有点类似于树的形式。

为什么不推荐使用？因为使用有很多的安全隐患吧，没有具体追究，如果需要使用，推荐使用线程池。

7. ****

8. ****

9. ****

10. ****

11. ****

12. ****

13. ****

14. ****

15. ****

16. ****

17. ****

18. ****

19. ****

20. ****

21. ****

22. ****

23. ****

24. ****

25. ****

26. ****

27. ****

28. ****

29. ****

30. ****

31. ****

32. ****

33. ****

34. ****

35. ****

36. ****

37. ****

38. ****

39. ****

40. ****

41. ****

42. ****

43. ****

44. ****

45. ****

46. ****

47. ****

48. ****

49. ****

50. ****

51. ****

52. ****

53. ****

54. ****

55. ****

56. ****

57. ****

58. ****

59. ****

60. ****

61. ****

62. ****

63. ****

64. ****

65. ****

66. ****

67. ****

68. ****

69. ****

70. ****

71. ****

72. ****

73. ****

74. ****

75. ****

76. ****

77. ****

78. ****

79. ****