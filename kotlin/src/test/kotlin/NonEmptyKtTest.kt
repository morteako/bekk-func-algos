import assertk.assertThat
import assertk.assertions.isEqualTo
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.next
import io.kotest.property.checkAll


internal class NonEmptyKtTest : StringSpec({
    "prop_prepend" {
        checkAll(nonEmptyArb, listArb) { nonEmpty, list ->
            assertThat(nonEmpty.prependList(list).toList()).isEqualTo(list + nonEmpty.toList())
        }
    }

    "partionres" {
        assertThat(partitionres).isEqualTo(Pair(listOf(1, 3), listOf(4, 2)))
    }

    "prop_partition" {
        checkAll(nonEmptyArb) { nonEmpty ->
            val lp = nonEmpty.partition2 { it % 2 == 0 }
            val np = nonEmpty.partition { it % 2 == 0 }
            assertThat(toNonEmpty(np)).isEqualTo(toNonEmpty2(lp))
        }
    }
}
)


private val nonEmptyArb = arbitrary {
    val head = Arb.int(-10..10).next()
    val tail = Arb.list(Arb.int(-10..10), 0..20).next()
    NonEmpty(head, tail)
}


private val listArb =
    Arb.list(Arb.int(-10..10), 0..20)
