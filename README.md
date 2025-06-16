# Description
this project was created to practice and test containerization like Docker and deployment/use of AWS or GCP

# Build and run using docker locally
1. run the following to create a new/updated JAR file: "./mvnw clean package -DskipTests"
2. build the docker image: "docker build -t sample-aws ."
3. run the image: "docker run -p 8080:8080 sample-aws"

# Build and run using GCP's Cloud Run
1. Install and setup gCloud CLI in WSL2
2. Create a Dockerfile
3. ./mvnw clean package -DskipTests (creates jar file)

list all projects and project_id available  
```gcloud projects list```

authenticates local docker to gcloud  
```gcloud auth configure-docker```  
```gcloud auth configure-docker us-central1-docker.pkg.dev```

create an artifact repository (if not existing):  
```gcloud artifacts repositories create sample-cloud-artifact --repository-format=docker --location=us-central1 --description="sample-cloud-docker-image”```  
**Note:** image name for GCP follows a specific naming convention (Google Artifact Registry)
```REGION/PROJECT_ID/REPOSITORY/IMAGE_NAME/TAG (optional)```  

build the docker image  
```docker build -t us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo .```  

push the docker image to Google Artifact Registry  
```docker push us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo```  

deploy to cloud run  
```gcloud run deploy demo --image=us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo --platform=managed --region=us-central1 --allow-unauthenticated```  

**Note:** After a few moments, GCP will give you a public HTTPS URL to access the project  
sample: [https://demo-1037725188793.us-central1.run.app](https://demo-1037725188793.us-central1.run.app/)

### if there will be changes to the project do below instructions  
1. ```./mvnw clean package -DskipTests```
2. ```docker build -t us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo .```
3. ```docker push us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo```
4. ```gcloud run deploy demo —image=us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo —platform=managed —region=us-central1 —allow-unauthenticated```