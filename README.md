# Spring Boot Application Dockerization

This project contains a Spring Boot application that is Dockerized using a multi-stage Dockerfile. The Dockerfile uses JDK 21 and Maven 4 to build and run the application.

## Prerequisites

Before you start, make sure you have the following installed on your system:

- Docker
- Git (optional, for cloning the repository)

## Cloning the Repository

If you haven't cloned the repository yet, you can do so using the following command:

```bash
git clone https://github.com/youssef-tarek-abdelaziz/Task-Management.git
cd your-repo-name
```

## Building the Docker Image

To build the Docker image from the Dockerfile, run the following command in the root directory of the project (where the Dockerfile is located):

```bash
docker build -t task_management .
```

## Running the Docker Container

Once the image is built, you can run a Docker container from the image using the following command: 

```bash
docker run -p 8080:8080 task_management

```

Accessing the Application

After running the container, the Spring Boot application will be accessible at http://localhost:8080. If you mapped a different port, replace 8080 with the port number you chose.

