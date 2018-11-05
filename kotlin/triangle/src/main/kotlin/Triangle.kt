class Triangle(a: Number, b: Number, c: Number) {

    var a: Number = a
    var b: Number = b
    var c: Number = c

    var isEquilateral: Boolean =
            sidesActuallyFormATriangle()
            && closeEnough(this.a, this.b)
            && closeEnough(this.c, this.b)
            && closeEnough(this.a, this.c)

    var isIsosceles: Boolean = 
            sidesActuallyFormATriangle()
            && closeEnough(this.a, this.b)
            || closeEnough(this.b, this.c)
            || closeEnough(this.a, this.c)

    var isScalene = !isEquilateral && !isIsosceles

    fun sidesActuallyFormATriangle(): Boolean {
        var _a = this.a.toDouble()
        var _b = this.b.toDouble()
        var _c = this.c.toDouble()
        var verify: Boolean = _a + _b > _c && _a + _c > _b && _b + _c > _a
        if(!verify){
            throw IllegalArgumentException()
            return false
        }
        return true
    }

    fun closeEnough(a: Number, b: Number): Boolean {
        val tol = 1e-5
        return Math.abs(a.toDouble() - b.toDouble()) < tol
    }
}