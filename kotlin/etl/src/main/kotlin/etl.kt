object ETL {
    fun transform(map: Map<Int, List<Char>>): Map<Char, Int> {
        var newMap: Map<Char, Int> = mutableMapOf()
        for ((k, v) in map.iterator()) {
            for (e in v.iterator()) {
                newMap += e.toLowerCase() to k
            }
        }
        return newMap
    }
}