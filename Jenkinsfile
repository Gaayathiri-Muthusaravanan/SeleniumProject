pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out Selenium project'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '*/target/surefire-reports/.xml'
            }
        }
    }

    post {
        always {
            echo 'Automation execution completed'
        }
    }
}