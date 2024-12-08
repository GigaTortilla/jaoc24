import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Day07 extends AoC {
    List<BinaryOperator<Long>> operators = List.of(
            Long::sum,
            ( x, y) -> x * y
    );
    List<List<Long>> operands = new ArrayList<>();
    List<Long> solutions = new ArrayList<>();

    Day07(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(dayInput);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(":");
            solutions.add(Long.parseLong(line[0]));

            String[] numbers = line[1].trim().split(" ");
            List<Long> numList = Arrays.stream(numbers).map(Long::parseLong).collect(Collectors.toList());
            operands.add(numList);
        }
        sc.close();
    }

    private List<Long> calculateResults(
            List<Long> remainingOperands,
            List<BinaryOperator<Long>> operators,
            List<Long> results,
            List<Boolean> concatUsed) {
        // base case: no operands to add or multiply
        if (remainingOperands.isEmpty()) {
            return results;
        }
        List<Long> operands = new ArrayList<>(remainingOperands);
        if (results.isEmpty()) {
            results.add(operands.getFirst());
            concatUsed.add(false);
            operands.removeFirst();
            return calculateResults(operands, operators, results, concatUsed);
        } else {
            List<Long> newResults = new ArrayList<>();
            List<Boolean> newConcatUsed = new ArrayList<>();
            Long rightOperand = operands.getFirst();
            for (int i = 0; i < operands.size(); i++) {
                for (int j = 0; j < operators.size(); j++) {
                    if (j != 3 || !concatUsed.get(i)) {
                        newResults.add(operators.get(j).apply(operands.get(i), rightOperand));
                    }
                    newConcatUsed.add(3 == j);
                }
            }
            operands.removeFirst();
            return calculateResults(operands, operators, newResults, newConcatUsed);
        }
    }


    private List<Long> calculateResults(
            List<Long> remainingOperands,
            List<BinaryOperator<Long>> operators,
            List<Long> results) {
        // base case: no operands to add or multiply
        if (remainingOperands.isEmpty()) {
            return results;
        }
        List<Long> operands = new ArrayList<>(remainingOperands);
        if (results.isEmpty()) {
            results.add(operands.getFirst());
            operands.removeFirst();
            return calculateResults(operands, operators, results);
        } else {
            List<Long> newResults = new ArrayList<>();
            Long rightOperand = operands.getFirst();
            for (Long leftOperand : results) {
                for (BinaryOperator<Long> operator : operators) {
                    newResults.add(operator.apply(rightOperand, leftOperand));
                }
            }
            operands.removeFirst();
            return calculateResults(operands, operators, newResults);
        }
    }

    public long partOne() {
        long sum = 0;
        for (int i = 0; i < solutions.size(); i++) {
            if (calculateResults(operands.get(i), operators, new ArrayList<>()).contains(solutions.get(i))) {
                sum += solutions.get(i);
            }
        }
        return sum;
    }

    public long partTwo() {
        long sum = 0;
        List<BinaryOperator<Long>> opWithConcat = new ArrayList<>(operators);
        opWithConcat.add((x, y) -> Long.parseLong(x + Long.toString(y)));
        for (int i = 0; i < solutions.size(); i++) {
            if (calculateResults(operands.get(i), opWithConcat, new ArrayList<>(), new ArrayList<>()).contains(solutions.get(i))) {
                sum += solutions.get(i);
            }
        }
        return sum;
    }
}
