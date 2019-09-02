pipeline {
  agent any
  stages {
    stage('build web') {
      steps {
        sh '''
            cd ./web
            ./gradlew clean build --debug
        '''
      }
    }
  }
}