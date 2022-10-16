import assertk.assertThat
import assertk.assertions.isEqualTo
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.next
import io.kotest.property.checkAll

internal class MyListTest : StringSpec({
    "prop_reverse" {
        checkAll(myListArb) { list ->
            assertThat(list.reverse()).isEqualTo(list.toList().reversed().foldRight(Nil() ,::Cons))
        }
    }

    "prop_reverse2" {
        checkAll(myListArb) { list ->
            assertThat(list.reverse2()).isEqualTo(list.toList().reversed().foldRight(Nil() ,::Cons))
        }
    }
}
)

private val myListArb = arbitrary {
    myListOf(*Arb.list(Arb.int(-10..10), 0..20).next().toTypedArray())
}
