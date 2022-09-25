package ali.baha.kmmorigami.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Entity(
    val id: Int = 0,
    val name: String = "",
    val image: String = "",
    val description: String = ""
)