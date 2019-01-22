package com.adminsue.study.structure.stack;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-22.
 */
public interface Stack<T> {

    boolean push(T t);

    T pop();

    T peek();

    boolean isEmpty();

}
