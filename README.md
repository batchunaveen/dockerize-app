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

Getting an Image to DockerHub 

1.Log in on https://hub.docker.com/

2.Click on Create Repository

3.Choose a name to describe 

4.Log into the Docker Hub from the command line

```dockerfile
docker login --username
password: 
```

5. Check the image 

```dockerfile
docker images
```

6.Create a tag your iamge 

```dockerfile
docker tag {image Id} username/imageName:{firstimage}
```
7 push docker image to repository 

```dockerfile
docker push usernam/imageName
```

 