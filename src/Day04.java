import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day04 extends AoC {
    private final String puzzle;
    private int cols;
    private final String searchString = "XMAS";

    Day04(String filePath) throws FileNotFoundException {
        super(filePath);
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(dayInput);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            cols = line.length();
            sb.append(line);
        }
        puzzle = sb.toString();
    }

    private String diagonalWord(int pos) {
        int remainingLength = puzzle.length() - pos;
        if (remainingLength <= (searchString.length() - 1) * cols + searchString.length() - 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchString.length(); i++) {
            sb.append(puzzle.charAt(pos + (i + i * cols)));
        }
        return sb.toString();
    }

    public int part1() {
        int count = 0;
        for (int i = 0; i < puzzle.length(); i++) {
            System.out.println(diagonalWord(i));
        }
        return count;
    }

    public int part2() {
        return 0;
    }
}