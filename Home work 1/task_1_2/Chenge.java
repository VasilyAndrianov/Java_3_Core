package Home_work_1.task_1_2;

import java.util.Arrays;

public class Chenge {

    public Chenge(Object[] arr, int a, int b) {
        System.out.print(Arrays.toString(arr));
        Object i;
        i = arr[a];
        arr[a] = arr[b];
        arr[b] = i;
        System.out.println();
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }

}
