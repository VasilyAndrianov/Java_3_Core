package Home_work_7.CheckHomeWork;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckWork {

    public static void CheckWork() throws Exception {
        File file = new File("C:/Home work");
        String[] str = file.list();
        List<String> nameFile = new ArrayList<>();

        for (String o : str) {
            String[] array = o.split("\\.");
            if (array[1].equalsIgnoreCase("class")) {
                nameFile.add(array[0]);
            }

            Iterator iterator = nameFile.iterator();
            while (iterator.hasNext()) {
                String name = String.valueOf(iterator.next());
                Class aClass = URLClassLoader.newInstance(new URL[]{new File("C:/Home work").toURL()}).loadClass(array[0]);
                Constructor constructor = aClass.getConstructor();
                Object obj = constructor.newInstance();

                Method calculate = aClass.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
                int result = (Integer) calculate.invoke(obj, 2, 2, 10, 2);
                System.out.println(result);

                Method checkTwoNumbers = aClass.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
                boolean result2 = (Boolean) checkTwoNumbers.invoke(obj, 2, 6);
                System.out.println(result2);

                Method printIsPositive = aClass.getDeclaredMethod("printIsPositive", int.class);
                String result3 = (String) printIsPositive.invoke(obj, 6);
                System.out.println(result3);

                Method isNegative = aClass.getDeclaredMethod("isNegative", int.class);
                boolean result4 = (Boolean) isNegative.invoke(obj, -2);
                System.out.println(result4);

                Method printWelcome = aClass.getDeclaredMethod("printWelcome", String.class);
                String result5 = (String) printWelcome.invoke(obj, "java");
                System.out.println(result5);

                Method isLeapYear = aClass.getDeclaredMethod("isLeapYear", int.class);
                String result6 = (String) isLeapYear.invoke(obj, 2018);
                System.out.println(result6);

                if (result == 14 && result2 == (true || false) && result3 == "positive" && result4 == (true || false) && result5.equalsIgnoreCase("Привет java")
                        && result6 == "год не високосный") System.out.println(name + "correctly");
                else {
                    System.out.println(name + "incorrectly");
                }
            }
        }
    }
}

