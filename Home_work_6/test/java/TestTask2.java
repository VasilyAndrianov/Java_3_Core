import Home_work_6.Task_One_Two.Task2;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestTask2 {
    private Task2 task2;
    final int[] arrNum = {71, 46, 34, 4, 5, 676, 3, 7, 4, 14, 67, 8};
    final int[] arrNumber = {71, 46, 34, 5, 676, 3, 7, 14, 67, 8};
    final int[] n = {14, 67, 8};

    @BeforeEach
    public void init(){
        task2 = new Task2();
    }

    @Test
    public void testOne(){
        Assertions.assertArrayEquals(n , task2.nextNumAfFour(arrNum) );
    }

    @Test(expected = RuntimeException.class)
    public void testTwo(){
        Assertions.assertEquals(RuntimeException.class, task2.nextNumAfFour(arrNumber));
    }

    @Test(expected = RuntimeException.class)
    public void testThree(){
        Assertions.assertEquals(RuntimeException.class, task2.nextNumAfFour(arrNum));
    }
}
