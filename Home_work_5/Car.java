package Home_work_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    protected static int position = 1;
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private final Race race;
    private final int speed;
    private final String name;
    private final CyclicBarrier cb;
    private final Object judge;

    public String getName() {return name;}

    public int getSpeed() {return speed;}

    public Car(Race race, CyclicBarrier cb, int speed, Object judge) {
        this.cb = cb;
        this.judge = judge;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        synchronized (judge){
            if (position == 1){
                System.out.println(this.name + " гонщик победил!");
            }else {
                System.out.println(this.name + " гонщик пришел на финишь " + position);
            }
            position++;
        }
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
