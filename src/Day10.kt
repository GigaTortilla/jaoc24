import java.io.File

class Day10(filepath: String) {
    private val terrainMap: List<List<Int>>
    private val borderX: Int
    private val borderY: Int
    val peakBuffer: MutableList<Pair<Int, Int>> = mutableListOf()

    init {
        terrainMap = getTerrain(filepath)
        borderY = terrainMap.size
        borderX = terrainMap[0].size
    }

    private fun getTerrain(path: String): List<List<Int>> {
        val terrain: MutableList<List<Int>> = ArrayList()
        File(path).forEachLine { line ->
            val numLine = mutableListOf<Int>()
            line.forEach { c -> numLine.add(c.code - '0'.code) }
            terrain.add(numLine)
        }
        return terrain
    }

    fun getDistinctPathCount(x: Int, y: Int, value: Int = 0): Int {
        if (value == 9) return 1 else {
            val directions = getNextPos(x, y, value)
            if (directions.isEmpty()) return 0
            return directions.sumOf { (newX, newY) -> getDistinctPathCount(newX, newY, terrainMap[newY][newX]) }
        }
    }

    fun getPathCount(x: Int, y: Int, value: Int = 0): Int {
        if (value == 9) {
            if (peakBuffer.contains(x to y)) return 0
            peakBuffer.add(Pair(x, y))
            return 1
        } else {
            val directions = getNextPos(x, y, value)
            if (directions.isEmpty()) return 0
            return directions.sumOf { (newX, newY) -> getPathCount(newX, newY, terrainMap[newY][newX]) }
        }
    }

    private fun getNextPos(x: Int, y: Int, value: Int): List<Pair<Int, Int>> {
        val out = mutableListOf<Pair<Int, Int>>()
        val directions = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        for ((deltaX, deltaY) in directions) {
            if (x + deltaX < 0 || y + deltaY < 0 || x + deltaX >= borderX || y + deltaY >= borderY) continue
            if (value + 1 == terrainMap[y + deltaY][x + deltaX]) out.add(Pair(x + deltaX, y + deltaY))
        }
        return out
    }

    fun getScores(distinctPaths: Boolean = false): Int {
        var sum = 0
        terrainMap.forEachIndexed { y, row -> row.forEachIndexed { x, height ->
            if (height == 0) {
                if (distinctPaths) sum += getDistinctPathCount(x, y)
                else {
                    sum += getPathCount(x, y)
                    peakBuffer.clear()
                }
            }
        } }
        return sum
    }
}