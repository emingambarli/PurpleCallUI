pipeline {
    agent {
        docker {
                image 'maven:latest'
                args '-v /root/.m2:/root/.m2'
            }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
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
            steps {
                script{
                    withCredentials([usernamePassword(credentialsId: 'a4b0f15b-5736-4f66-998d-238687ce3d99', passwordVariable: 'dockerpass', usernameVariable: 'dockeruser')]) {
                        sh '''
                        echo ${BUILD_ID}
                        sudo docker build -t emn503/loginapp:${BUILD_ID} .
                        sudo docker build -t emn503/loginapp:latest .
                        sudo docker login -u $dockeruser -p $dockerpass
                        sudo docker push emn503/loginapp:${BUILD_ID}
                        sudo docker push emn503/loginapp:latest
                        sudo docker rmi emn503/loginapp:${BUILD_ID}
                        '''
                    }
                }

            }
        }

        stage("Kubernetes Deployment"){
            steps {
                script{
                    withCredentials([(credentialsId: 'a4b0f15b-5736-4f66-998d-238687ce3d99', passwordVariable: 'dockerpass', usernameVariable: 'dockeruser')]) {
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
}