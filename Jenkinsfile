pipeline {
  agent any
  stages {
    stage('build service') {
          steps {
            sh '''
                cd ./demoservicev1
                ./gradlew clean build
            '''
          }
        }

    stage('build web') {
      steps {
        sh '''
            cd ./web
            ./gradlew clean build
        '''
      }
    }

  }
  post {
           always {
               publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '**/build/reports/tests/', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
               junit '**/build/test-reports/*.xml'
           }
       }
 }
