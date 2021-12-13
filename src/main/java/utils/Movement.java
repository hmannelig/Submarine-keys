package utils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
@Getter
@Setter
public class Movement {

    private ArrayList<String> direction;
    private ArrayList<Integer> distance;

    public Movement() {
        direction = new ArrayList<>();
        distance = new ArrayList<>();
    }

    public void addInstruction(String dir, Integer dis) {
        this.direction.add(dir);
        this.distance.add(dis);
    }

    public void addInstruction(String dir, String dis) {
        this.direction.add(dir);
        this.distance.add(Integer.valueOf(dis));
    }

    public int getMovement(int index) {
        return this.direction.get(index).equals("up") ? -this.distance.get(index) : this.distance.get(index);
    }

    public void clearMovements() {
        this.direction.clear();
        this.distance.clear();
    }

    public int getMovementMultiplied() {

        int h = 0, v = 0;
        for (int index = 0; index < this.distance.size(); index++) {
            if(this.direction.get(index).equals("forward")) {
                h += this.getMovement(index);
            } else {
                v += this.getMovement(index);
            }
        }
        return h * v;
    }

    public int getMovementMultipliedWithAim() {

        int h = 0, v = 0, a = 0;
        for (int index = 0; index < this.distance.size(); index++) {

            int input = this.getMovement(index);
            if(this.direction.get(index).equals("forward")) {
                h += input;
                v += input*a;
            } else {
                a += input;
            }
        }
        return h * v;
    }
}
