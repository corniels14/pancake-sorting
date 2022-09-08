package pancake.sorter;

import java.util.ArrayList;
import java.util.List;

public class Plate {
    List<Pancake> pancakes = new ArrayList<Pancake>();
    final int maximumPancakes = 25;

    public Plate(){
    }

    public Plate(List<Pancake> pancakes){
        // todo check
        this.pancakes = pancakes;
    }

    public boolean addPancake(Pancake pancake){
        // todo check
        return this.pancakes.add(pancake);
    }

    public void sort(){
        // todo sort
    }

}
