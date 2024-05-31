pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        jcenter()
        maven {
            url =uri("https://maven.regulaforensics.com/RegulaDocumentReader/Beta")
        }

    }
}

rootProject.name = "iPass Plus Core"
include(":app")
include(":mylibrary")
//enableFeaturePreview("VERSION_CATALOGS")