package Home_work_6.Task_One_Two;

public class Task1 {

    public static boolean checkMass(int[] array) {
        if (array.length == 0) throw new RuntimeException("Массив пустой");

        boolean num = true;
        int count = 0;
        while (count < array.length && num) {
            if (array[count] == 1) {
                num = true;
            } else {
                if (array[count] == 4) {
                    num = true;
                } else {
                    num = false;
                }
            }count++;
        }
        return num;
    }
}
