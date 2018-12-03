plugins {
    java
    id("net.minecrell.licenser") version "0.4.1"
    id("net.minecrell.plugin-yml.bungee") version "0.3.0"
}

group = "eu.mikroskeem"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()

    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    implementation("net.md-5:bungeecord-api:1.13-SNAPSHOT")
}

license {
    header = rootProject.file("etc/HEADER")
    filter.include("**/*.java")
}

bungee {
    name = "ServernameCommands"
    main = "eu.mikroskeem.servernamecommands.ServernameCommands"
    author = "${listOf("mikroskeem")}"
    description = "Link servers to commands easily"
}