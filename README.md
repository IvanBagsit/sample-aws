this project was created to practice and test containerization like Docker and deployment/use of AWS

Notes if there's changes:
1. run the following to create a new/updated JAR file: "./mvnw clean package"
2. build the docker image: "docker build -t sample-aws ."
3. run the image: "docker run -p 8080:8080 sample-aws"