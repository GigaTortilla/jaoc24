import java.io.FileNotFoundException;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Day01 solution = new Day01("inputs/day01.txt");
        System.out.println("The solution for " + solution.getClass().getName() + " part 1 is " + solution.part1());
        System.out.println("The solution for " + solution.getClass().getName() + " part 2 is " + solution.part2());
    }
}