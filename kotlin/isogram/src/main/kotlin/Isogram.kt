class Isogram {
    companion object {
	fun isIsogram(str: String): Boolean{
	    var i = 0;
	    var l = str.length - 1;
	    var specialChars = arrayOf(' ', '-');
	    var str1 = str.toLowerCase();
	    for(char in str1) {
	        var rest = str1.substring(i + 1);
		if(char in rest && char !in specialChars && rest.length > 1){
		    return false;
		}
		i = i + 1;
	    }
	    return true;
	}
    }
}
