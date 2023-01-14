
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    val messages = mutableListOf<ByteArray>()

    embeddedServer(Netty, port = 4567) {
        routing {
            post("/messages") {
                val message = call.receive<ByteArray>()
                messages.add(message)
                call.respondText("Message received!")
            }
            get("/messages") {
                val lastMessage = messages.lastOrNull()
                if (lastMessage != null) {
                    call.respond(lastMessage)
                } else {
                    call.respondText("No messages received yet")
                }
            }
        }
    }.start(wait = true)
}
class Main


