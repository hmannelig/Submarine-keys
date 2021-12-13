package counter;

import java.util.ArrayList;
import java.util.List;

public class Counter {

    public Counter() {
    }

    public int countIncreases(List<Integer> values) {
        int counter = 0;
        int previous = values.get(0);
        for (Integer value : values.subList(1, values.size())) {
            int next = value;
            if (previous < value) {
                counter++;
            }
            previous = next;
        }
        return counter;
    }

    public int countMedianIncreases(List<Integer> values) {

        int increases = 0;
        int prev = values.get(0) + values.get(2) + values.get(3);
        for (int index = 1; index < values.size() - 2; ++index) {
            int next = values.get(index) + values.get(index + 1) + values.get(index + 2);
            increases += next > prev ? 1 : 0;
            prev = next;
        }

        return increases;
    }
}
