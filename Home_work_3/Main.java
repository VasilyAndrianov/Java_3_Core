package Home_work_3;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Home_work_3/task3");
        System.out.println(getFileSizeBytes(file));
        new Read(file);
        new Staple();
        new ReadBook(file);

    }

    public static String getFileSizeBytes(File file) {
        return  file.length() + " bytes";
    }
}
