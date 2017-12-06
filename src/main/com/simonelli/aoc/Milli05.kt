package main.com.simonelli.aoc

fun main(args: Array<String>) {
    val puzzleInput = FileReader().getPuzzleInput("src/main/resources/input/milli05.txt")

    val instructions = puzzleInput.split("\n").map { it.toInt() }
    println("Number of steps to escape = ${callInstruction(instructions)}")
}

fun callInstruction(instructions: List<Int>): Int {

    val mutableList = instructions.toMutableList()
    var index = 0
    var numSteps = 0

    while(true){
        if(index >= instructions.size) { return numSteps }
        val currentVal = mutableList[index]
        mutableList.apply {
            this[index] = if (currentVal >= 3) currentVal.minus(1) else currentVal.plus(1)
        }
        if (currentVal != 0) { index += currentVal }
        numSteps += 1
    }
}