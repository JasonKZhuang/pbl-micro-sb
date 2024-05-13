pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout ...'
            }
        }
        stage('Maven Build') {
            steps {
                echo 'Building..'
                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
               
            }
            post {
                always {
                    echo 'Post Testing..'
                }
            }
        }
       stage('Docker Image') {
             steps {
                echo 'Building docker image ...'
                
             }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...., should run docker run command to upload to dockerhub'
            }
        }
    }
}
