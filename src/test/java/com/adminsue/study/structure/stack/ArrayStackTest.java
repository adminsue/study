package com.adminsue.study.structure.stack;

import com.adminsue.study.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-22.
 */
public class ArrayStackTest extends BaseTest {

    private static ArrayStack<String> arrayStack = new ArrayStack<>();
    private static String[] exceptedString = new String[3];

    @BeforeMethod
    public void initialSeqStack() {
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");
        exceptedString[0] = "C";
        exceptedString[1] = "B";
        exceptedString[2] = "A";
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void testSeqStack() {

        int size = arrayStack.size();
        Assert.assertEquals(size, 3);
        for (int i = 0; i < size; i++) {
            Assert.assertEquals(arrayStack.pop(), exceptedString[i]);
        }

        //throw EmptyStackException
        arrayStack.peek();
    }

}