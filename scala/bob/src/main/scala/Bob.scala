class Bob{
  def hey(question:String) = {
    val numPattern = "([a-zA-Z])".r
    if ("".equals(question.trim))
      "Fine. Be that way!"
    else if(question.toUpperCase == question && numPattern.findFirstIn(question) != None)
      "Whoa, chill out!"
    else if (question.endsWith("?"))
      "Sure."
    else if (question.endsWith("!") || question.endsWith("."))
      "Whatever."
    else
      "Whatever."
  }
}
