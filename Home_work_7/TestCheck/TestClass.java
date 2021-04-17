package Home_work_7.TestCheck;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestClass {
    @Test(priority = 4)
    public static void summ(){
        System.out.println("Test1 = " + (2 + 5));
    }

    @BeforeSuite
    public static void start(){
        System.out.println("start");
    }

    @Test(priority = 2)
    public static void multiplier(){
        System.out.println("Test2 = " + (2 * 3));
    }

    @Test(priority = 3)
    public static void glue(){
        String s = "hel";
        String c = "lo";
        System.out.println(s + c);
    }

    @AfterSuite
    public static void stop() {
        System.out.println("stop");
    }

    public static void testStart(Class grade) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = grade.getDeclaredMethods();
        List<Method> listMethod = new ArrayList<>();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)){
                int numPriority = m.getAnnotation(Test.class).priority();
                if (numPriority < 1 || numPriority > 8)throw new RuntimeException("Ошибка приоритетов");
                listMethod.add(m);
            }
        }

        listMethod.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
            }
        });

        for (Method m : methods){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if (listMethod.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("BeforeSuite ошибка");
                listMethod.add(0, m);
            }

            if (m.isAnnotationPresent(AfterSuite.class)){
                if (listMethod.get(listMethod.size() - 1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("AfterSuite ошибка");
                listMethod.add(m);
            }
        }

        for (Method m : listMethod){
            m.invoke(null);

        }
    }
}
