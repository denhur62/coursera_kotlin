fun List<Int>.sum(list: List<Int>): Int {
    var result = 0
    for (i in list) {
        result += i
    }
    return result
}

fun main() {
    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")"))
    for (ch in "abc") {
        print(ch + 1)
    }
    println("Kotlin" in "Java".."Scala")        //true  범위로 알아낼수 있다.
    println("Kotlin" in setOf("Java", "Scala"))     //리스트안에 존재하는 여부를 물어보는것
    val chapter2_1 = CheckingIdentifier()
    println(chapter2_1.isValidIdentifier("name"))   // true
    println(chapter2_1.isValidIdentifier("_name"))  // true
    println(chapter2_1.isValidIdentifier("_12"))    // true
    println(chapter2_1.isValidIdentifier(""))       // false
    println(chapter2_1.isValidIdentifier("012"))    // false
    println(chapter2_1.isValidIdentifier("no$"))    // false
    val sum = listOf(1, 2, 3).sum()
    println(sum)

    val result = Evaluation(rightPosition = 1, wrongPosition = 1)
    println(evaluateGuess("BCDF", "ACEB").equals(result))
    println(evaluateGuess("AAAF", "ABCA").equals(result))
    println(evaluateGuess("ABCA", "AAAF").equals(result))

    val s1: String? = null
    val s2: String? = ""
    s1.isNullOrEmpty()
    s1?.isEmptyOrNull()
    s2?.isEmptyOrNull()
    val s3 = "   "
    s3.isEmptyOrNull()

    val s = "abc"
    println(s as? Int)
    // println(s as Int?) nullPoitnerException

    val heroes = listOf(
        Hero("The Captain", 60),
        Hero("Frenchy", 42),
        Hero("The Kid", 9),
        Hero("Lady Lauren", 29),
        Hero("First Mate", 29),
        Hero("Sir Stephen", 37)
    )

    val mapByAge: Map<Int, List<Hero>> =
        heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxBy { (_, group) ->
        group.size
    }!!
    println(age)
    val (first, second) = heroes
        .flatMap { heroes.map { hero -> it to hero } }
        .maxBy { it.first.age - it.second.age }!!
    println(first.name)

    val list1 = listOf(1, 2, 3)
    list1.allNonZero()
    list1.allNonZero1()
    list1.allNonZero2()

    list1.containsZero()
    list1.containsZero1()
    list1.containsZero2()

    val list2 = listOf(0, 1, 2)
    list2.allNonZero()
    list2.allNonZero1()
    list2.allNonZero2()

    list2.containsZero()
    list2.containsZero1()
    list2.containsZero2()

    fun isEven(i:Int):Boolean = i % 2 == 0
    val predicate = ::isEven
    println(predicate(4))
}

fun String?.isEmptyOrNull(): Boolean = this == null || this.isEmpty()

fun List<Int>.allNonZero() = this.all { it != 0 }
fun List<Int>.allNonZero1() = this.none { it == 0 }
fun List<Int>.allNonZero2() = !any { it == 0 }

fun List<Int>.containsZero() = this.any { it == 0 }
fun List<Int>.containsZero1() = !all { it!=0 }
fun List<Int>.containsZero2() = !none { it==0 }