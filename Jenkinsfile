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
                sh 'JAVA_HOME=/usr/lib/jvm/jre-17-openjdk'
                sh 'PATH+EXTRA=$JAVA_HOME/bin'
                // gradlewに実行権限を付与
                sh 'chmod +x gradlew'
                // Gradle buildタスクを実行し、プロジェクトをビルド
                sh './gradlew clean jar'
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
