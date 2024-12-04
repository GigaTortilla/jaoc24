import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day02 extends AoC {
    List<List<Integer>> reports = new ArrayList<List<Integer>>();

    Day02(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(new File(filePath));
        while (sc.hasNextLine()) {
            List<Integer> l = new ArrayList<Integer>();
            String line = sc.nextLine();
            for (String s : line.split(" ")) {
                l.add(Integer.parseInt(s));
            }
            reports.add(l);
        }
        sc.close();
        System.out.println(reports);
    }
}
