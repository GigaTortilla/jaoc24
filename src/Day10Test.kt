import org.junit.Test
import org.junit.jupiter.api.Assertions.*

 class Day10Test {
     private val testCase = Day10("inputs/day10test.txt")

     @Test
     fun checkTrailheadPaths() {
         assertEquals(5, testCase.getPathCount(2, 0, 0))
         testCase.peakBuffer.clear()
         assertEquals(6, testCase.getPathCount(4, 0, 0))
         testCase.peakBuffer.clear()
         assertEquals(5, testCase.getPathCount(4, 2))
         testCase.peakBuffer.clear()
         assertEquals(3, testCase.getPathCount(6, 4))
         testCase.peakBuffer.clear()
         assertEquals(1, testCase.getPathCount(2, 5))
         testCase.peakBuffer.clear()
         assertEquals(3, testCase.getPathCount(5, 5))
         testCase.peakBuffer.clear()
         assertEquals(5, testCase.getPathCount(0, 6))
         testCase.peakBuffer.clear()
         assertEquals(3, testCase.getPathCount(6, 6))
         testCase.peakBuffer.clear()
         assertEquals(5, testCase.getPathCount(1, 7))
         testCase.peakBuffer.clear()
     }

     @Test
     fun checkSumOfPeaks() {
         assertEquals(36, testCase.getScores())
     }
 }