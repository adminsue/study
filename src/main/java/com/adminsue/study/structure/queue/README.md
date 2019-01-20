#### 这个包是Java队列-Queue分析，学习过后简单总结如下


## 介绍
Queue，一种先入先出（FIFO）的数据结构
* 非阻塞队列：ConcurrentLinkedQueue(无界线程安全)，采用CAS机制（compareAndSwapObject原子操作）。
* 阻塞队列：ArrayBlockingQueue(有界)、LinkedBlockingQueue（无界）、DelayQueue、PriorityBlockingQueue，采用锁机制；使用ReentrantLock 锁。

## Queue
| 方法  | 功能 | 备注 |
| ------------- | ------------- | ------------- |
| add  | 增加一个元索  | 如果队列已满，则抛出一个IllegalStateException异常  |
| remove  | 移除并返回队列头部的元素  | 如果队列为空，则抛出一个NoSuchElementException异常  |
| element  | 返回队列头部的元素  | 如果队列为空，则抛出一个NoSuchElementException异常  |
| offer  | 添加一个元素并返回true  | 如果队列已满，则返回false  |
| poll  | 移除并返问队列头部的元素  | 如果队列为空，则返回null  |
| peek  | 返回队列头部的元素  | 如果队列为空，则返回null  |


## BlockingQueue extends Queue
| 方法  | 功能 | 备注 |
| ------------- | ------------- | ------------- |
| put  | 添加一个元素  | 如果队列满，则阻塞  |
| take  | 移除并返回队列头部的元素  | 如果队列为空，则阻塞  |


## LinkedList、ConcurrentLinkedQueue、LinkedBlockingQueue对比分析
LinkedList线程不安全，关于ConcurrentLinkedQueue和LinkedBlockingQueue：
1. LinkedBlockingQueue是使用锁机制，ConcurrentLinkedQueue是使用CAS算法，虽然LinkedBlockingQueue的底层获取锁也是使用的CAS算法
2. 关于取元素，ConcurrentLinkedQueue不支持阻塞去取元素，LinkedBlockingQueue支持阻塞的take()方法，如若大家需要ConcurrentLinkedQueue的消费者产生阻塞效果，需要自行实现
3. 关于插入元素的性能，从字面上和代码简单的分析来看ConcurrentLinkedQueue肯定是最快的，但是这个也要看具体的测试场景，我做了两个简单的demo做测试，测试的结果如下，两个的性能差不多，但在实际的使用过程中，尤其在多cpu的服务器上，有锁和无锁的差距便体现出来了，ConcurrentLinkedQueue会比LinkedBlockingQueue快很多：