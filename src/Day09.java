import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class Day09 extends AoC {
    String testDisk = "2333133121414131402";
    String amphipodDisk;

    Day09(String filePath) throws FileNotFoundException {
        super(filePath);
        try {
            amphipodDisk = Files.readString(dayInput.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String expandBlocks(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int diskCode = Math.max(0, input.charAt(i) - '0');
            if (i % 2 == 0) output.append(String.valueOf(i / 2).repeat(diskCode));
            else output.append(".".repeat(diskCode));
        }
        return output.toString();
    }

    public int partOne() {
        System.out.println(expandBlocks(testDisk));
        return 0;
    }

    public int partTwo() {
        return 0;
    }
}
