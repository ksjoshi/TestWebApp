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
              junit './web/build/reports/**/*.xml'
              junit './demoservicev1/build/reports/**/*.xml'
          }
      }
}
