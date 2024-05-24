plugins {
    id("java")
    id("application")
}

group = "mop"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.oracle.database.jdbc:ojdbc6:11.2.0.4")
}

tasks.test {
    useJUnitPlatform()
}

// Explicitly apply the application plugin
configure<ApplicationPluginConvention> {
    // Specify the main class
    mainClassName = "mop.Main"
}
