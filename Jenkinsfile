pipeline {
    agent any
    tools {
    maven 'MAVEN_HOME'     
    jdk 'JAVA_HOME'        
}

    stages {

        stage('Build') {
            steps {
                git 'https://github.com/TarakaPhaneendra/PracticeJenkins.git'
                bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Deploy to QA') {
            steps {
                echo "Deploying to QA..."
            }
        }

        stage('Run Regression Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/TarakaPhaneendra/PracticeJenkins.git'
                   
                    bat 'mvn clean test -Dsurefire.suiteXmlFiles=src//test//java//testrunners//testng_regressions.xml'
                    
                }
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'target/extent-report', // Update this as per your actual report path
                    reportFiles: 'TestExecutionReport.html',
                    reportName: 'HTML Extent Report',
                    reportTitles: ''
                ])
            }
        }
    }
}
