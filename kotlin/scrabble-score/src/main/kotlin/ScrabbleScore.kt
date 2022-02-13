object ScrabbleScore {


    fun scoreLetter(c: Char): Int {
        return when (c) {
            in arrayOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T') -> 1
            in arrayOf('D', 'G') -> 2
            in arrayOf('B', 'C', 'M', 'P') -> 3
            in arrayOf('F', 'H', 'V', 'W', 'Y') -> 4
            in arrayOf('K') -> 5
            in arrayOf('J', 'X') -> 8
            in arrayOf('Q', 'Z') -> 10
            else -> 0
        }
    }

    fun scoreWord(word: String): Int = word.map { scoreLetter(it.uppercaseChar()) }.sum()
}
