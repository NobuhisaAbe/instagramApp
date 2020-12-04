import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "com.nobuhisaabe.instagram"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
	implementation("com.squareup.retrofit2:retrofit:2.4.0")
	implementation("com.squareup.retrofit2:converter-jackson:2.4.0")
	implementation("com.squareup.okhttp3:okhttp:3.11.0")
	implementation("com.squareup.okhttp3:logging-interceptor:3.8.1")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.9.8")
	implementation("com.slack.api:slack-api-client:1.4.0")
	implementation("com.slack.api:slack-api-model-kotlin-extension:1.4.0")
	implementation("com.slack.api:slack-api-client-kotlin-extension:1.4.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
