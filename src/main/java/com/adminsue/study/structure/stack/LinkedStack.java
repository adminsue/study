package com.adminsue.study.structure.stack;

import javax.annotation.concurrent.NotThreadSafe;
import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-22.
 */
@NotThreadSafe
public class LinkedStack<T> implements Stack<T>, Cloneable, Serializable {

    private static final long serialVersionUID = -8017947358997515131L;

    private Node<T> top;

    private int size;

    public LinkedStack() {
    }

    @Override
    public boolean push(T t) {
        Node<T> node = new Node<>(t);
        if (top != null) {
            node.prev = top;
        }
        top = node;
        size++;
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T result = top.data;
        top = top.prev;
        size--;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T data;
        Node<T> prev;

        private Node(T data) {
            this.data = data;
        }
    }

}
