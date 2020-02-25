pipeline {
   agent any

   stages {
   
   stage('Git checkout') {
   steps {
      git 'https://github.com/shasa1/CID-proj.git'
      }
   	}
  
  
   stage('Build') {
        steps {
          echo 'Building...'
          echo "Running ${env.BUILD_ID} ${env.BUILD_DISPLAY_NAME} on ${env.NODE_NAME} and JOB ${env.JOB_NAME}"
        }
   }
      
   
    stage('Smoke') {
    steps {
        try {
            sh "mvn clean test"
        } catch (err) {
            
        } finally {
            publishHTML (target: [
            reportDir: 'target/surefire-reports',
            reportFiles: 'index.html',
            reportName: "Smoke tests report"
            ])
        }
        }
   }
   
  stage('Results') {
  steps {
      junit '**/test-output/index.html'
   }
   }
  }
  
}
