pipeline {
    agent any

    // Pipeline Parameters
    parameters {
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build')
        choice(name: 'ENVIRONMENT', choices: ['dev', 'qa', 'prod'], description: 'Target Environment')
        booleanParam(name: 'RUN_TESTS', defaultValue: true, description: 'Execute Tests?')
        text(name: 'CUSTOM_MESSAGE', defaultValue: 'Default build message', description: 'Custom build note')
    }

    environment {
       TESTER_NAME = "RK"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out branch: ${params.BRANCH_NAME}"
                git branch: "${params.BRANCH_NAME}", url: 'https://github.com/kreetanshu/selenium-java-practice.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building application for ${params.ENVIRONMENT}"
//                 sh '''
//                     mvn clean compile -Denv=${ENVIRONMENT}
//                 '''
                script {
                    env.BUILD_STATUS = 'SUCCESS'
                }
            }
            post {
                failure {
                    script { env.BUILD_STATUS = 'FAILED' }
                }
            }
        }
    }

    post {
        always {
            echo "Cleaning up workspace"
            cleanWs()
//             emailext (
//                 subject: "Build ${currentBuild.currentResult}: ${env.JOB_NAME}",
//                 body: """
//                 Build Status: ${currentBuild.currentResult}
//                 Environment: ${params.ENVIRONMENT}
//                 Message: ${params.CUSTOM_MESSAGE}
//                 Console: ${BUILD_URL}
//                 """,
//                 to: 'team@example.com'
//             )
        }
        success {
            echo "Pipeline completed successfully!"

        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
