import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LoadIndicatorsKtTest {

  @Test
  fun loadIndicatorsFromFile() {
    val loadIndicators = Loader().loadIndicators("/us.txt")

    assertEquals(loadIndicators.size, 3)

    assertEquals(
      mutableListOf(
        "Current Account to GDP",
        "Wage Growth",
        "Inflation Rate",
      ),
      loadIndicators.map { indicator -> indicator.name },
    )

    assertEquals(
      mutableListOf(10, 11, 11),
      loadIndicators.map { indicator -> indicator.series.size },
    )
  }
}
