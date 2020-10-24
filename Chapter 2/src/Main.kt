fun List<Int>.sum(list: List<Int>): Int {
    var result = 0
    for (i in list) {
        result += i
    }
    return result
}
fun main() {
    println(listOf('a', 'b', 'c').joinToString(
        separator = "", prefix = "(", postfix = ")"))
    for (ch in "abc") {
        print(ch + 1)
    }
    println("Kotlin" in "Java".."Scala")        //true  범위로 알아낼수 있다.
    println("Kotlin" in setOf("Java", "Scala"))     //리스트안에 존재하는 여부를 물어보는것

    val chapter2_1=CheckingIdentifier()
    println(chapter2_1.isValidIdentifier("name"))   // true
    println(chapter2_1.isValidIdentifier("_name"))  // true
    println(chapter2_1.isValidIdentifier("_12"))    // true
    println(chapter2_1.isValidIdentifier(""))       // false
    println(chapter2_1.isValidIdentifier("012"))    // false
    println(chapter2_1.isValidIdentifier("no$"))    // false
    val sum = listOf(1, 2, 3).sum()
    println(sum)

    val result = Evaluation(rightPosition = 1, wrongPosition = 1)
    println( evaluateGuess("BCDF", "ACEB").equals(result))
    println(evaluateGuess("AAAF", "ABCA").equals(result))
    println(evaluateGuess("ABCA", "AAAF").equals(result))
}