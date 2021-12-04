package utils;

import java.util.List;
import java.util.stream.Collectors;

public class ListParser {

    public ListParser() {
    }

    public static List<Integer> convertToIntegerList(List<String> values) {
        return values.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
