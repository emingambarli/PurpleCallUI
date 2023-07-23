pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
               docker {
                image 'maven:latest'
                args '-u root'
            }
        }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            agent {
               docker {
                image 'maven:latest'
                args '-u root'
            }
        } 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
    

        stage("Build Docker images for purplecall") {
            agent any
            steps {
                script{
                    withCredentials([usernamePassword(credentialsId: '9f61e6b7-5097-4c38-b981-90571314ce51', passwordVariable: 'dockerpasswd', usernameVariable: 'dockerusr')]) {
                        sh '''
                        echo ${BUILD_ID}
                        sudo docker build -t emn503/loginapp:${BUILD_ID} .
                        sudo docker build -t emn503/loginapp:latest .
                        sudo docker login -u $dockerusr -p $dockerpasswd
                        sudo docker push emn503/loginapp:${BUILD_ID}
                        sudo docker push emn503/loginapp:latest
                        sudo docker rmi emn503/loginapp:${BUILD_ID}
                        '''
                    }
                }

            }
        }

        stage("Kubernetes Deployment"){
            agent any
            steps {
                script{
                    sshagent(credentials: ['8e38e476-5ba4-470a-bc61-134310519f8c']) {
                            sh '''
                            kubectl apply -f deploy.yaml
                            '''
                        }
                    }
                }
            }
    }
}