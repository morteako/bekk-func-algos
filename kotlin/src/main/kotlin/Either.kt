// Kan brukes til #partition2-oppgaven
sealed class Either<out A, out B> {
    data class Left<A>(val value: A): Either<A, Nothing>()
    data class Right<B>(val value: B): Either<Nothing, B>()
}
