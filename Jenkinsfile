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
    post {
            always {
                junit 'build/reports/**/*.xml'
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
    post {
            always {
                junit 'build/reports/**/*.xml'
            }
        }
  }
}