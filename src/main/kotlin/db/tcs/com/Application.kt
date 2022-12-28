package db.tcs.com

import db.tcs.com.data.dao.DatabaseFactory
import io.ktor.server.application.*
import db.tcs.com.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    DatabaseFactory.init()
    configureRouting()
}
