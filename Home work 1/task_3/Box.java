package Home_work_1.task_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    public Box(T... fruit){
        box =  new ArrayList<>(Arrays.asList(fruit));
    }

    public int getBox() {
        return box.size();
    }


    public void addFruit( T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float wtFull = 0;
        for (int i = 0; i < box.size(); i++) {
            wtFull = wtFull += box.get(i).getWt();
        }
        return wtFull;
    }

    public boolean compare(Box<? extends Fruit> boxWithFruits){
        float f = 0.0f;
        return this.getWeight() == boxWithFruits.getWeight();
    }

    public void transfer(Box<T> emptyBox){
        emptyBox.box.addAll(this.box);
        box.clear();
    }



}
