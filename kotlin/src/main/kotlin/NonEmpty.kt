data class NonEmpty<A>(val head:A, val tail:List<A>) {
    fun toList():List<A> = listOf(head) + tail

    override fun toString(): String {
        return "NonEmpty(${this.toList()})"
    }
}


//-- #prependList
//-- Implementer en funksjon som appender en List foran på en NonEmpty List
//-- Ex
//-- NonEmpty(4,[5]).prependList(listOf[1,2,3])  = NonEmpty(1,[2,3,4,5])
fun <A> NonEmpty<A>.prependList(list:List<A>):NonEmpty<A> = when {
        list.isEmpty() -> this
        else -> NonEmpty(list.first(), list.drop(1) + this.toList())
    }

//-- vi kan definere partition ved å gjenbruke partition for vanlige lister
fun <A> NonEmpty<A>.partition(pred:(A) -> Boolean):Pair<List<A>,List<A>> = this.toList().partition(pred)

//-- gi en NonEmpty<Int> slik at partitionres = ([1,3],[4,2])
// altså bytt ut  NonEmpty(0, listOf())
// hvor mange riktige svar finnes?
val partitionres : Pair<List<Int>,List<Int>> = NonEmpty(1, listOf(3,4,2)).partition { it % 2 == 1 }
//NonEmpty(1, listOf(3,4,2)
//NonEmpty(1, listOf(4,3,2)
//NonEmpty(1, listOf(4,2,3)
//NonEmpty(4, listOf(1,2,3)
//NonEmpty(4, listOf(2,1,3)
//NonEmpty(4, listOf(1,3,2)

//
//-- #partition 2
//-- returtypen til partition ovenfor er lett å bruke, men vi mister litt informasjon
//-- hva mangler?
//-- hva kan vi vite om de to listene vi får tilbake?
//-- hvordan får vi inn denne informasjonen i returtypen?
//-- implementer partition' med denne nye typen
//-- tips : bruk List<A>.partition for å gjøre grovjobben
// Se også Either.kt
//-- se også oppgaven under først



typealias ResType<A> = Either<Pair<NonEmpty<A>,List<A>>, Pair<List<A>,NonEmpty<A>>>

fun <A> NonEmpty<A>.partition2(pred:(A) -> Boolean):ResType<A> {
    val (pos, negs) = this.tail.partition(pred)
    return when(pred(this.head)) {
        true -> Either.Left(NonEmpty(this.head, pos) to negs)
        false -> Either.Right(pos to NonEmpty(this.head, negs) )
    }
}

//-- #partition 3
//-- Vi kan tenke at vi vil konvertere resultatet fra partition' tilbake til en NonEmpty
//-- men bruker vi Pair<List<A>>,List<A>>) , så klarer vi ikke bedre enn : toNonEmpty : Pair<List<A>>,List<A>> -> NonEmpty<A>?
//-- Men som nevnt ovenfor, kan denne typen bli mer presis.
//-- Etter du har implementert denne typen, så skal du kunne implementere en
//-- funksjon toNonEmpty' : ResType<A> -> NonEmpty<A>
// tips: bruk prependList

fun <A> toNonEmpty(lists:Pair<List<A>,List<A>>) : NonEmpty<A>? {
    val (xs,ys) = lists
    return when {
        xs.isNotEmpty() -> NonEmpty(xs.first(),xs.drop(1) + ys)
        ys.isNotEmpty() -> NonEmpty(ys.first(),ys.drop(1))
        else -> null
    }
}
fun <A> toNonEmpty2(lists:ResType<A>) : NonEmpty<A> {
    return when(lists) {
        is Either.Left -> {
            val (ne,xs) = lists.value
            NonEmpty(ne.head, ne.tail + xs)
        }
        is Either.Right -> {
            val (xs,ne) = lists.value
            ne.prependList(xs)
        }
    }
}
