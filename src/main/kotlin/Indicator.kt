import kotlinx.serialization.Serializable

@Serializable
class Indicator (
  val name: String,
  val series: MutableList<SeriesItem> = mutableListOf(),
) {
    fun addSeriesItem(item: SeriesItem) {
       series.add(item)
    }
}
