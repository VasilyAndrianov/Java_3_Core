package Home_work_4.task_1;

public class Main {
        public static void main(String[] args) {
        new Thread( new Print('A', 'B')).start();
        new Thread( new Print('B', 'C')).start();
        new Thread( new Print('C', 'A')).start();
    }


}
