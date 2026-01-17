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
       ENVIRONMENT = "${params.ENVIRONMENT}"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
               checkout scm
            }
        }

        stage('Build and Package') {
            steps {
                echo "Building application for ${params.ENVIRONMENT}"
                
                bat ' mvn clean compile package -Denv=${ENVIRONMENT}'
                // sh '''
                //     mvn clean compile -Denv=${ENVIRONMENT}
                // '''
    
            }
            post {
                 always {
            echo 'Archiving artifacts and test reports...'

            // Archive JAR files
            archiveArtifacts artifacts: '**/target/*.jar'//, fingerprint: true

            // Publish Surefire test results
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            }

           success {
             echo 'Build and package completed successfully!'
           }
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
    }
}
