package Home_work_6.Task_One_Two;
import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        final int[] arrNum = {71, 46, 34, 4, 5, 676, 3, 7, 4, 14, 67, 8};
        final int[] arrNumber = {71, 46, 34, 5, 676, 3, 7, 14, 67, 8};

        System.out.println(Arrays.toString(nextNumAfFour(arrNum)));
        System.out.println(Arrays.toString(nextNumAfFour(arrNumber)));
    }

    public static int[] nextNumAfFour(int[] arr) {
        if (arr.length == 0) throw new RuntimeException("Массив пустой");
        int number;
        int[] mass;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                number = i;
                mass = new int[arr.length - number - 1];
                System.arraycopy(arr, number + 1, mass, 0, mass.length);
                return mass;
            }
        }
        throw new RuntimeException("В массиве нет цыфры 4");
    }
}
