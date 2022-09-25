package ali.baha.kmmorigami.domain.repository

import ali.baha.kmmorigami.domain.entity.Entity

interface Repository {
    suspend fun getOrigami() : List<Entity>
}