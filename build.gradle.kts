import org.jetbrains.kotlin.fir.declarations.builder.buildScript
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.apollographql.apollo3:apollo-gradle-plugin:3.8.1")
        classpath("com.android.tools.build:gradle:8.1.1")
    }

    repositories{
        google()  // for Dagger Hilt
        mavenCentral()
    }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply    false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}
