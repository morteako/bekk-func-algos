// Implementer unionWith for Map<K,A>
// Gjør det gjerne funksjonelt, dvs uten var og uten mutable maps osv
// tips : groupBy og mapValues
fun <K, A> Map<K, A>.unionWith(other: Map<K, A>, comb: (A, A) -> A): Map<K, A> {
    val allPairs = this.entries + other.entries
    return allPairs
        .groupBy({ it.key }, { it.value })
        .mapValues { (_, list) ->
            when (list.size) {
                2 -> comb(list[0], list[1])
                1 -> list[0]
                else -> throw RuntimeException("not possible")
            }
        }
}


val maps = listOf(
    mapOf("morten" to 300),
    mapOf("kim" to 400),
    mapOf("morten" to 100, "kim" to 50),
    mapOf("lars" to 100),
)

// Bruk unionWith til å kombinere mapsa i listen ovenfor.
// altså summere valuene
// Bruk gjerne reduce/fold
val combinedMaps: Map<String, Int> = maps.reduce { a, b -> a.unionWith(b) { ia, ib -> ia + ib } }


// Implementer intersectionWith for Map<K,A>
// Gjør det gjerne funksjonelt, dvs uten var og uten mutable maps osv
fun <K, A, B, C> Map<K, A>.intersectionWith(other: Map<K, B>, comb: (A, B) -> C): Map<K, C> =
    this
        .filterKeys { other.containsKey(it) }
        .mapValues { (k,a) -> comb(a, other.getValue(k)) }

//alternativt men treig
fun <K, A, B, C> Map<K, A>.intersectionWithTreig(other: Map<K, B>, comb: (A, B) -> C): Map<K, C> =
    this.entries.fold(emptyMap()) { acc, (k, v) ->
        if (other.containsKey(k)) {
            acc + Pair(k, comb(v, other.getValue(k)))
        } else acc
    }



// Bruk intersectionWith til å kombinere imap1 og imap2
// Her skal du samle opp alle tallene(verdiene i mapsene) i lista for keysene som finnes i begge maps
// Se test for forventet resultat
val imap1 = mapOf("morten" to 300, "lars" to 200)

val imap2 =
    mapOf("morten" to 100, "kim" to 50)


val intersectedMaps: Map<String, List<Int>> =
    imap1.intersectionWith(imap2) { a, b -> listOf(a, b) }
