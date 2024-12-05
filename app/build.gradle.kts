plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.virtualpetapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.virtualpetapp"
        minSdk = 26
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(files("libs/javafx.base.jar"))
    implementation(files("libs/javafx.fxml.jar"))
    implementation(files("libs/javafx.controls.jar"))
    implementation(files("libs/javafx.graphics.jar"))
    implementation(files("libs/javafx.media.jar"))
    implementation(files("libs/javafx.swing.jar"))
    implementation(files("libs/javafx.web.jar"))
    implementation(files("libs/javafx-swt.jar"))
    implementation(files("libs/javafx.base.jar"))
    implementation(files("libs/javafx.media.jar"))
    implementation(files("libs/javafx.controls.jar"))
    implementation(files("libs/javafx.fxml.jar"))
    implementation(files("libs/javafx.graphics.jar"))
    implementation(files("libs/javafx.swing.jar"))
    implementation(files("libs/javafx.web.jar"))
    implementation(files("libs/javafx-swt.jar"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

android {
    packaging {
        resources {
            excludes.addAll(
                listOf("META-INF/substrate/config/reflectionconfig-aarch64-android.json")
            )
        }
    }
}

