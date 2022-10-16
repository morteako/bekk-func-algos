import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class MapKtTest {
    @Test
    fun combinedMaps() {
        val expected = mapOf(
            "morten" to 400,
            "kim" to 450,
            "lars" to 100
        )
        assertThat(combinedMaps).isEqualTo(expected)
    }

    @Test
    fun intersectedMaps() {
        val expected = mapOf("morten" to listOf(300, 100))
        assertThat(intersectedMaps).isEqualTo(expected)
    }
}
