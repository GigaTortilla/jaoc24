import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Day01 solution01 = new Day01("inputs/day01.txt");
        System.out.println("The solution01 for " + solution01.getClass().getName() + " part 1 is " + solution01.part1());
        System.out.println("The solution01 for " + solution01.getClass().getName() + " part 2 is " + solution01.part2());

        Day02 solution02 = new Day02("inputs/day02.txt");
    }
}