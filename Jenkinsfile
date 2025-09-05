pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/tollytols/NumberGuessGame.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat-creds',
                                          path: '',
                                          url: 'http://localhost:8081')],
                       contextPath: 'NumberGuessGame',
                       war: '**/target/*.war'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.war', followSymlinks: false
        }
    }
}
