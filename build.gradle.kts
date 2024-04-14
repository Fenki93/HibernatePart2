plugins {
    id("java")
}

group = "org.ddiachenko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.flywaydb:flyway-core:10.10.0")
    runtimeOnly("org.flywaydb:flyway-database-postgresql:10.10.0")

    implementation("org.hibernate.orm:hibernate-core:6.4.4.Final")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")

    implementation("org.postgresql:postgresql:42.7.1")

    compileOnly("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useJUnitPlatform()
}