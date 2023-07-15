plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "tr.mfk.app"
    compileSdk = Config.COMPILE_SDK_VERSION

    packagingOptions {
        exclude("META-INF/gradle/incremental.annotation.processors")
    }

    defaultConfig {
        applicationId = Config.ID
        minSdk = Config.MIN_SDK_VERSION
        targetSdk = Config.TARGET_SDK_VERSION
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        renderscriptTargetApi = 19
        renderscriptSupportModeEnabled = true
        testInstrumentationRunner = Config.TEST_INSTRUMENTATION_RUNNER
        setProperty(
            "archivesBaseName",
            applicationId + "-v" + versionCode + "("
                    + versionName + ")"
        )

    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = true
            isShrinkResources = true
            ndk.debugSymbolLevel = "FULL"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            lint {
                abortOnError = false
                checkReleaseBuilds = false
            }
        }
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            ndk.debugSymbolLevel = "FULL"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":common"))
    implementation(project(":eCommerce"))
    implementation(Libs.CORE_KTX)
    implementation(Libs.APP_COMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.HILT)
    kapt(Libs.HILT_COMPILER)
    implementation(Libs.HILT_COMPILER)
    implementation(Libs.RETROFIT)
    implementation(Libs.TIMBER)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}