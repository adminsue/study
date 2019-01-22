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
public class LinkedStackTest extends BaseTest {
    private static LinkedStack<String> linkedStack = new LinkedStack<>();
    private static String[] exceptedString = new String[3];

    @BeforeMethod
    public void initialSeqStack() {
        linkedStack.push("A");
        linkedStack.push("B");
        linkedStack.push("C");
        exceptedString[0] = "C";
        exceptedString[1] = "B";
        exceptedString[2] = "A";
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void testSeqStack() {

        int size = linkedStack.size();
        Assert.assertEquals(size, 3);
        for (int i = 0; i < size; i++) {
            Assert.assertEquals(linkedStack.pop(), exceptedString[i]);
        }

        //throw EmptyStackException
        linkedStack.peek();
    }
}