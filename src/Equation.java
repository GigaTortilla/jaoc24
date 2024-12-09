import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Equation {
    Long target;
    List<Long> operands;
    List<List<Integer>> operators;
    List<BinaryOperator<Long>> operations = List.of(
            Long::sum,
            ( x, y) -> x * y,
            (x, y) -> Long.parseLong("%d%d".formatted(x, y))
    );

    public Equation(Long target, List<Long> operands, List<List<Integer>> operators) {
        this.target = target;
        this.operands = operands;
        this.operators = operators;
    }

    public List<Long> calculateResults() {
        List<Long> result = new ArrayList<>();
        for (List<Integer> opList : operators) {
            Long value = operands.getFirst();
            for (int i = 1; i < operands.size(); i++) {
                value = operations.get(opList.get(i - 1)).apply(value, operands.get(i));
            }
            result.add(value);
        }
        return result;
    }

    public boolean checkEquation(boolean doConcat) {
        return checkEquation(operands, 1, operands.getFirst(), target, doConcat);
    }

    public boolean checkEquation(
            List<Long> operands,
            int index,
            long currentResult,
            long targetResult,
            boolean doConcat) {
        if (index == operands.size()) return currentResult == targetResult;
        if (currentResult > targetResult) return false;
        long value = operands.get(index);
        return checkEquation(operands, index + 1, currentResult + value, targetResult, doConcat)
                || checkEquation(operands, index + 1, currentResult * value, targetResult, doConcat)
                || (doConcat && checkEquation(operands, index + 1, operations.get(2).apply(currentResult, value), targetResult, true));
    }
}
