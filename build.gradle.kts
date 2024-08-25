plugins {
    kotlin("jvm") version "2.0.0"
    id("maven-publish")
}

group = "com.github"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(files("libs/apksigner/0.9/apksigner.jar"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            artifact(file("libs/apksigner/0.9/apksigner.jar")) {
                classifier = "apksigner"
            }
        }
    }
}