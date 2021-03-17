pipeline {
    agent any
    environment {
        imageName = ""
    }
    stages {
        stage('Step 1 Git') {
            steps {
                git 'https://github.com/ParijatMoulik/ScientificCalculator.git'

            }
        }
         stage('Step 2 Maven') {
            steps {

                 sh 'mvn clean install'
            }
        }
         stage('Step 3 Test')
         {
             steps {

                 sh 'mvn test'
             }
             post{
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
             }
         }

         stage('Step 4 Docker_Image')
          {
              steps {
                  script {
                    imageName = docker.build "jerry11/calculator:latest"
                    }
              }
          }

         stage('Step 5 Push Docker Image')
        {
            steps {
                script{
                  docker.withRegistry('', 'jenkins-docker') {
                       imageName.push()
                  }
                }
            }
        }
        stage('Step 6 Ansible'){
            steps{
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'deploy-docker/inventory', playbook: 'deploy-docker/deploy-image.yml', sudoUser: null
            }
        }
    }
}

