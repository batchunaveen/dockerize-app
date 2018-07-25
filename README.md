# dockerize-app
dockerize sample application

```dockerfile
FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} dockerize-app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dockerize-app-0.0.1-SNAPSHOT.jar"]
```

build.gradle 
```groovy
group = 'springio'


apply plugin: 'docker'

task buildDocker(type: Docker, dependsOn: build) {
	push = true
	applicationName = jar.baseName
	dockerfile = file('src/main/docker/Dockerfile')
	doFirst {
		copy {
			from jar
			into stageDir
		}
	}
}
```