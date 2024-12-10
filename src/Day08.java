import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.*;

public class Day08 extends AoC {
    Map<Character, List<Point>> antennas = new HashMap<>();
    Map<Character, Integer> antennaCounts = new HashMap<>();
    int borderX = 0;
    int borderY = 0;

    Day08(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner sc = new Scanner(dayInput);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c != '.') {
                    antennaCounts.put(c, antennaCounts.containsKey(c) ? antennaCounts.get(c) + 1 : 1);
                    if (!antennas.containsKey(c)) antennas.put(c, new ArrayList<>());
                    antennas.get(c).add(new Point(i, borderY));
                }
            }
            borderX = line.length();
            borderY++;
        }
        sc.close();
    }

    private Point getAntinode(Point p1, Point p2) {
        return new Point(p2.x + (p2.x - p1.x), p2.y + (p2.y - p1.y));
    }

    private boolean checkBounds(Point p) {
        return p.x < borderX && p.x >= 0
                && p.y < borderY && p.y >= 0;
    }

    public int part1() {
        List<Point> antinodes = new ArrayList<>();
        for (char c : antennas.keySet()) {
            for (Point p1 : antennas.get(c)) {
                List<Point> points = new ArrayList<>(antennas.get(c));
                points.remove(p1);
                for (Point p2 : points) {
                    Point nextAntinode = getAntinode(p1, p2);
                    if (checkBounds(nextAntinode) && !antinodes.contains(nextAntinode)) antinodes.add(nextAntinode);
                }
            }
        }
        return antinodes.size();
    }

    public int part2() {
        return 0;
    }
}
