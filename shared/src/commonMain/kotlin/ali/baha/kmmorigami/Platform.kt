package ali.baha.kmmorigami

import org.koin.core.module.Module

expect fun platformModule(): Module

expect class Platform() {
    val platform: String
}

