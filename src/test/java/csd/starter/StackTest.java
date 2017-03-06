package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by liuz on 2017/3/6.
 */
public class StackTest {

    Stack stack;

    @Test
    public void testEmptySize() {
        stack = new Stack();
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void testSizeAdd() {
        stack = new Stack();
        int old = stack.size();
        stack.push("1");
        int newSize = stack.size();
        Assert.assertEquals(newSize, old + 1);
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmpty() {
        stack = new Stack();
        stack.pop();
    }
}
