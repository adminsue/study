package com.adminsue.study.design.singleton;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
public class InternalClassSingleton {

    private InternalClassSingleton() {
    }

    public static InternalClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final InternalClassSingleton INSTANCE = new InternalClassSingleton();
    }

}
