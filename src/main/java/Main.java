import counter.Counter;
import reader.Reader;
import utils.ListParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Reader reader = new Reader();

        List<Integer> values = ListParser.convertToIntegerList(reader.readValues("src/main/resources/input/submarine-keys-input.txt"));

        System.out.println(counter.countIncreases(values));
    }
}
