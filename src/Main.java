import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        long startTime = System.nanoTime();

        Day01 solution01 = new Day01("inputs/day01.txt");
        System.out.println("The solution01 for " + solution01.getClass().getName() + " part 1 is " + solution01.part1());
        System.out.println("The solution01 for " + solution01.getClass().getName() + " part 2 is " + solution01.part2());

        Day02 solution02 = new Day02("inputs/day02.txt");
        System.out.println("The solution for " + solution02.getClass().getName() + " part 1 is " + solution02.part1());
        System.out.println("The solution for " + solution02.getClass().getName() + " part 2 is " + solution02.part2());

        Day03 solution03 = new Day03("inputs/day03.txt");
        System.out.println("The solution for " + solution03.getClass().getName() + " part 1 is " + solution03.part1());
        System.out.println("The solution for " + solution03.getClass().getName() + " part 2 is " + solution03.part2());

        Day04 solution04 = new Day04("inputs/day04.txt");
        System.out.println("The solution for " + solution04.getClass().getName() + " part 1 is " + solution04.part1());
        System.out.println("The solution for " + solution04.getClass().getName() + " part 2 is " + solution04.part2());

        Day05 solution05 = new Day05("inputs/day05.txt");
        System.out.println("The solution for " + solution05.getClass().getName() + " part 1 is " + solution05.part1());
        System.out.println("The solution for " + solution05.getClass().getName() + " part 2 is " + solution05.part2());

        Day06 solution06 = new Day06("inputs/day06.txt");
        System.out.println("The solution for " + solution06.getClass().getName() + " part 1 is " + solution06.part1());
        System.out.println("The solution for " + solution06.getClass().getName() + " part 2 is " + solution06.part2());

        Day07 solution07 = new Day07("inputs/day07.txt");
        System.out.println("The solution for " + solution07.getClass().getName()
                + " part 1 is " + solution07.part1recursive());
        System.out.println("The solution for " + solution07.getClass().getName()
                + " part 2 is " + solution07.part2recursive());

        Day08 solution08 = new Day08("inputs/day08.txt");
        System.out.println("The solution for " + solution08.getClass().getName() + " part 1 is " + solution08.part1());
        System.out.println("The solution for " + solution08.getClass().getName() + " part 2 is " + solution08.part2());

        Day09 solution09 = new Day09("inputs/day09.txt");
        System.out.println("The solution for " + solution09.getClass().getName() + " part 1 is " + solution09.part1());
        System.out.println("The solution for " + solution09.getClass().getName() + " part 2 is " + solution09.part2());

        long endTime = System.nanoTime();
        System.out.println("Completed in " + (endTime - startTime) / 1000000 + "ms");
    }
}