import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends AoC {
    private final String content;
    Day03(String filePath) throws FileNotFoundException {
        super(filePath);

        // read complete file at once due to small size of ~20KB
        try {
            content = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int part1() {
        int sum = 0;

        Matcher mInstruction = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)").matcher(content);
        while (mInstruction.find()) {
            sum += Integer.parseInt(mInstruction.group(1)) * Integer.parseInt(mInstruction.group(2));
        }

        return sum;
    }

    public int part2() {
        int sum = 0;
        boolean enabled = true;
        Matcher m = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)").matcher(content);
        while (m.find()) {
            if (m.group().equals("don't()")) {
                enabled = false;
            } else if (m.group().equals("do()")) {
                enabled = true;
            } else {
                if (m.groupCount() > 1 && enabled) {
                    sum += Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2));
                }
            }
        }
        return sum;
    }
}
