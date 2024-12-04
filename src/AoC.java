import java.io.File;
import java.io.FileNotFoundException;

public class AoC {
    protected File dayInput;

    AoC(String filePath) throws FileNotFoundException {
        dayInput = new File(filePath);

        if (!dayInput.exists()) {
            throw new FileNotFoundException("File not found: " + dayInput.getAbsolutePath());
        }
    }
}
