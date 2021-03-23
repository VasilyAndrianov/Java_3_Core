package Home_work_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class ReadBook {

    public ReadBook(File file) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r");
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long fileLength = raf.length();
            long pageLength = 1800;
            long pagesNumber = fileLength/pageLength;
            byte[] b = new byte[1800];
            System.out.println("fileLength: " + fileLength + " | pageLength: " + pageLength + " | pagesCount: " + pagesNumber);
            while (true) {
                System.out.println("\nEnter the page between 0 and " + pagesNumber + ". -1 to Exit.");
                long p = Long.parseLong(br.readLine());
                if (p <= pagesNumber && p >= 0) {
                    raf.seek(p * pageLength);
                    raf.read(b, 0, b.length);
                    for (byte bb : b) System.out.print((char) bb);
                } else if (p == -1) {
                    System.out.println("Bye!");
                    System.exit(0);
                } else {
                    System.out.println("Incorrect page: " + p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
