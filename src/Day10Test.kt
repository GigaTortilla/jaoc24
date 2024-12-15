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
     fun sumOfPeaks() {
         assertEquals(36, testCase.getScores())
     }

     @Test
     fun checkDistinctPaths() {
         assertEquals(20, testCase.getDistinctPathCount(2, 0))
         assertEquals(24, testCase.getDistinctPathCount(4, 0))
         assertEquals(10, testCase.getDistinctPathCount(4, 2))
         assertEquals(4, testCase.getDistinctPathCount(6, 4))
         assertEquals(1, testCase.getDistinctPathCount(2, 5))
         assertEquals(4, testCase.getDistinctPathCount(5, 5))
         assertEquals(5, testCase.getDistinctPathCount(0, 6))
         assertEquals(8, testCase.getDistinctPathCount(6, 6))
         assertEquals(5, testCase.getDistinctPathCount(1, 7))
     }

     @Test
     fun sumOfPaths() {
         assertEquals(81, testCase.getScores(true))
     }
 }