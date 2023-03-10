package db.tcs.com.plugins

import db.tcs.com.data.Article
import db.tcs.com.data.dao.DAOFacade
import db.tcs.com.data.dao.dao
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.util.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        route("articles") {
           // val insertService by inject<InsertNewUser>()
            val mDao  by inject<DAOFacade>()
            get {
                call.respond(mapOf("articles" to mDao.allArticles()))
            }

            get("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                // call.respond(FreeMarkerContent("show.ftl", mapOf("article" to dao.article(id))))
                val article = dao.article(id)
                call.respond (mapOf("article" to article))
            }

            post {
                val article: Article = call.receive()
               // val article1 = call.receive<Article>()
                dao.addNewArticle(article.title,article.body)
                //call.respondText(""+article.id)

            }

            put("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val article: Article = call.receive()

                dao.editArticle(id, article.title, article.body)
                call.respondText("updated article")
            }

            delete("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                dao.deleteArticle(id)
                call.respondRedirect("/articles")
            }




        }
    }
}
