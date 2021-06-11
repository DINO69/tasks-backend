pipeline{
    agent any
    stages{
        stage("Check Projeto"){
            steps {
                echo "Check Projeto"
            }
        }
        stage("Build Projeto"){
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage("Maven Build Projeto"){
            steps {
                withMaven(
                    maven: 'MAVEN_LOCAL'
                ) {
                    sh "mvn clean package -DskipTests=true"
                }
            }
        }
        stage("Test Projeto"){
            steps {
                echo "Test Projeto"
            }
        }
    }
    post{
        always{
            echo "Check always"
        }
        success{
            echo "Post - Sucess"
        }
        failure{
            echo "Post - failure"
        }
    }

}