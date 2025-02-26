pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Alvaade/TrainingSessionTracker.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
