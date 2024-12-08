import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day06 extends AoC {
    Guard patrolGuard;
    int borderEast = 0;
    int borderSouth;
    List<Point> obstacles = new ArrayList<>();

    Day06(String filePath) throws FileNotFoundException {
        super(filePath);
        Scanner s = new Scanner(dayInput);
        int lineNumber = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            borderEast = line.length();
            // multiple obstacles per line are possible
            int obstacleIndex = line.indexOf("#");
            while (obstacleIndex != -1) {
                obstacles.add(new Point(obstacleIndex, lineNumber));
                obstacleIndex = line.indexOf("#", obstacleIndex + 1);
            }
            // only one guard can be found in the map
            // hard-coded direction because it always starts with up
            int guardIndex = line.indexOf("^");
            if (guardIndex != -1) {
                patrolGuard = new Guard(new Point(guardIndex, lineNumber), new Point(0, -1));
            }
            lineNumber++;
        }
        borderSouth = lineNumber;
    }

    public int partOne() {
        List<Point> visitedPositions = new ArrayList<>();
        visitedPositions.add(new Point(patrolGuard.getPosition()));
        Point nextPosition = patrolGuard.getNextPosition();
        while (nextPosition.x < borderEast && nextPosition.y < borderSouth
        && nextPosition.x >= 0 && nextPosition.y >= 0) {
            if (obstacles.contains(nextPosition)) {
                patrolGuard.rotateRight();
            } else {
                patrolGuard.move();
                if (!visitedPositions.contains(nextPosition)) {
                    visitedPositions.add(new Point(nextPosition));
                }
            }
            nextPosition = patrolGuard.getNextPosition();
        }
        return visitedPositions.size();
    }

    public int partTwo() {
        return 0;
    }
}
