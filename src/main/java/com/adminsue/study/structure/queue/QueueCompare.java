package com.adminsue.study.structure.queue;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-20.
 */
@Component
public class QueueCompare {

    private static final Queue linkedList = new LinkedList();
    private static final Queue concurrentLinkedQueue = new ConcurrentLinkedQueue();
    private static final Queue linkedBlockingQueue = new LinkedBlockingQueue();

    @Async("firstTaskExecutor")
    public void addElement(Queue<Object> queue, Object o) {
        if (queue != null) {
            queue.add(o);
        }
    }

}
