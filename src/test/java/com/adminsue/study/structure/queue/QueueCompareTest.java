package com.adminsue.study.structure.queue;

import com.adminsue.study.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-20.
 */
@Slf4j
public class QueueCompareTest extends BaseTest {

    @Autowired
    private QueueCompare queueCompare;

    @Autowired
    @Qualifier("firstTaskExecutor")
    private Executor executor;

    @DataProvider
    public Object[][] paramProvider() {
        return new Object[][]{
                {new LinkedList<>()},
                {new ConcurrentLinkedQueue<>()},
                {new LinkedBlockingQueue<>()}
        };
    }

    @Test(dataProvider = "paramProvider")
    public void testAddElement(Queue<Object> queue) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = (ThreadPoolTaskExecutor) executor;
        for (int i = 0; i < 100000; i++) {
            queueCompare.addElement(queue, i);
        }
        int poolSize;
        do {
            poolSize = threadPoolTaskExecutor.getThreadPoolExecutor().getQueue().size();
            log.info("Pool Size Now: {}", poolSize);
        } while (poolSize != 0);
        log.info("Final Insert Size: {}", queue.size());
        if (queue instanceof LinkedList) {
            Assert.assertNotEquals(queue.size(), 100000);
        } else {
            Assert.assertEquals(queue.size(), 100000);
        }
    }
}