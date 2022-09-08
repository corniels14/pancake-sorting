package pancake.sorter;

import java.util.ArrayList;
import java.util.Collections;
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
        for (int curr_size = this.pancakes.size(); curr_size > 1; --curr_size){
            int biggest_index = findBiggestPancake(curr_size);

            if (biggest_index != curr_size-1){
                flip(biggest_index+1);
                flip(curr_size);
            }
        }
    }

    private void flip(int i){
        List<Pancake> stack = this.pancakes.subList(0, i);
        Collections.reverse(stack);
        for (int j = 0; j < stack.size(); j++) {
            this.pancakes.set(j, stack.get(j));
        }
    }

    private int findBiggestPancake(int i){
        int max, j;
        for (max = 0, j = 0; j < i; ++j)
            if (this.pancakes.get(j).diameter > this.pancakes.get(max).diameter)
                max = j;
        return max;
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

    public void print(){
        for (int i = 0; i < this.pancakes.size(); i++) {
            System.out.printf("%d ", this.pancakes.get(i).diameter);
        }
        System.out.println("");
    }

}
