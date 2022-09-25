package ali.baha.kmmorigami.data.remote

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(
    json: Json
) = HttpClient {
    install(ContentNegotiation) {
        json(json)
    }
}