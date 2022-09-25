package ali.baha.kmmorigami

import org.koin.dsl.module

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun platformModule() = module {

}
