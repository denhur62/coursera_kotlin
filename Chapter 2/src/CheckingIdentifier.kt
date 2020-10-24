class CheckingIdentifier {
    fun isValidIdentifier(s: String): Boolean {
        fun isStringIdentifier(ch :Char) :Boolean =
                ch == '_' || ch in '0'..'9' || ch in 'a'..'z' || ch in 'A'..'Z'
        if(s.isNullOrBlank() || s.isEmpty() || s[0].isDigit())
            return false
        for(ch in s){
            if(!isStringIdentifier(ch)) return false
        }
        return true;
    }
}