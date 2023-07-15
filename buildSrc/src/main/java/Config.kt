object Config {
    const val MIN_SDK_VERSION = 24
    const val TARGET_SDK_VERSION = 33
    const val COMPILE_SDK_VERSION = 33

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"

    const val ID = "tr.mfk.multimodule"
    const val TEST_INSTRUMENTATION_RUNNER =
        "androidx.test.runner.AndroidJUnitRunner"
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
    val isDebuggable: Boolean
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = true
    override val isDebuggable = false
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override var isDebuggable = true
}