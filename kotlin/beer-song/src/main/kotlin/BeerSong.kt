object BeerSong {

    private fun pluralize(i: Int): String {
        return if (i > 1) "s" else ""
    }

    private fun verse(numBottles: Int): String {
        return when {
            numBottles > 1 -> "$numBottles bottles of beer on the wall, $numBottles bottles of beer.\nTake one down and pass it around, ${numBottles - 1} bottle${pluralize(numBottles - 1)} of beer on the wall.\n"
            numBottles == 1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
            numBottles == 0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
            else -> ""
        }
    }

    fun verses(startBottles: Int, takeDown: Int): String {
        var text = verse(startBottles)
        for (i in (startBottles - 1) downTo takeDown) {
            text += "\n${verse(i)}"
        }
        return text
    }
}
