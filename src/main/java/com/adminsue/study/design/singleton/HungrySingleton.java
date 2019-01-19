package com.adminsue.study.design.singleton;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
public class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

}
