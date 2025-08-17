
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build App'
            }
        }
		 stage('Test') {
            steps {
                echo 'Test App'
            }
        }
		 stage('Deploy') {
            steps {
                echo 'Deploy App'
            }
        }
    }
	post{
	 failure{
	 
	 emailext body: 'Summary', subject: 'Pipeline Status', to: '1234taraka@gmail.com'
	 
	 }
	
	
	
	
	}
}