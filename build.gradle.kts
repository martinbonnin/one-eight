plugins {
  kotlin("jvm").version("1.4.10")
  id("java-gradle-plugin")
  id("com.gradle.plugin-publish").version("0.10.1")
}

repositories {
  mavenCentral()
  google()
}

dependencies {
  compileOnly("com.android.tools.build:gradle:3.4.2")
  compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
}

pluginBundle {
  website = "https://github.com/martinbonnin/one-eight"
  vcsUrl = "https://github.com/martinbonnin/one-eight"
  tags = listOf("1.8", "jdk", "kotlin", "java", "jvm", "android")
}

gradlePlugin {
  plugins {
    create("oneEightPlugin") {
      id = "net.mbonnin.one.eight"
      displayName = "1.8 for everyone."
      description = ""
      implementationClass = "net.mbonnin.one.eight.Plugin"
    }
  }
}
