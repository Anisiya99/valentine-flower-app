pipeline {
    agent any

    stages {

        stage('SOURCE') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Anisiya99/valentine-flower-app.git'
            }
        }

        stage('BUILD') {
            steps {
                sh 'mvn clean compile -f backend/pom.xml'
            }
        }

        stage('TEST') {
            steps {
                sh 'mvn test -f backend/pom.xml'
            }
        }

        stage('PACKAGE') {
            steps {
                sh 'mvn package -f backend/pom.xml'
                sh 'docker build -t yourname/valentine-flowers:1.0 .'
            }
        }

        stage('DEPLOY') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully 🚀'
        }
        failure {
            echo 'Pipeline failed ❌'
        }
    }
}

