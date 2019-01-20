package com.adminsue.study.design.singleton;

import com.adminsue.study.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
@Slf4j
public class SingletonTest extends BaseTest {

    @DataProvider
    public Object[][] paramProvider() {
        return new Object[][]{
                {(Supplier<Object>) DoubleCheckSingleton::getInstance},
                {(Supplier<Object>) () -> EnumSingleton.INSTANCE},
                {(Supplier<Object>) HungrySingleton::getInstance},
                {(Supplier<Object>) InternalClassSingleton::getInstance}
        };
    }

    @Test(dataProvider = "paramProvider")
    public void doQueue(Supplier<Object> supplier) throws Exception {
        List<Integer> loops = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            loops.add(i);
        }
        List<CompletableFuture<Object>> futures = loops.stream()
                .map(i -> CompletableFuture.supplyAsync(supplier))
                .collect(Collectors.toList());
        Set<Object> result = new HashSet<>();
        for (CompletableFuture<Object> future : futures) {
            Object o = future.get();
//            log.info(o.toString());
            result.add(o);
        }
        Assert.assertEquals(result.size(), 1);
    }


}
