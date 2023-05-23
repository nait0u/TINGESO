pipeline{
    agent any
    tools {
        maven "maven"
    }
    stages{
        stage(BUILD JAR FILE){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nait0u/TINGESO']])
                dir("Pep1"){
                    sh "mvn clean install"
                }
            }
        }
        stage("Test"){
            steps{
                dir("Pep1"){
                    sh "mvn test"
                }
            }
        }
        stage("SonarQube Analysis"){
            steps{
                dir("Pep1"){
                    sh "mvn clean verify sonar:sonar  -Dsonar.projectKey=pep1 -Dsonar.host.url=http://localhost:9000  -Dsonar.login=sqp_4711e2751e5345997677cf901dc199688af57620"
                }
            }
            
        }
        stage("Build Docker Image"){
            steps{
                dir("Pep1"){
                    sh "docker build -t nait0u/pep1 ."
                }
            }
        }
        stage ("Push Docker Image"){
            steps{
                dir("Pep1"){
                    withCredentials([string(credentialsId: 'dckrhubpassword', variable: 'dckpass')]){
                        sh "docker login -u nait0u -p ${dckpass}"
                    }
                    sh "docker push nait0u/pep1"
                }
            }
        }
        post{
            always{
                dir("Pep1"){
                    sh "docker logout"
                }
            }
        }
    }
}