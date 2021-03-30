package Home_work_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class MainClass {
    public static final int CARS_COUNT = 8;
    public static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Object judge = new Object();
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race,cb, 20 + (int) (Math.random() * 10),judge);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        cb.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cb.await();
        cb.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

