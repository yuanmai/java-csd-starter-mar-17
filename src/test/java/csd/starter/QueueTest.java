package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liuz on 2017/3/6.
 */
public class QueueTest {
    Queue queue = new LinkedList();

    @Test
    public void size_of_empty_queue_should_be_zero() {

        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void size_of_push_queue_should_be_add() {

        queue.add("test");

        Assert.assertEquals(1, queue.size());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void size_of_poll_queue_should_throw_exception() {

        queue.remove();

    }

    @Test
    public void queue_should_be_fifo() {

        queue.add("1");
        queue.add("2");

        Assert.assertEquals("1", queue.remove());
    }

}
