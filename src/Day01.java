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
        s.close();
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
        for (int num : left) {
            similarity += num * Collections.frequency(right, num);
        }
        return similarity;
    }
}
