plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo3")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

apollo{
    service("graphql-ricknmorty") {
        packageName.set("com.example.rickandmortyapi")
        sourceFolder.set("")
        generateOptionalOperationVariables.set(false)
        generateKotlinModels.set(true)

        introspection {
            endpointUrl.set("https://rickandmortyapi.com/graphql")
            schemaFile.set(file("app/src/main/graphql/schema.graphqls"))
        }
    }
}

android {
    namespace = "com.example.rickandmortyapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.rickandmortyapi"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("com.apollographql.apollo3:apollo-runtime:3.8.1")
    implementation("com.apollographql.apollo3:apollo-api:3.8.1")
    implementation("com.apollographql.apollo:apollo-coroutines-support:2.5.14")
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("androidx.hilt:hilt-work:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.work:work-runtime:2.7.0-alpha05")
    implementation("com.github.bumptech.glide:glide:4.16.0")

}