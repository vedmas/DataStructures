import DataStructures.Lesson3.Stack.StackImpl;
import org.junit.*;

public class TestMethods {
    private StackImpl stack;

    @Before
    public void testStack() {
        stack = new StackImpl(5);
        stack.push(2);
        stack.push(3);

    }

    @org.junit.Test
    public void testSize() {
        Assert.assertEquals(2, stack.size());
    }

    @Test
    public void testPop() {
        Assert.assertEquals(3, stack.pop());
    }


}
