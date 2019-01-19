package com.adminsue.study.design.factory;

import com.adminsue.study.BaseTest;
import com.adminsue.study.design.factory.provider.Provider;
import com.adminsue.study.design.factory.provider.impl.P1Provider;
import com.adminsue.study.design.factory.provider.impl.SpProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
public class QueueTest extends BaseTest {

    @Autowired
    private Queue queue;

    @DataProvider
    public Object[][] paramProvider() {
        return new Object[][]{
                {new SpProvider()},
                {new P1Provider()}
        };
    }

    @Test(dataProvider = "paramProvider")
    public void doQueue(Provider provider) {
        queue.doQueue(provider);
    }

}