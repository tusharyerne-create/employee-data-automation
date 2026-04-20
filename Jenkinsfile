pipeline {
    agent any

    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        PATH = "C:\\Program Files\\Java\\jdk-17\\bin;${env.PATH}"
        IMAGE_NAME = "admintushar/employee-app"
    }

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Verify Java') {
            steps {
                bat '''
                java -version
                mvn -v
                '''
            }
        }

        stage('Build Maven') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Login Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    bat 'echo %PASS% | docker login -u %USER% --password-stdin'
                }
            }
        }

        stage('Push Image') {
            steps {
                bat 'docker push %IMAGE_NAME%'
            }
        }
    }
}