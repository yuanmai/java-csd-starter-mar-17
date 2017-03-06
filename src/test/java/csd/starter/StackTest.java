package csd.starter;

import java.util.Stack;

import org.junit.*;

/**
 * Created by wangsu on 2017/3/6.
 */
public class StackTest {
	Stack stack = new Stack();

	public StackTest() {
		System.out.println("ctor");
	}
    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

	@Before
	public void before() {
		System.out.println("befor");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@Test
	public void 新NEW的SIZE应该为空() {

		Assert.assertTrue("SIZE不为空", stack.size() == 0);
	}

	@Test
	public void PUSH后SIZE应该加一() {
		Stack stack = new Stack();
		int oldSize = stack.size();

		stack.push("");

		Assert.assertTrue("PUSH后SIZE未加一", stack.size() - oldSize == 1);
	}

	@Test(expected = java.util.EmptyStackException.class)
	public void 空对象POP时应该抛出异常() {
		Stack stack = new Stack();
		stack.pop();
	}
}
