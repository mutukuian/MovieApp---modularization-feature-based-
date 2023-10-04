plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.multimoduleapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.multimoduleapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":feature:movie:ui"))
    implementation(project(":feature:movie:domain"))
    implementation(project(":feature:movie:data"))
    implementation(project(":core:feature_api"))
    implementation(project(":core:common"))

    implementation  (Deps.core)
    implementation (CoroutinesLifecycleScope.lifeCycleRuntime)
    implementation(JetpackCompose.composeActivity)
//    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation(JetpackCompose.composeUi)
//    implementation("androidx.compose.ui:ui-graphics")
    implementation(JetpackCompose.composeUiToolingPreview)
    implementation(JetpackCompose.composeMaterial)
    implementation("androidx.compose.material3:material3:1.1.2")


    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)


    androidTestImplementation(ComposeAndroidTestImplementation.composeUiTest)
    debugImplementation(ComposeDebugImplementation.toolingUi)
    debugImplementation(ComposeDebugImplementation.manifestTest)

    implementation (DaggerHilt.hilt)
    kapt (DaggerHilt.hiltCompiler)

    implementation(JetpackCompose.navigation)
}