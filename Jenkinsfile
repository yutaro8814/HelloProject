pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // GitHubリポジトリからコードをチェックアウト
                checkout scm
            }
            steps {
                echo finished
            }
        }
    }
}
