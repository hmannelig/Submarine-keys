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

    public static Movement convertToMovement(List<String> values) {
        Movement moves = new Movement();

        for (String s : values) {
            String[] move = s.split(" ");
            moves.addInstruction(move[0], move[1]);
        }

        return moves;
    }
}
