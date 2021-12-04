package counter;

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
}
