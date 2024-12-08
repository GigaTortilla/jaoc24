import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day07 extends AoC {
    List<List<Long>> ooperands = new ArrayList<>();
    List<Long> solutions = new ArrayList<>();

    Day07(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(dayInput);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(":");
            solutions.add(Long.parseLong(line[0]));
            List<Long> numList = new ArrayList<>();
            for (String n : line[1].trim().split(" ")) {
                numList.add(Long.parseLong(n));
            }
            ooperands.add(numList);
        }
        sc.close();
    }

    private List<Long> calculateResults(List<Long> remainingOperands, List<Long> results) {
        if (remainingOperands.isEmpty()) {
            return results;
        }

        if (results.isEmpty()) {
            results.add(remainingOperands.getFirst());
            remainingOperands.removeFirst();
            return calculateResults(remainingOperands, results);
        } else {
            List<Long> newResults = new ArrayList<>();
            Long rightOperand = remainingOperands.getFirst();
            for (Long leftOperand : results) {
                newResults.add(leftOperand + rightOperand);
                newResults.add(leftOperand * rightOperand);
            }
            remainingOperands.removeFirst();
            return calculateResults(remainingOperands, newResults);
        }
    }

    public long partOne() {
        long sum = 0;
        for (int i = 0; i < solutions.size(); i++) {
            if (calculateResults(ooperands.get(i), new ArrayList<>()).contains(solutions.get(i))) {
                sum += solutions.get(i);
            }
        }
        return sum;
    }

    public int partTwo() {
        return 0;
    }
}
