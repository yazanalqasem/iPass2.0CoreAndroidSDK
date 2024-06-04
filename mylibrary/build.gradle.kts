plugins {
    `maven-publish`
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
//    alias(libs.plugins.androidLibrary)
//    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.iPass.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
//    implementation(fileTree(mapOf(
//        "dir" to "libs/fullauthrfid",
//        "include" to listOf("*.aar", "*.jar"),
//        "exclude" to listOf("")
//    )))
//    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf( "api-1.0.0", "api-1.0.0", "fullrfid-1.0.0"))))
//    implementation(files("libs/fullauthrfid/fullauthrfid-7.2.10816.aar"))
//    implementation("impFiles:api-7.2.9754.aar")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}

project.afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.core.iPass2.0"
                artifactId = "Core"
                version = "2.5"
            }
        }
    }
}
configurations.maybeCreate("default")
artifacts.add("default", file("fullauthrfid-7.2.10816.aar"))