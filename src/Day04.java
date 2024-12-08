import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day04 extends AoC {
    private final List<String> lines = new ArrayList<>();
    private final String searchString;
    private final String reverseSearchString;

    Day04(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(dayInput);
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        sc.close();
        searchString = "XMAS";
        reverseSearchString = new StringBuilder(searchString).reverse().toString();
    }

    // X
    //  M
    //   A
    //    S
    private String diagonalWord(int line, int pos, int length) throws IndexOutOfBoundsException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(lines.get(line + i).charAt(pos + i));
        }
        return sb.toString();
    }

    //    X(0)
    //   M(1)
    //  A(2)
    // S(3)
    private String reverseDiagonalWord(int line, int pos, int length) throws IndexOutOfBoundsException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(lines.get(line + i).charAt(pos - i + length - 1));
        }
        return sb.toString();
    }

    // X
    // M
    // A
    // S
    private String verticalWord(int line, int pos, int length) throws IndexOutOfBoundsException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(lines.get(line + i).charAt(pos));
        }
        return sb.toString();
    }

    public int part1() {
        int count = 0;
        // search until border for the diagonal words
        for (int i = 0; i < lines.size() - (searchString.length() - 1); i++) {
            for (int j = 0; j < lines.get(i).length() - (searchString.length() - 1); j++) {
                String dWord = diagonalWord(i, j, searchString.length());
                String rdWord = reverseDiagonalWord(i, j, searchString.length());
                String vWord = verticalWord(i, j, searchString.length());
                String hWord = lines.get(i).substring(j, j + searchString.length());
                if (searchString.equals(dWord) || reverseSearchString.equals(dWord)) count++;
                if (searchString.equals(rdWord) || reverseSearchString.equals(rdWord)) count++;
                if (searchString.equals(vWord) || reverseSearchString.equals(vWord)) count++;
                if (searchString.equals(hWord) || reverseSearchString.equals(hWord)) count++;
            }

            // search right border for vertical words only
            for (int j = lines.get(i).length() - (searchString.length() - 1); j < lines.get(i).length(); j++) {
                String vWord = verticalWord(i, j, searchString.length());
                if (searchString.equals(vWord) || reverseSearchString.equals(vWord)) count++;
            }
        }

        // search bottom border for horizontal words
        for (int i = lines.size() - (searchString.length() - 1); i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length() - (searchString.length() - 1); j++) {
                String hWord = lines.get(i).substring(j, j + searchString.length());
                if (searchString.equals(hWord) || reverseSearchString.equals(hWord)) count++;
            }
        }

        return count;
    }

    // M S
    //  A
    // M S
    public int part2() {
        int count = 0;
        String fwd = "MAS";
        String bwd = new StringBuilder(fwd).reverse().toString();
        for (int i = 0; i < lines.size() - (fwd.length() - 1); i++) {
            for (int j = 0; j < lines.get(i).length() - (fwd.length() - 1); j++) {
                String dWord = diagonalWord(i, j, fwd.length());
                String rdWord = reverseDiagonalWord(i, j, fwd.length());
                if ((dWord.equals(fwd) || dWord.equals(bwd)) && (rdWord.equals(fwd) || rdWord.equals(bwd))) count++;
            }
        }
        return count;
    }
}