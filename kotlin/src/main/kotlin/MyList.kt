// data MyList a = Nil | Cons a (MyList a)

sealed class MyList<A>
class Nil<A> : MyList<A>() {
    override fun toString(): String {
        return "Nil"
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Nil<*> -> true
            else -> false
        }
    }

}

data class Cons<A>(val head: A, val tail: MyList<A>) : MyList<A>() {
    override fun toString(): String {
        return "$head : $tail"
    }
}

fun <A> MyList<A>.toList(): List<A> =
    when (this) {
        is Cons -> listOf(this.head) + this.tail.toList()
        is Nil -> emptyList()
    }


infix fun <A> MyList<A>.append(ys: MyList<A>): MyList<A> = when (this) {
    is Nil -> ys
    is Cons -> Cons(this.head, this.tail append ys)
}

// Helper
fun <A> myListOf(vararg elements: A): MyList<A> = elements.asList().foldRight(Nil(), ::Cons)

//#Rev 1
//skriv en funksjon som reverserer en liste ved å appende elementer bakerst
fun <A> MyList<A>.reverse(): MyList<A> =
    when (this) {
        is Cons -> this.tail.reverse() append Cons(this.head, Nil())
        is Nil -> Nil()
    }


//#Rev 2
//Hva er suboptimalt med løsningen over?
//Hva er kjøretidskompleksiteten?
//Hva burde vi forvente den er?
val ans = "append er lineær i første (this) argumentet, O(n)." +
    "siden man gjør dette for hver element i listen man reverserer, så blir det kvadratisk O(n^2)." +
    "Man burde kunne forvente at den er O(n)"


//#Rev 3
//Skriv reverse på nytt, men en mer optimal versjon
//Hint : lag enda en funksjon (gjerne internt i reverse')
fun <A> MyList<A>.reverse2(): MyList<A> {
    tailrec fun helper(cur: MyList<A>, res: MyList<A>): MyList<A> =
        when (cur) {
            is Cons -> helper(cur.tail, Cons(cur.head, res))
            is Nil -> res
        }
    return helper(this, Nil())
}
