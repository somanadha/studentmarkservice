pipeline {
    agent any
    environment {
        APP_NAME = "studentmarkservice"
        APP_NAMESPACE = "${APP_NAME}-ns"
        IMAGE_NAME = "${APP_NAME}-image"
        IMAGE_TAG = "${BUILD_NUMBER}${BUILD_NUMBER}"
        APP_PORT = 8100
        NODE_PORT = 30081
        REPLICA_COUNT = 2
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/somanadha/studentmarkservice.git'
            }
        }
        stage('Build') {
            steps {
                // Build docker image using Dockerfile
                bat "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} -f Dockerfile ."
            }
        }
        /*
        stage('Run Container') {
            steps {
                script {
                    // Run docker container instance
                    bat "docker run -d --name ${APP_NAME} -p 8100:8100 ${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
        }
        */
        stage('K8s Container Deployment') {
            steps {
                script {
                    withEnv(["KUBECONFIG=c:\\users\\test\\.kube\\config"]) {
                        // Replace variables in YAML and create concrete files:
                        bat "envsubst < k8s/namespace-template.yaml > k8s/namespace.yaml"
                        bat "envsubst < k8s/deployment-template.yaml > k8s/deployment.yaml"
                        bat "envsubst < k8s/service-template.yaml > k8s/service.yaml"

                        // Apply manifests
                        bat "kubectl apply -f k8s/namespace.yaml --validate=false"
                        bat "kubectl apply -f k8s/deployment.yaml --validate=false"
                        bat "kubectl apply -f k8s/service.yaml --validate=false"
                    }
                }
            }
        }
    }
    post {
        success {
            echo "✅ Checkout, Build, Dockerize & Deploy completed successfully!"
        }
        failure {
            echo "❌ Build failed!"
        }
    }
}
