package Home_work_4.task_2;

public class Mfu {

    public static void main(String[] args) {
        final Object printAndScan = new Object();
        final Object mailing = new Object();

        Thread print = new Thread(() -> {
            synchronized (printAndScan) {
                System.out.println("Подготовка к печати");
                System.out.println("печать");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Печать завершина");
                printAndScan.notify();
            }
        });
        print.start();

        Thread scan = new Thread(() -> {
            synchronized (printAndScan) {
                System.out.println("Подготовка к ксерокопированию");
                System.out.println("Выполнение ксерокопирования");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Ксерокопирование завершино");
                printAndScan.notify();
            }
        });
        scan.start();


        Thread scanAndMailing = new Thread(() -> {
            synchronized (mailing) {
                System.out.println("Подготовка к сканированию");
                System.out.println("Выполнение сканирования");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Копия отправлена");
            }
        });
        scanAndMailing.start();

    }
}
