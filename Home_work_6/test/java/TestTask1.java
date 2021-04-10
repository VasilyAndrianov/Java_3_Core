import Home_work_6.Task_One_Two.Task1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask1 {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true},
                {new int[]{8, 8, 7, 7, 7, 3, 5, 1}, false},
                {new int[]{1, 4, 8, 7}, false}

        });
    }

    final int[] n = new int[0];
    private int[] in;
    private boolean out;

    public TestTask1(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private Task1 check;

    @Before
    public void startTest() {
        check = new Task1();
    }

    @Test
    public void testOneAndFour() {
        Assert.assertEquals(Task1.checkMass(in), out);
    }

    @Test(expected = RuntimeException.class)
    public void testException(){
        Assertions.assertEquals(RuntimeException.class, Task1.checkMass(n));
    }

}
