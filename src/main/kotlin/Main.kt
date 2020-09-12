import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main(args: Array<String>) {
    val loadIndicators = Loader().loadIndicators("us.txt")
    val server = embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText("Hello, there!", ContentType.Text.Html)
            }
            get("/indicator") {
                call.respondText(Json.encodeToString(loadIndicators.first()), ContentType.Application.Json)
            }
        }
    }
    server.start(wait = true)
}
