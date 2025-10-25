pipeline {
    // Requires a Jenkins agent that has Java and Maven installed.
    agent any 

    tools {
        // Must match the name of the Maven installation configured in Jenkins
        maven 'M3' 
        // Ensure you have a JDK installed as well
        jdk 'java17' 
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code from SCM...'
                // Replace this with your actual Git checkout step (e.g., git branch: 'main', url: '...')
                script {
                    checkout scm
                }
            }
        }

        stage('Build & Package') {
            steps {
                echo 'Building the WAR artifact using Maven...'
                // The 'clean package' goal compiles the source and packages it into target/hello-app.war
                sh 'mvn clean package'
            }
            post {
                // Ensure the artifact is archived for manual inspection if needed
                success {
                    archiveArtifacts artifacts: 'target/*.war', fingerprit: true
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying WAR file to Tomcat server...'
                // Requires the 'Deploy to Container Plugin'
                // contextPath: defines the URL path (e.g., /hello-app)
                // credentialsId: The ID of the Tomcat manager user/password defined in Jenkins Credentials
                // war: Specifies the path to the WAR file produced by the Maven build
                deploy adapters {
                    // Replace 'tomcat-remote' with your configured Tomcat server name 
                    // and 'tomcat-credentials' with the ID of your Tomcat Manager credentials
                    tomcat8(
                        credentialsId: 'tomcat-credentials',
                        url: 'http://<TOMCAT_HOST_IP_OR_NAME>:8080' 
                    ) {
                        war 'target/hello-app.war'
                        contextPath 'hello-app' // This will make the app accessible at http://...:8080/hello-app/hello
                    }
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline finished.'
        }
        failure {
            echo 'Deployment failed! Check build logs for errors.'
        }
        success {
            echo 'Application successfully built and deployed!'
        }
    }
}
