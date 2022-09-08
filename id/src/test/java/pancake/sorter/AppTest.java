package pancake.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;


class AppTest {

    @Test
    void cantAddPancakeToFullPlate() {
        Plate plate = new Plate();
        for (int i = 1; i <= 25; i++) {
            Pancake p = new Pancake(i);
            plate.addPancake(p);
        }
        Pancake p = new Pancake(26);
        Boolean pancakeAdded = plate.addPancake(p);
        System.out.println(plate.pancakes);
        assertEquals(false, pancakeAdded);
    }

    @Test
    void cantAddSameSizePancakeToPlate() {
        Plate plate = new Plate();
        Pancake p1 = new Pancake(1);
        Pancake p2 = new Pancake(1);
        plate.addPancake(p1);
        Boolean pancakeAdded = plate.addPancake(p2);
        assertEquals(false, pancakeAdded);
    }

    @Test
    void pancakesSortCorrectly() {
        // prepare
        Plate plate = new Plate();
        for (int i = 1; i <= 25; i++) {
            Pancake p = new Pancake(i);
            plate.addPancake(p);
        }
        Collections.shuffle(plate.pancakes);

        // sort
        plate.print();
        plate.sort();
        plate.print();

        // check
        int previous = -1;
        boolean success = true;

        for (int i = 0; i < plate.pancakes.size(); i++){
            int currentSize = plate.pancakes.get(i).diameter;

            if (currentSize < previous){
                success = false;
                break;
            }

            previous = currentSize;
        }

        assertEquals(true, success);
    }
    
}
