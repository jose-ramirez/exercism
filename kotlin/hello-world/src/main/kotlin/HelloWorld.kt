fun hello(name: String = ""): String {
	if(!"".equals(name.trim(' '))) {
		return "Hello, " + name + "!"	
	}else return "Hello, World!"
}
