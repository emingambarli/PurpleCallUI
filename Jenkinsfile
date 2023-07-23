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
                    withCredentials([string(credentialsId: 'affd6850-c0eb-4f80-a06f-87db2070f60c', variable: 'kubeip')]) {
                        sshagent(credentials: ['8e38e476-5ba4-470a-bc61-134310519f8c']) {
                            sh '''
                            [ -d ~/.ssh ] || mkdir ~/.ssh && chmod 0700 ~/.ssh
                            ssh-keyscan -t rsa,dsa $kubeip >> ~/.ssh/known_hosts
                            ssh root@$kubeip hostname
                            ssh root@$kubeip whoami
                            ssh root@$kubeip pwd
                            ssh root@$kubeip rm -rf /root/PurpleCallUI
                            ssh root@$kubeip git clone https://github.com/EMN503/PurpleCallUI.git
                            ssh root@$kubeip kubectl apply -f /root/PurpleCallUI/kubernetes/deployment.yaml
                            ssh root@$kubeip rm -rf /root/PurpleCallUI
                            '''
                        }
                    }
                }
            }
        }
    }
}