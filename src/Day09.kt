fun List<Int>.checksum(): Long {
    var sum = 0L
    forEachIndexed { i, n -> if (n >= 0) sum += i * n }
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
        repeat((0 until blkStr[i].code - '0'.code).count()) {
            blkList += if (i % 2 == 0) i / 2 else -1
        }
    }
    return blkList
}

data class Block(val start: Int, val len: Int)

// automatically sorted by start index
fun List<Int>.getFreeBlocks(): MutableList<Block> {
    val blkList = mutableListOf<Block>()
    var i = 0
    while (i < this.size) if (this[i] == -1) {
        val blkLen = this.subList(i, this.size).indexOfFirst { it != -1 }
        blkList.add(Block(i, blkLen))
        i += blkLen
    }
    else i++
    return blkList
}

// map of FileID to the block by start and length
fun List<Int>.getUsedBlocks(): MutableMap<Int, Block> {
    val usedBlocks: MutableMap<Int, Block> = mutableMapOf()
    val blkLoc = this.mapIndexed { _, v -> v to this.indexOfFirst { it == v } }.toMap().filter { it.key >= 0 }
    val blkLen = this.groupingBy { it }.eachCount().filter { it.key >= 0 }
    for (entry in blkLoc) blkLen[entry.key]?.let { Block(entry.value, it) }?.let { usedBlocks.put(entry.key, it) }
    return usedBlocks.toSortedMap().toMutableMap()
}

fun MutableMap<Int, Block>.moveIntoSpaces(spaces: MutableList<Block>): MutableMap<Int, Block> {
    this.keys.reversed().forEach { id ->
        val file = getOrDefault(id, Block(0, 0))
        for (i in spaces.indices) {
            val space = spaces[i]
            if ((file.len <= space.len) && (file.start > space.start)) {
                this[id] = Block(space.start, file.len)
                spaces[i] = Block(space.start + file.len, space.len - file.len)
                break
            }
        }
    }
    return this
}

fun MutableMap<Int, Block>.rebuildDisk(): List<Int> {
    val lastBlk = this.values.maxBy { it.start }
    val diskMap = MutableList(lastBlk.start + lastBlk.len) { -1 }
    this.forEach { (id, blk) -> for (i in blk.start until blk.start + blk.len) diskMap[i] = id }
    return diskMap
}