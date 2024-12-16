import org.junit.Test
import org.junit.jupiter.api.Assertions.*

 class Day11Test {
     private val testCase = Day11("inputs/day11test.txt")

     @Test
     fun checkParsing() {
         assertEquals(listOf(125L, 17L), testCase.stones)
     }

     @Test
     fun checkDigitSplit() {
         assertEquals(Pair(1L, 0L), testCase.digitSplit(10))
         assertEquals(Pair(20L, 24L), testCase.digitSplit(2024))
         assertEquals(Pair(999L, 117L), testCase.digitSplit(999117))
         assertEquals(Pair(777L, 0L), testCase.digitSplit(777000))
     }

     @Test
     fun testBlink() {
         testCase.blink()
         assertEquals(listOf(253000L, 1L, 7L), testCase.stones)
         testCase.blink()
         assertEquals(listOf(253L, 0L, 2024L, 14168L), testCase.stones)
         testCase.blink()
         assertEquals(listOf(512072L, 1L, 20L, 24L, 28676032L), testCase.stones)
         testCase.blink()
         assertEquals(listOf(512L, 72L, 2024L, 2L, 0L, 2, 4, 2867L, 6032L), testCase.stones)
         testCase.blink()
         assertEquals(listOf(1036288L, 7L, 2L, 20L, 24L, 4048L, 1L, 4048L, 8096L, 28L, 67L, 60L, 32L), testCase.stones)
         testCase.blink()
         assertEquals(listOf(
             2097446912L,
             14168L,
             4048L,
             2L, 0L,
             2L, 4L,
             40L, 48L,
             2024L,
             40L, 48L,
             80L, 96L,
             2L, 8L,
             6L, 7L,
             6L, 0L,
             3L, 2L), testCase.stones)
     }

     @Test
     fun checkNumOfStones() {
         (1..6).forEach { _ -> testCase.blink() }
         assertEquals(22, testCase.stones.size)
         (7..25).forEach { _ -> testCase.blink() }
         assertEquals(55312, testCase.stones.size)
     }
 }