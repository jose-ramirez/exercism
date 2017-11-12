class Luhn{
    companion object {
        fun isValid(code: String):Boolean{

            var invalidChars = charArrayOf('a', '-', '£', '$')

            for(c in invalidChars){
                if(c in code){
                    return false
                }
            }

            var processedCode = code
                .replace(" ", "")
                .split("")
                .reversed()
                .joinToString("")

            val updateValues: (Int, Int) -> Int =
                {i,v -> if(i%2==1) (if (2*v<=9) 2*v else 2*v-9) else v}

            var processedDigits = processedCode
                .map{it.toInt() - 48}
                .mapIndexed(updateValues)

            return processedDigits.sum() % 10 == 0 && processedCode.length > 1
        }
    }
}