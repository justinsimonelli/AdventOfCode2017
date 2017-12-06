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
            }
    println("total valid passphrases 1 = $totalValidPharses")

    totalValidPharses = 0

   puzzleInput
           .split("\n")
           .forEach {
               val list = it.split(" ")
               var mutableList = list.toMutableList()
               var anagramFound = false
               list.forEach { word ->
                   mutableList.removeAt(0)
                   if(hasAnagrams(word, mutableList)) { anagramFound = true; }
               }
               if (!anagramFound) { totalValidPharses++ }
           }

    println("total valid passphrases 2 = $totalValidPharses")
}

fun hasAnagrams(baseWord: String, words: List<String>): Boolean {
    val sortedLowerBaseWord = baseWord.toLowerCase().toList().sorted()
    return words.filter { it.toLowerCase().toList().sorted() == sortedLowerBaseWord }.isEmpty()
}
