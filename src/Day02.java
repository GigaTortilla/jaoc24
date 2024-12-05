import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class Day02 extends AoC {
    List<List<Integer>> reports = new ArrayList<>();

    Day02(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(dayInput);
        while (sc.hasNextLine()) {
            List<Integer> l = new ArrayList<>();
            String line = sc.nextLine();
            for (String s : line.split(" ")) {
                l.add(Integer.parseInt(s));
            }
            reports.add(l);
        }
        sc.close();
    }

    public int part1() {
        int safeReports = 0;
        for (List<Integer> report : reports) {
            if (isSafe(report)) {
                safeReports++;
            }
        }
        return safeReports;
    }

    public int part2() {
        int safeReports = 0;
        for (List<Integer> report : reports) {
            if (isSafe(report)) {
                safeReports++;
            } else {
                // TODO: find a better way than removing from the new list after adding contents of report
                for (int i = 0; i < report.size(); i++) {
                    List<Integer> modifiedReport = new ArrayList<>(report);
                    modifiedReport.remove(i);
                    if (isSafe(modifiedReport)) {
                        safeReports++;
                        break;
                    }
                }
            }
        }
        return safeReports;
    }

    protected boolean isSafe(List<Integer> report) {
        // Check if neighboring values are either identical or if the distance between them is too large
        for (int i = 0; i < report.size() - 1; i++) {
            if (report.get(i).equals(report.get(i + 1)) || Math.abs(report.get(i) - report.get(i + 1)) > 3) {
                return false;
            }
        }
        // Check for ascending or descending order
        // At this point the list does not contain adjacent elements with equal values
        // and the distance is also safe between elements
        boolean isAscending = IntStream.range(0, report.size() - 1).noneMatch(i -> report.get(i) > report.get(i + 1));
        boolean isDescending = IntStream.range(0, report.size() - 1).noneMatch(i -> report.get(i) < report.get(i + 1));
        return isAscending || isDescending;
    }
}
