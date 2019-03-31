
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
