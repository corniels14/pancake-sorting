package pancake.sorter;

import java.util.ArrayList;
import java.util.List;

public class Plate {
    List<Pancake> pancakes = new ArrayList<Pancake>();
    final int maximumPancakes = 25;

    public Plate(){
    }

    public Plate(List<Pancake> pancakes){
        this.pancakes = pancakes;
    }

    public boolean addPancake(Pancake pancake){
        return this.pancakes.add(pancake);
    }

}
