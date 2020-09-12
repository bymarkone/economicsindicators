import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class SeriesItem (
 val date: String,
 val value: Double,
) {
}
