import java.io.File

class Day11(filepath: String) {
    val stones: MutableList<Long>

    init {
        stones = parse(filepath)
    }

    private fun parse(filepath: String): MutableList<Long> = File(filepath)
        .readText(Charsets.UTF_8)
        .split(" ")
        .map { it.toLong() }
        .toMutableList()

    fun digitSplit(x: Long): Pair<Long, Long> {
        val s = x.toString()
        return Pair(s.substring(0, s.length / 2).toLong(), s.substring(s.length / 2).toLong())
    }

    fun blink() {
        val newStones: MutableList<Long> = mutableListOf()
        val toAdd: MutableList<Pair<Int, Long>> = mutableListOf()
        newStones.addAll(stones)
        for ((i, stone) in stones.withIndex()) when {
            stone == 0L -> newStones[i] = 1
            stone.toString().length % 2 == 0 -> {
                val nextTwoStones = digitSplit(stone)
                newStones[i] = nextTwoStones.first
                toAdd.add((i + 1 + toAdd.size) to nextTwoStones.second)
            }
            else -> newStones[i] = stone * 2024
        }
        stones.clear()
        stones.addAll(newStones)
        toAdd.forEach { (i, stone) -> stones.add(i, stone) }
    }
}