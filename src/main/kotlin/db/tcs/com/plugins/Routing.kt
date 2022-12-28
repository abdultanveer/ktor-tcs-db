package db.tcs.com.plugins

import db.tcs.com.data.dao.dao
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/articles") {
            call.respond(mapOf("articles" to dao.allArticles()))
        }
    }
}
