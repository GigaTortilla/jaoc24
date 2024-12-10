fun List<Int>.checksum(): Long {
    var sum = 0L
    forEachIndexed { i, n -> sum += i * n }
    return sum
}

fun List<Int>.emptyBlock(): Boolean = this.last() == -1

fun MutableList<Int>.reorder(): List<Int> {
    while (this.contains(-1)) if (this.emptyBlock()) this.removeLast()
    else {
        this[this.indexOfFirst { it == -1 }] = this.last()
        this.removeLast()
    }
    return this
}

fun expandBlocks(blkStr: String): MutableList<Int> {
    val blkList = mutableListOf<Int>()
    blkStr.indices.forEach { i ->
        repeat((0..<blkStr[i].code - '0'.code).count()) {
            blkList += if (i % 2 == 0) i / 2 else -1
        }
    }
    return blkList
}