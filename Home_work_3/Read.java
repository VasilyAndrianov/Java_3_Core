package Home_work_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Read {

    public Read(File file) {
        try(FileInputStream in = new FileInputStream(file)) {
            byte[] array = new byte[256];
            int x;
            while ((x = in.read(array)) > 0){
                System.out.println(new String(array, 0, x, "UTF-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
