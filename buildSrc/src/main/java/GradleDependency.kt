object GradleVersions {
    const val GRADLE = "7.3.1"
    const val KOTLIN_GRADLE = "1.7.20"
    const val GOOGLE_SERVICE = "4.3.14"
    const val CRASHLYTICS = "2.9.2"
    const val FIREBASE_PERF = "1.4.2"

}

object GradlePluginId {
    const val GRADLE = "com.android.tools.build:gradle:${GradleVersions.GRADLE}"
    const val KOTLIN_GRADLE =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradleVersions.KOTLIN_GRADLE}"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${LibsVersion.HILT}"
    const val NAVIGATION =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${LibsVersion.NAVIGATION}"
    const val GOOGLE_SERVICE = "com.google.gms:google-services:${GradleVersions.GOOGLE_SERVICE}"
    const val CRASHLYTICS =
        "com.google.firebase:firebase-crashlytics-gradle:${GradleVersions.CRASHLYTICS}"
    const val FIREBASE_PERF = "com.google.firebase:perf-plugin:${GradleVersions.FIREBASE_PERF}"

}