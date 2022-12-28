package db.tcs.com.data.di

import db.tcs.com.data.dao.DAOFacade
import db.tcs.com.data.dao.DAOFacadeImpl
import db.tcs.com.data.dao.dao
import io.ktor.server.application.*
import io.ktor.server.application.*
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
   install(Koin)
    loadKoinModules(cityModule)
}

val cityModule = module {

    single<DAOFacade> { dao }
}