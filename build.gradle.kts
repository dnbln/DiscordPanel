plugins {
    kotlin("jvm") version "1.3.72"
    id("org.jetbrains.intellij") version "0.6.4"
}


group = "org.dblanovschi.DiscordPanel"
version = "0.1.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(group = "junit", name = "junit", version = "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2020.2.3"
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
    patchPluginXml {
        changeNotes(
        """
        - Allow plugin to be run in 2020.3(203.* builds) <br/>
        - Add a way to reuse previous sessions (<a href="https://github.com/dblanovschi/DiscordPanel/issues/1">#1</a>) <br/>
        """.trimMargin())
    }
}