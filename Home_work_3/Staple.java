package Home_work_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Staple {
    public Staple() throws IOException {
        ArrayList<InputStream> stap = new ArrayList<>();
        stap.add(new FileInputStream("src/main/java/Home_work_3/task2_one"));
        stap.add(new FileInputStream("src/main/java/Home_work_3/task2_two"));
        stap.add(new FileInputStream("src/main/java/Home_work_3/task2_three"));
        stap.add(new FileInputStream("src/main/java/Home_work_3/task2_four"));
        stap.add(new FileInputStream("src/main/java/Home_work_3/task2_five"));

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(stap));

        int x;
        while ((x = in.read()) != -1){
            System.out.print((char) x);
        }
        in.close();
    }
}
