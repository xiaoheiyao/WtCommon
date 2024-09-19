pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
        }

        maven {
            url = uri("https://maven.aliyun.com/repository/public")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/jcenter")
        }
        maven { url = uri("https://esri.jfrog.io/artifactory/arcgis") }

        maven { url = uri("https://jitpack.io") }

        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots") }

        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
        }

        maven {
            url = uri("https://maven.aliyun.com/repository/public")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/jcenter")
        }
        maven { url = uri("https://esri.jfrog.io/artifactory/arcgis") }

        maven { url = uri("https://jitpack.io") }

        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots") }

        google()
        mavenCentral()
    }
}

rootProject.name = "WtCommon"
include(":app")
include(":commonres")
include(":bluetooth_library")
include(":version_check_library")