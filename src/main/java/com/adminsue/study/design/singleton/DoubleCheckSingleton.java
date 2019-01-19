package com.adminsue.study.design.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
@Slf4j
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
//        log.info("Entry get Instance");
        if (doubleCheckSingleton != null) {
            return doubleCheckSingleton;
        }
        synchronized (DoubleCheckSingleton.class) {
            if (doubleCheckSingleton == null) {
                doubleCheckSingleton = new DoubleCheckSingleton();
            }
        }
        return doubleCheckSingleton;
    }

}
