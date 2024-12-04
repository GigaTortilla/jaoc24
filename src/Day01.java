import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day01 extends AoC {
    private final List<Integer> left = new ArrayList<Integer>();
    private final List<Integer> right = new ArrayList<Integer>();

    Day01(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner s = new Scanner(dayInput);
        while (s.hasNext()) {
            left.add(s.nextInt());
            right.add(s.nextInt());
        }
        Collections.sort(left);
        Collections.sort(right);
    }

    public int part1() {
        int sum = 0;
        for (int i = 0; i < left.size(); i++) {
            sum += Math.abs(left.get(i) - right.get(i));
        }
        return sum;
    }

    public int part2() {
        int similarity = 0;
        // TODO: calculate similarity value
        return similarity;
    }

    public List<Integer> getLeftList() {
        return left;
    }

    public List<Integer> getRightList() {
        return right;
    }
}
