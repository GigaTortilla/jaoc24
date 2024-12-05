import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day04 extends AoC {
    private final List<String> lines = new ArrayList<>();
    private final String searchString = "XMAS";
    private final String reverseSearchString = new StringBuilder(searchString).reverse().toString();

    Day04(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(new File(filePath));
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
    }

    // X
    //  M
    //   A
    //    S
    private String diagonalWord(int line, int pos) throws IndexOutOfBoundsException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchString.length(); i++) {
            sb.append(lines.get(line + i).charAt(pos + i));
        }
        return sb.toString();
    }

    //    X
    //   M
    //  A
    // S
    private String reverseDiagonalWord(int line, int pos) throws IndexOutOfBoundsException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchString.length(); i++) {
            sb.append(lines.get(line + i).charAt(pos - i + searchString.length() - 1));
        }
        return sb.toString();
    }

    // X
    // M
    // A
    // S
    private String verticalWord(int line, int pos) throws IndexOutOfBoundsException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchString.length(); i++) {
            sb.append(lines.get(line + i).charAt(pos));
        }
        return sb.toString();
    }

    public int part1() {
        int count = 0;
        // search vertical and horizontal words separately to include the border
        for (int i = 0; i < lines.size() - (searchString.length() - 1); i++) {
            for (int j = 0; j < lines.get(i).length() - (searchString.length() - 1); j++) {
                String dWord = diagonalWord(i, j);
                String rdWord = reverseDiagonalWord(i, j);
                if (searchString.equals(dWord) || reverseSearchString.equals(dWord)) count++;
                if (searchString.equals(rdWord) || reverseSearchString.equals(rdWord)) count++;
            }

            for (int j = 0; j < lines.get(i).length(); j++) {
                String vWord = verticalWord(i, j);
                if (searchString.equals(vWord) || reverseSearchString.equals(vWord)) count++;
            }
        }

        for (String line : lines) {
            for (int j = 0; j < line.length() - (searchString.length() - 1); j++) {
                String hWord = line.substring(j, j + searchString.length());
                if (searchString.equals(hWord) || reverseSearchString.equals(hWord)) count++;
            }
        }

        return count;
    }

    public int part2() {
        return 0;
    }
}