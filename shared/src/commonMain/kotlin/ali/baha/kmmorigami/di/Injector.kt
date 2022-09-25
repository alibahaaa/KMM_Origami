package ali.baha.kmmorigami.di

import ali.baha.kmmorigami.data.datasource.RemoteDatasource
import ali.baha.kmmorigami.data.datasource.RemoteDatasourceImpl
import ali.baha.kmmorigami.platformModule
import ali.baha.kmmorigami.data.remote.createHttpClient
import ali.baha.kmmorigami.data.remote.createJson
import ali.baha.kmmorigami.data.repository.RepositoryImpl
import ali.baha.kmmorigami.domain.repository.Repository
import ali.baha.kmmorigami.domain.usecase.GetOrigamiUseCase
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import kotlin.reflect.KClass

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, platformModule())
}

fun initKoin() = initKoin {}

val commonModule = module {
    single { createJson() }
    single { createHttpClient(get()) }
    single<RemoteDatasource> { RemoteDatasourceImpl(get()) }
    single<Repository> { RepositoryImpl(get()) }
    single { GetOrigamiUseCase(get()) }
}

fun <T> Koin.getDependency(clazz: KClass<*>): T {
    return get(clazz, null) { parametersOf(clazz.simpleName) } as T
}