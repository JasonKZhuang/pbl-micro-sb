pipeline {
    agent any
    
    stages {
//         stage('Checkout') {
//             steps {
//                 git 'https://github.com/JasonKZhuang/pbl-micro-sb.git'
//             }
//         }
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
