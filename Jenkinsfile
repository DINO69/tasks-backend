pipeline{
    agent any
    stages{
        stage("Check Projeto"){
            steps {
                echo "Check Projeto"
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