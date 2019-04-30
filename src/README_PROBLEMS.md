
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

7. 说说Lamda表达式的优缺点。

8. 一个十进制的数在内存中是怎么存的？

9. 为啥有时会出现4.0-3.6=0.40000001这种现象？

10. Java支持的数据类型有哪些？什么是自动拆装箱？

11. 什么是值传递和引用传递？

12. 数组(Array)和列表(ArrayList)有什么区别？什么时候应该使用Array而不是ArrayList？

13. 你了解大O符号(big-O notation)么？你能给出不同数据结构的例子么？

14. String是最基本的数据类型吗?

15. int 和 Integer 有什么区别

16. String 和StringBuffer的区别

17. 我们在web应用开发过程中经常遇到输出某种编码的字符，如iso8859-1等，如何输出一个某种编码的字符串？

18. &和&&的区别？

19. 在Java中，如何跳出当前的多重嵌套循环？

20. 你能比较一下Java和JavaSciprt吗？

21. 简述正则表达式及其用途。

22. Java中是如何支持正则表达式操作的？

23. 请你说说Java和PHP的区别？

24. 介绍一下Syncronized锁，如果用这个关键字修饰一个静态方法，锁住了什么？如果修饰成员方法，锁住了什么？

25. 介绍一下volatile？

26. 锁有了解嘛，说一下Synchronized和lock

27. 讲一讲Java里面的final关键字怎么用的？

28. wait方法底层原理

29. Java有哪些特性，举个多态的例子。

30. String为啥不可变？

31. 类和对象的区别

32. 请列举你所知道的Object类的方法。

33. 重载和重写的区别？相同参数不同返回值能重载吗？

34. ”static”关键字是什么意思？Java中是否可以覆盖(override)一个private或者是static的方法？

35. String能继承吗？

36. StringBuffer和StringBuilder有什么区别，底层实现上呢？

37. 类加载机制，双亲委派模型，好处是什么？

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
