import counter.Counter;
import reader.Reader;
import utils.ListParser;
import utils.Movement;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Reader reader = new Reader();

        String firstExerciseInputPath = "src/main/resources/input/submarine-keys-input.txt";
        String secondExerciseInputPath = "src/main/resources/input/submarine-movement-input.txt";

        firstExercise(counter, reader, firstExerciseInputPath);
        secondExercise(reader, secondExerciseInputPath);
    }

    private static void firstExercise(Counter counter, Reader reader, String path) {
        List<Integer> values = ListParser.convertToIntegerList(reader.readValues(path));

        System.out.println("First exercise solution: " + counter.countIncreases(values));
        System.out.println("First exercise solution with three-measurement windows: " + counter.countMedianIncreases(values));
    }

    private static void secondExercise(Reader reader, String path) {
        Movement move = ListParser.convertToMovement(reader.readValues(path));

        System.out.println("Second exercise solution: " + move.getMovementMultiplied());
        System.out.println("Second exercise solution with AIM: " + move.getMovementMultipliedWithAim());
    }
}
