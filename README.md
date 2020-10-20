## Target Java 8 in all your projects

A very simple Gradle plugin to avoid the `Cannot inline bytecode built with JVM target 1.8 into bytecode that is being built with JVM target 1.6` [error](https://stackoverflow.com/questions/48988778/cannot-inline-bytecode-built-with-jvm-target-1-8-into-bytecode-that-is-being-bui).

The plugin will make your Java/Kotlin/Android task target Java 8:

```kotlin
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
```

Add to your root project:

```kotlin
// root/build.gradle[.kts]
plugins {
  id("net.mbonnin.one.height").version("0.1")
}
```

Or using the buildscript:

```kotlin
// root/build.gradle[.kts]
buildscript {
  classpath("net.mbonnin:one-height:0.1")
}

apply(plugin = "net.mbonnin.one.height")
```