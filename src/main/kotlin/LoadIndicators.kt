import java.io.File

class Loader {
  fun loadIndicators(path: String): Collection<Indicator> {
    return File(this.javaClass.getResource(path).toURI())
      .readLines()
      .map(::parse)
      .fold(initial = listOf()) { acc, item ->
        when (item) {
          is Indicator -> acc + item
          is SeriesItem -> withSeriesItem(acc, item)
          else -> acc
        }
      }
  }

  private fun withSeriesItem(
    acc: List<Indicator>,
    item: SeriesItem
  ): List<Indicator> {
    acc.last().addSeriesItem(item); return acc
  }
}

fun parse(line: String): Any? {
  return when {
    line.startsWith("I:") -> parseIndicator(line)
    line.trim().isNotEmpty() -> parseSeriesItem(line)
    else -> null
  }
}

fun parseSeriesItem(line: String): SeriesItem {
  val split = line.split(":")
  return SeriesItem(toLocalDate(split[0]), toDouble(split[1]))
}

private fun toDouble(split: String) = split.trim().replace("%", "").toDouble()
private fun toLocalDate(split: String) = split.trim() + "-01-01"

fun parseIndicator(line: String): Indicator {
  return Indicator(line.split(":").last().trim())
}
