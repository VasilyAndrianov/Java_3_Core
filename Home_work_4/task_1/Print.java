package Home_work_4.task_1;

public class Print implements Runnable {
    protected static char s = 'A';
    static Object sync = new Object();
    char singNow;
    char singNext;


    public Print(char singNow, char singNext) {
        this.singNow = singNow;
        this.singNext = singNext;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (sync) {
                try {
                    while (s != singNow)
                        sync.wait();
                    System.out.print(singNow);
                    if (singNow == 'C') System.out.println(";");
                    s = singNext;
                    sync.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

