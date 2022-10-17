import assertk.assertThat
import assertk.assertions.isEqualTo
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll


internal class MapPropKtTest : StringSpec({
    "unionWith that picks right is same as plus" {
        checkAll(mapArb, mapArb) { m1, m2 ->
            val actual = m1 + m2
            val expected = m1.unionWith(m2) { _, b -> b }
            assertThat(actual).isEqualTo(expected)
        }
    }

    "unionWith that picks left is same as flipped plus" {
        checkAll(mapArb, mapArb) { m1, m2 ->
            val actual = m2 + m1
            val expected = m1.unionWith(m2) { a, _ -> a }
            assertThat(actual).isEqualTo(expected)
        }
    }

    "intersectioonWith contains intersection of keys" {
        checkAll(mapArb, mapArb) { m1, m2 ->
            val actual = m1.keys intersect m2.keys
            val expected = m1.intersectionWith(m2) { _, b -> b }.keys
            assertThat(actual).isEqualTo(expected)
        }
    }


}
)

private val mapArb =
    Arb.map(Arb.int(-5..5), Arb.string(1), maxSize = 10)
