#### 这个包是Java的Set集合，学习过后简单总结如下


## 介绍
* 注重独一无二的性质,该体系集合可以知道某物是否已近存在于集合中,不会存储重复的元素。
* 用于存储无序(存入和取出的顺序不一定相同)元素，值不能重复。
                                          
## 对象的相等性
* 引用到堆上同一个对象的两个引用是相等的。如果对两个引用调用hashCode方法，会得到相同的结果，如果对象所属的类没有覆盖Object的hashCode方法的话，hashCode会返回每个对象特有的序号（java是依据对象的内存地址计算出的此序号），所以两个不同的对象的hashCode值是不可能相等的。
* 如果想要让两个不同的Person对象视为相等的，就必须覆盖Object继下来的hashCode方法和equals方法，因为Object  hashCode方法返回的是该对象的内存地址，所以必须重写hashCode方法，才能保证两个不同的对象具有相同的hashCode，同时也需要两个不同对象比较equals方法会返回true

## HashSet
哈希表边存放的是哈希值。HashSet存储元素的顺序并不是按照存入时的顺序(和List显然不同)是按照哈希值来存的所以取数据也是按照哈希值取得。
> HashSet不存入重复元素的规则.使用hashcode和equals，hashcode&&equals

元素的哈希值是通过元素的hashcode方法来获取的, HashSet首先判断两个元素的哈希值，如果哈希值一样，接着会比较equals方法。如果equals结果为true，HashSet就视为同一个元素。如果equals 为false就不是同一个元素。

哈希值相同equals为false的元素是怎么存储呢,就是在同样的哈希值下顺延（可以认为哈希值相同的元素放在一个哈希桶中）。也就是哈希一样的存一列。

HashSet：通过hashCode值来确定元素在内存中的位置。一个hashCode位置上可以存放多个元素。


## 判断是否相同
HashSet 和ArrayList集合都有判断元素是否相同的方法，boolean contains(Object o)

HashSet使用hashCode和equals方法，ArrayList使用了equals方法

## TreeSet
> ArrayList 、 LinkedList不能去除重复数据。HashSet可以去除重复，但是是无序。

不重复存储元素，而且可以排序。
* 元素自身具备比较性: 需要元素实现Comparable接口，重写compareTo方法，也就是让元素自身具备比较性，这种方式叫做元素的自然排序也叫做默认排序。
* 容器具备比较性: 定义一个类实现接口Comparator，重写compare方法，并将该接口的子类实例对象作为参数传递给集合的构造方法。
> 注意：当Comparable比较方式和Comparator比较方式同时存在时，以Comparator的比较方式为主。

> 注意：在重写compareTo或者compare方法时，必须要明确比较的主要条件相等时要比较次要条件。（假设姓名和年龄一直的人为相同的人，如果想要对人按照年龄的大小来排序，如果年龄相同的人，需要如何处理？不能直接return 0，因为可能姓名不同（年龄相同姓名不同的人是不同的人）。此时就需要进行次要条件判断（需要判断姓名），只有姓名和年龄同时相等的才可以返回0.）

## LinkedHashSet
会保存插入的顺序。

看到array，就要想到角标。

看到link，就要想到first，last。

看到hash，就要想到hashCode,equals.

看到tree，就要想到两个接口。Comparable，Comparator。
