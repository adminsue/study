#### 这个包是Java的List集合，学习过后简单总结如下


## 介绍
List是一个有序的集合，和set不同的是，List允许存储项的值为空，也允许存储相等值的存储项。

## ArrayList
ArrayList是一个数组实现的列表，由于数据是存入数组中的，所以它的特点也和数组一样，**查询很快，但是中间部分的插入和删除很慢**。

ArrayList有2个构造函数，一个是默认无参的，一个是传入数组大小的。
在JavaEffect书中明确提到，如果预先能知道或者估计所需数据项个数的，需要传入initialCapacity，
因为如果使用无参的构造函数，会首先把EMPTY_ELEMENTDATA赋值给elementData，然后根据插入个数于当前数组size比较，不停调用Arrays.copyOf()方法，扩展数组大小，造成性能浪费。

ArrayList默认每次都是自增50%的大小再和minCapacity比较，如果还是不够，就把当的size扩充至minCapacity。

## Vector
Vector就是ArrayList的线程安全版，它的方法前都加了synchronized锁，其他实现逻辑都相同。 
如果对线程安全要求不高的话，可以选择ArrayList，毕竟synchronized也很耗性能

## LinkedList
故名思意就是链表，和我们大学在数据结构里学的链表是一会事，LinkedList还是一个双向链表。


## 总结
通过对ArrayList和LinkedList的分析，可以理解List的3个特性 
1. 是按顺序查找 
2. 允许存储项为空 
3. 允许多个存储项的值相等 

然后对比LinkedList和ArrayList的实现方式不同，可以在不同的场景下使用不同的List 
* ArrayList是由数组实现的，方便查找，返回数组下标对应的值即可，适用于多查找的场景 
* LinkedList由链表实现，插入和删除方便，适用于多次数据替换的场景
