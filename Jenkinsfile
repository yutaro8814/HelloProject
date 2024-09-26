pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // GitHubリポジトリからコードをチェックアウト
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Gradle buildタスクを実行し、プロジェクトをビルド
                sh './gradlew clean build'
            }
        }
    }

    post {
        success {
            echo 'Build succeeded and JAR file created!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
