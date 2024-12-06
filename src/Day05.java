import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day05 extends AoC {
    private final List<List<String>> rules = new ArrayList<>();
    private final List<String> printingUpdates = new ArrayList<>();
    private final List<String> wrongUpdates = new ArrayList<>();

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

    private boolean checkRules(List<String> pages) {
        if (pages.isEmpty()) return true;
        for (List<String> rule : rules) {
            if (!pages.contains(rule.get(0)) || !pages.contains(rule.get(1))) continue;
            if (pages.indexOf(rule.get(0)) > pages.indexOf(rule.get(1))) return false;
        }
        return true;
    }

    public int part1() {
        int sum = 0;
        for (String update : printingUpdates) {
            List<String> pages = List.of(update.split(","));
            if (checkRules(pages)) {
                List<String> l = List.of(update.split(","));
                sum += Integer.parseInt(l.get(l.size() / 2));
            } else {
                wrongUpdates.add(update);
            }
        }
        return sum;
    }

    public int part2() {
        int sum = 0;
        List<String> pages;
        if (wrongUpdates.isEmpty()) return sum;
        for (String wrongUpdate : wrongUpdates) {
            pages = new ArrayList<>(List.of(wrongUpdate.split(",")));
            do {
                for (List<String> rule : rules) {
                    if (!pages.contains(rule.get(0)) || !pages.contains(rule.get(1))) continue;
                    int leftIndex = pages.indexOf(rule.get(0));
                    int rightIndex = pages.indexOf(rule.get(1));
                    if (leftIndex > rightIndex) {
                        Collections.swap(pages, leftIndex, rightIndex);
                    }
                }
            } while (!checkRules(pages));
            sum += Integer.parseInt(pages.get(pages.size() / 2));
        }
        return sum;
    }
}