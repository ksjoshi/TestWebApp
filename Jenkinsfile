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
    stage ('Install dependencies') {
      steps {
            sh "apk add nodejs"
            sh "echo $PATH"
            sh "npm install"
        }
    }

    stage('build web') {
      steps {
        sh '''
            cd ./web
            ./gradlew clean build -x npmSetup -x npmInstall -x :npm_build
        '''
      }
    }
  }
}