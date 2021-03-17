package Home_work_1.task_1_2;

import java.util.ArrayList;
import java.util.Collections;

public class Transform<T> {

    public  Transform(T[] arr) {
        ArrayList<T> strList = new ArrayList<>();
        Collections.addAll(strList, arr);
        System.out.println(strList);
    }
}

//У меня был еще вот такой вариант решения. IDIA предлогала через asList, но это уже не самостоятельно.
//    public  Transform(T[] arr) {
//        ArrayList<T> strList = new ArrayList<T>();
//        for (int i = 0; i<arr.length; i++){
//            strList.add(arr[i]);
//        }
//        System.out.println(strList);
//    }

