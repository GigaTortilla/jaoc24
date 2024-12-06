import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day05 extends AoC {
    private final List<List<String>> rules = new ArrayList<>();
    private final List<String> printingUpdates = new ArrayList<>();

    Day05(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(dayInput);
        boolean emptyLineEncountered = false;
        while (sc.hasNextLine()) if (!emptyLineEncountered) {
            String s = sc.nextLine();
            if (s.isEmpty()) emptyLineEncountered = true;
            else rules.add(List.of(s.split("\\|")));
        } else {
            printingUpdates.add(sc.nextLine());
        }
        sc.close();
    }

    private boolean checkRules(String update) {
        if (update.isEmpty()) return true;

        List<String> pages = List.of(update.split(","));
        for (List<String> rule : rules) {
            if (!pages.contains(rule.get(0)) || !pages.contains(rule.get(1))) continue;
            if (pages.indexOf(rule.get(0)) > pages.indexOf(rule.get(1))) return false;
        }

        return true;
    }

    public int part1() {
        int sum = 0;
        for (String update : printingUpdates) {
            if (checkRules(update)) {
                List<String> l = List.of(update.split(","));
                sum += Integer.parseInt(l.get(l.size() / 2));
            }
        }
        return sum;
    }

    public int part2() {
        return 0;
    }
}
