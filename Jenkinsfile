pipeline {
    agent any
    options {
      buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('For the fix branch'){
            when {
                branch 'fix-*'
            }
            steps {
                sh '''
                   cat README.md
                '''
            }
        }
        stage('For the PR'){
            when {
                branch 'PR-*'
            }
            steps {
                echo 'this is only for the PRs'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
