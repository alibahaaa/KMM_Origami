package ali.baha.kmmorigami.data.datasource

import ali.baha.kmmorigami.domain.entity.Entity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent

interface RemoteDatasource {
    suspend fun fetchOrigami(): List<Entity>
}

class RemoteDatasourceImpl(
    private val client: HttpClient
) : KoinComponent, RemoteDatasource {
    override suspend fun fetchOrigami(): List<Entity> {
        return try {
            val response = client.get("http://172.20.10.4:9005/api_v1.0/kmm")
            if (response.status.value == 200)
                response.body()
            else
                listOf()
        } catch (e: Exception) {
            listOf()
        }

    }
}
