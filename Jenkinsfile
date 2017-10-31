#!groovy

pipeline {
    agent any
 
    parameters {
        string(name: 'DOCKER_NAME', defaultValue: 'mars-exploration-rovers', description: 'Nome da imagem docker')
        string(name: 'DOCKER_VERSION', defaultValue: 'latest', description: 'Versao da imagem docker')
        string(name: 'REGISTRY_USERNAME', defaultValue: 'changeme', description: 'Usuario do DockerHub')
        password(name: 'REGISTRY_PASSWD', defaultValue: 'changeme', description: 'Senha do DockerHub')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                maven {
                    goals('clean')   
                    goals('install')
                }
            }
        }

        stage('Build Image Docker') {
            steps {
                sh "docker build -t ${DOCKER_NAME}:${DOCKER_VERSION} -f Dockerfile ."
            }
        }

        stage('Push DockerHub') {
            steps {
                sh "docker login -u ${REGISTRY_USERNAME} -p ${REGISTRY_PASSWD}"
                sh "docker tag ${DOCKER_NAME}:${DOCKER_VERSION}"
                sh "docker push ${DOCKER_NAME}:${DOCKER_VERSION}"
            }
        }
    }
}
