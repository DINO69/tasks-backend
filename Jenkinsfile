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
                bat 'mvn clean package -DskipTest'
            }
        }
        stage("Maven Build Projeto"){
            steps {
                withMaven(
                    maven: 'MAVEN_LOCAL'
                ) {
                    sh "mvn clean package -DskipTest"
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