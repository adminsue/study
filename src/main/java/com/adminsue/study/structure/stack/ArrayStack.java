package com.adminsue.study.structure.stack;

import javax.annotation.concurrent.NotThreadSafe;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-22.
 */
@NotThreadSafe
public class ArrayStack<T> implements Stack<T>, Cloneable, Serializable {


    private static final long serialVersionUID = -8641211579706977554L;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private static final Object[] DEFAULT_CAPACITY_ELEMENT_DATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private transient Object[] elementData;

    private int top = -1;

    public ArrayStack() {
        elementData = DEFAULT_CAPACITY_ELEMENT_DATA;
    }

    public ArrayStack(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elementData = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULT_CAPACITY_ELEMENT_DATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    @Override
    public boolean push(T t) {
        ensureCapacityInternal(top + 2);
        elementData[++top] = t;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elementData[top--];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elementData[top];
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public int size() {
        return top + 1;
    }

}
