object Sublist{
  val Superlist: Int = 1
  val Sublist: Int = 2
  val Equal: Int = 3
  val Unequal: Int = 4

  def sublist(l1: List[Any], l2: List[Any]): Int = {
    var result:Int = 0
    if (l1.isEmpty && l2.isEmpty){
        return Equal
    }
    if (!l2.isEmpty && l1.isEmpty){
        return Sublist
    }
    if (!l1.isEmpty && l2.isEmpty){
        return Superlist
    }

    var length1 = l1.length
    var length2 = l2.length

    if(length1 == length2){
        return if(l1.equals(l2)) Equal else Unequal
    }else if(length1 < length2){
      for(a <- 0 to (length2 - length1)){
        if(l1.equals(l2.slice(a, a + length1))){
          return Sublist
        }
      }
    }else if(length2 < length1){
      for(a <- 0 to (length1 - length2)){
        if(l2.equals(l1.slice(a, a + length2))){
          return Superlist
        }
      }
    }
    return Unequal
  }
}