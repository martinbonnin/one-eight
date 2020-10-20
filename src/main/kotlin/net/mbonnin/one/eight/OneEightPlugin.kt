package net.mbonnin.one.eight

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class OneEightPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    target.allprojects {project ->
      with(project.plugins) {
        withId("com.android.library") {
          project.configureAndroid()
        }
        withId("com.android.application") {
          project.configureAndroid()
        }
        withId("org.jetbrains.kotlin.jvm") {
          project.configureKotlin()
        }
        withId("org.jetbrains.kotlin.multiplatform") {
          project.configureKotlin()
        }
        withId("java") {
          project.configureJava()
        }
      }
    }
  }
}

private fun Project.configureJava() {
  extensions.configure(JavaPluginExtension::class.java) {
    it.sourceCompatibility = JavaVersion.VERSION_1_8
    it.targetCompatibility = JavaVersion.VERSION_1_8
  }
}

private fun Project.configureKotlin() {
  tasks.withType(KotlinCompile::class.java) {
    it.kotlinOptions {
      jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
  }
}

private fun Project.configureAndroid() {
  extensions.configure(com.android.build.gradle.BaseExtension::class.java) {
    it.compileOptions {
      it.sourceCompatibility = JavaVersion.VERSION_1_8
      it.targetCompatibility = JavaVersion.VERSION_1_8
    }
  }
}
