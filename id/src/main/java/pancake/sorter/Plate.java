package pancake.sorter;

import java.util.ArrayList;
import java.util.List;

public class Plate {
    List<Pancake> pancakes = new ArrayList<Pancake>();
    final int maximumPancakes = 25;

    public Plate(){
    }

    public Plate(List<Pancake> pancakes){
        if (pancakes.size() <= maximumPancakes){
            this.pancakes = pancakes;
        }
    }

    public boolean addPancake(Pancake pancake){
        if (pancakeWithDiameterNew(pancake.diameter) && roomForMorePancake()){
            return this.pancakes.add(pancake);
        }
        return false;
    }

    public void sort(){
        // todo sort
    }

    private boolean pancakeWithDiameterNew(int diameter){
        for (int i = 0; i < this.pancakes.size(); i++){
            int d = this.pancakes.get(i).diameter;
            if (d == diameter) return false;
        }
        return true;
    }

    private boolean roomForMorePancake(){
        return this.pancakes.size() < this.maximumPancakes;
    }

}
