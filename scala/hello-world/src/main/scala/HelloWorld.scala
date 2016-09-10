object HelloWorld{
  def hello(name:String = "") = {
    if (name == "")
      "Hello, World!"
    else
      "Hello, " + name + "!"
  }
}
