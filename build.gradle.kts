// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}

android {
    packagingOptions {
        resources {
            excludes += [
                "META-INF/substrate/config/reflectionconfig-aarch64-android.json"
            ]
        }
    }
}