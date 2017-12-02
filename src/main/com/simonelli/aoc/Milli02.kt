package main.com.simonelli.aoc

class Milli02 {
    fun checksum1(input: String): Int {
        return input
                .split("\n")
                .map { it.split("\t").map { it.toInt() } }
                .map { it.max()!! - it.min()!! }
                .sum()
    }

    fun checksum2(input: String): Int{
         var checksum = 0
            input
                .split("\n")
                .map { it.split("\t").map { it.toInt() } }
                 .forEach { row ->
                     for (num in row)
                     {
                         checksum += row.filter { num != it }.filter { num % it == 0 }.map { num / it }.getOrElse(0, {0})
                     }
                 }

        return checksum
    }
}

fun main(args: Array<String>) {
    val milli02 = Milli02()
    val puzzleInput = FileReader().getPuzzleInput("src/main/resources/input/milli02.txt")
    val checksum1 = milli02.checksum1(puzzleInput)
    val checksum2 = milli02.checksum2(puzzleInput)
    println("checksum1 = $checksum1")
    println("checksum2 = $checksum2")
}