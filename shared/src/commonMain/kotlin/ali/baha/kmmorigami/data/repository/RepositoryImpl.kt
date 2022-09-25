package ali.baha.kmmorigami.data.repository

import ali.baha.kmmorigami.data.datasource.RemoteDatasource
import ali.baha.kmmorigami.domain.entity.Entity
import ali.baha.kmmorigami.domain.repository.Repository
import org.koin.core.component.KoinComponent

class RepositoryImpl(
   private val remoteDatasource: RemoteDatasource
) : KoinComponent , Repository {
    override suspend fun getOrigami(): List<Entity> = remoteDatasource.fetchOrigami()
}