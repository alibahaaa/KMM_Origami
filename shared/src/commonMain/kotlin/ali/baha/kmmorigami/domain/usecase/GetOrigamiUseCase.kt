package ali.baha.kmmorigami.domain.usecase

import ali.baha.kmmorigami.domain.repository.Repository

class GetOrigamiUseCase(private val repository: Repository) {
    suspend fun invoke() = repository.getOrigami()
}