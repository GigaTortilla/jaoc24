import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day07 extends AoC {

    List<Equation> equations = new ArrayList<>();
    List<Equation> eqWithConcat = new ArrayList<>();

    Day07(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(dayInput);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(": ");
            equations.add(equationFromLine(line, 2));
            eqWithConcat.add(equationFromLine(line, 3));
        }
        sc.close();
    }

    private Equation equationFromLine(String[] line, int base) {
        long result = Long.parseLong(line[0]);
        List<Long> values = Arrays.stream(line[1].split(" ")).map(Long::parseLong).collect(Collectors.toList());
        List<List<Integer>> operators = new ArrayList<>();
        for (int i = 0; i < Math.pow(base, values.size() - 1); i++) {
            List<Integer> operator = new ArrayList<>();
            int num = i;
            for (int j = 0; j < values.size() - 1; j++) {
                operator.add(num % base);
                num /= base;
            }
            operators.add(operator);
        }
        return (new Equation(result, values, operators));
    }

    public long part1() {
        return equations.stream()
                .filter(equation -> equation.calculateResults().contains(equation.target))
                .mapToLong(equation -> equation.target).sum();
    }

    public long part1recursive() {
        return equations.stream()
                .filter(equation -> equation.checkEquation(false))
                .mapToLong(equation -> equation.target).sum();
    }

    public long part2() {
        return eqWithConcat.stream()
                .filter(equation -> equation.calculateResults().contains(equation.target))
                .mapToLong(equation -> equation.target).sum();
    }

    public long part2recursive() {
        long sum = 0;
        for (Equation equation : equations) {
            if (equation.checkEquation(true))
                sum += equation.target;
        }
        return sum;
    }
}
