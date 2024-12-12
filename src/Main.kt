import java.io.File

fun main() {


    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    val startTime = System.nanoTime()

    val solution01 = Day01("inputs/day01.txt")
    println("The solution01 for " + solution01.javaClass.name + " part 1 is " + solution01.part1())
    println("The solution01 for " + solution01.javaClass.name + " part 2 is " + solution01.part2())

    val solution02 = Day02("inputs/day02.txt")
    println("The solution for " + solution02.javaClass.name + " part 1 is " + solution02.part1())
    println("The solution for " + solution02.javaClass.name + " part 2 is " + solution02.part2())

    val solution03 = Day03("inputs/day03.txt")
    println("The solution for " + solution03.javaClass.name + " part 1 is " + solution03.part1())
    println("The solution for " + solution03.javaClass.name + " part 2 is " + solution03.part2())

    val solution04 = Day04("inputs/day04.txt")
    println("The solution for " + solution04.javaClass.name + " part 1 is " + solution04.part1())
    println("The solution for " + solution04.javaClass.name + " part 2 is " + solution04.part2())
/*
    val solution05 = Day05("inputs/day05.txt")
    println("The solution for " + solution05.javaClass.name + " part 1 is " + solution05.part1())
    println("The solution for " + solution05.javaClass.name + " part 2 is " + solution05.part2())

    val solution06 = Day06("inputs/day06.txt")
    println("The solution for " + solution06.javaClass.name + " part 1 is " + solution06.part1())
    println("The solution for " + solution06.javaClass.name + " part 2 is " + solution06.part2())

    val solution07 = Day07("inputs/day07.txt")
    println(
        ("The solution for " + solution07.javaClass.name
                + " part 1 is " + solution07.part1recursive())
    )
    println(
        ("The solution for " + solution07.javaClass.name
                + " part 2 is " + solution07.part2recursive())
    )

    val solution08 = Day08("inputs/day08.txt")
    println("The solution for " + solution08.javaClass.name + " part 1 is " + solution08.part1())
    println("The solution for " + solution08.javaClass.name + " part 2 is " + solution08.part2())
*/
    day9()

    val endTime = System.nanoTime()
    println("Completed in " + (endTime - startTime) / 1000000 + "ms")
}

fun day9() {
    val diskMap = expandBlocks(File("inputs/day09.txt").readText())
    diskMap.reorder()
    val diskSize = diskMap.size * 4 / 1024
    val filesystemChecksum = diskMap.checksum()
    println("d9p1 | Disk size after compression: $diskSize kB")
    println("d9p1 | File system checksum: $filesystemChecksum")

    // test case
    val expandedMap = expandBlocks("2333133121414131402")
    val freeSpaces = expandedMap.getFreeBlocks()
    val usedBlocks = expandedMap.getUsedBlocks()
    val testDisk = usedBlocks.moveIntoSpaces(freeSpaces).rebuildDisk()
    assert(testDisk.checksum() == 2858L)

    // part 2
    val diskMap2 = expandBlocks(File("inputs/day09.txt").readText())
    val freeSpaces2 = diskMap2.getFreeBlocks()
    val usedBlocks2 = diskMap2.getUsedBlocks()
    val sortedDiskMap2 = usedBlocks2.moveIntoSpaces(freeSpaces2).rebuildDisk()
    val diskSize2 = sortedDiskMap2.size * 4 / 1024
    val sumPart2 = sortedDiskMap2.checksum()
    println("d9p2 | Disk size after compression: $diskSize2 kB")
    println("d9p2 | File system checksum: $sumPart2")
}

fun Any?.println() = println(this)