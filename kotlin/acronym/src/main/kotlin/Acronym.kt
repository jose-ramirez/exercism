class Acronym{
    companion object Foo{
        fun generate(sentence: String): String{
            return sentence
                .replace("-", " ")
                .split(" ")
                .map {s -> s.get(0)}
                .joinToString("")
                .toUpperCase()
        }
    }
}