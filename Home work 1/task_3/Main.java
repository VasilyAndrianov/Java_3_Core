package Home_work_1.task_3;

public class Main {
    public static void main(String[] args) {
        fruitBox();
    }
    public static void fruitBox(){
        Box<Apple> boxAp1 = new Box<>(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        Box<Apple> boxAp2 = new Box<>();
        Box<Orange> boxOr1 = new Box<>(new Orange(), new Orange(), new Orange(), new Orange());
        Box<Orange> boxOr2 = new Box<>();
        System.out.println("Вес коробки с яблоками равен = " + boxAp1.getWeight() + " кг");
        System.out.println("Вес коробки с апельсинами равен = " + boxOr1.getWeight() + " кг");
        System.out.println("Масса пустой коробки ровна = " + boxOr2.getWeight() + " кг");
        System.out.println();
        if (boxAp1.compare(boxOr1)) {
            System.out.println("Вес коробок 1 и 2 равен");
        } else {
            System.out.println("Вес коробок 1 и 2 не равен");
        }
        System.out.println();
        boxOr1.transfer(boxOr2);
        System.out.println();
        System.out.println("коробка с яблоками №1 - " + boxAp1.getBox() + " шт");
        System.out.println("коробка с яблоками №2 - " + boxAp2.getBox() + " шт");
        System.out.println("коробка с апельсинами №1 - " + boxOr1.getBox() + " шт");
        System.out.println("коробка с апельсинами №2 - " + boxOr2.getBox() + " шт");


        boxAp2.addFruit(new Apple());
        System.out.println("коробка с яблоками №2 - " + boxAp2.getBox() + " шт");
    }
}
