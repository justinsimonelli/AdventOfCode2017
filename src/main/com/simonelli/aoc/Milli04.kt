package main.com.simonelli.aoc

fun main(args: Array<String>) {
    val puzzleInput = FileReader().getPuzzleInput("src/main/resources/input/milli04.txt")
    var totalValidPharses = 0
    puzzleInput
            .split("\n")
            .forEach {list ->
                var passphrases = HashSet<String>()
                val phrases = list.split(" ")
                val totalPhrases = phrases.size
                passphrases.addAll(phrases)
                val isValid = !passphrases.isEmpty() && passphrases.size == totalPhrases
                totalValidPharses += if(isValid) 1 else 0
                println("isValid = $isValid")
            }
    println("total valid passphrases = $totalValidPharses")
}

fun match(baseWord: String, words: List<String>): List<String> {
    val sortedLowerBaseWord = baseWord.toSortedLowerCase()
    val thing = words.
            filterNot { it.equals(baseWord, ignoreCase = true) }.
            filter { it.toSortedLowerCase() == sortedLowerBaseWord }

    return thing
}


fun String.toSortedLowerCase(): List<Char> = this.toLowerCase().toList().sorted()
