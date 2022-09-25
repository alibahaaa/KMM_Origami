package ali.baha.kmmorigami

import ali.baha.kmmorigami.di.getDependency
import io.ktor.client.*
import io.ktor.client.engine.ios.*
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import kotlinx.serialization.json.Json
import org.koin.core.Koin
import org.koin.dsl.module
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}



actual fun platformModule() = module {

}

fun <T> Koin.getDependency(objCClass: ObjCClass): T? = getOriginalKotlinClass(objCClass)?.let {
    getDependency(it)
}

