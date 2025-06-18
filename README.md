# Description
this project was created to practice and test containerization like Docker and deployment/use of AWS or GCP

# Build and run using docker locally
1. run the following to create a new/updated JAR file: "./mvnw clean package -DskipTests"
2. build the docker image: "docker build -t sample-aws ."
3. run the image: "docker run -p 8080:8080 sample-aws"

# GCP useful commands
login/authenticate to gcp  
```gcloud auth login```

list all projects and project_id available  
```gcloud projects list```

authenticates local docker to gcloud  
```gcloud auth configure-docker```  
```gcloud auth configure-docker us-central1-docker.pkg.dev```  

set default project  
```gcloud config set project [PROJECT_ID]```  

view current config  
```gcloud config list```  

create an artifact repository (if not existing):  
```gcloud artifacts repositories create sample-cloud-artifact --repository-format=docker --location=us-central1 --description="sample-cloud-docker-image”```  

# Notes
image name for GCP follows a specific naming convention:  
**Google Artifact Registry (New)**
```REGION.pkg.dev/PROJECT_ID/REPOSITORY/IMAGE_NAME[:TAG] (tag is optional)```  
**Google Container Registry (Old - GCR)**
```REGION.gcr.io/PROJECT_ID/IMAGE_NAME[:TAG] (tag is optional)```   

# GKE related commands
enable GKE API  
```gcloud services enable container.googleapis.com```  

install gke-gcloud-auth-plugin to authenticate kubectl client  
```sudo apt-get install google-cloud-sdk-gke-gcloud-auth-plugin```

create GKE cluster  
```gcloud container clusters create springboot-cluster```  

create auto-pilot cluster in a free region (e.g., us-central1)
```gcloud container clusters create-auto spring-cluster --region us-central1```

list all available clusters  
```gcloud container clusters list```

configure local kubectl to use a cluster  
```gcloud container clusters get-credentials YOUR_CLUSTER_NAME --region YOUR_CLUSTER_REGION```  

# Build and run using GCP's Cloud Run
1. Install and setup gCloud CLI and Docker in WSL2
2. Create a Dockerfile
3. ./mvnw clean package -DskipTests (creates jar file)

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
4. ```gcloud run deploy demo --image=us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo --platform=managed --region=us-central1 --allow-unauthenticated```  

# Build and run using GCP's Kubernetes
1. Install and setup gCloud CLI, gke-gcloud-auth-plugin and Docker in WSL2
2. Create a Dockerfile
3. ./mvnw clean package -DskipTests (creates jar file)

build the docker image  
```docker build -t us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo .```

push the docker image to Google Artifact Registry  
```docker push us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo```

create a deployment yaml file and apply it
```kubectl apply -f <deployment.yml>```

### if there will be changes to the project do below instructions
1. ```./mvnw clean package -DskipTests```
2. ```docker build -t us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo .```
3. ```docker push us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo```
4. ```kubectl set image deployment/demo demo=us-central1-docker.pkg.dev/sample-cloud-463104/sample-cloud-artifact/demo:latest```  
5. if changes is made to deployment.yaml file do ```kubectl apply -f <deployment.yaml>```