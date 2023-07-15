// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://jitpack.io")
    }

    dependencies {
        classpath(GradlePluginId.GRADLE)
        classpath(GradlePluginId.KOTLIN_GRADLE)
        classpath(GradlePluginId.HILT)
        classpath(GradlePluginId.NAVIGATION)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}

allprojects {
    repositories {
        jcenter()
        maven("https://jitpack.io")
        maven("https://maven.google.com")
        google()
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}