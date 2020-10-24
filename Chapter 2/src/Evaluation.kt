data class Evaluation(val rightPosition: Int, val wrongPosition: Int) {

}

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { it.first==it.second }

    val commonLetters = "ABCDEF".sumBy { ch ->

        Math.min(secret.count { ch==it }, guess.count { ch==it })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}