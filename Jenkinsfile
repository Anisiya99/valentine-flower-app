pipeline {
    agent any

    stages {

        stage('Source') {
            steps {
                git 'https://github.com/Anisiya99/valentine-flower-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'cd backend && mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'cd backend && mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'cd backend && mvn package -DskipTests'
            }
        }

        stage('Docker Build & Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                    docker login -u $DOCKER_USER -p $DOCKER_PASS
                    docker build -t $DOCKER_USER/valentine-flower-app:latest .
                    docker push $DOCKER_USER/valentine-flower-app:latest
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully 🎉"
        }
        failure {
            echo "Pipeline failed ❌"
        }
    }
}
