node {

    checkout scm

    def ms_name = 'clients'
    def ms_version = '0.0.1'
    def registry = '936603646661.dkr.ecr.us-east-2.amazonaws.com/technical-exercise'
    def registryCredential = 'awsdevelop'
    def dockerImage = ''

    stage('Test & Coverage') {
        docker.image('maven:3-jdk-8').inside('-v $HOME/.m2:/root/.m2:z -u root') {
            sh 'mvn clean test -Dmaven.test.skip=false -Djacoco-skip=false'
        }
    }

    stage('Build') {
        docker.image('maven:3-jdk-8').inside('-v $HOME/.m2:/root/.m2:z -u root') {
            sh 'mvn install'
        }
    }

    stage('Create Image and Push') {
        def app = docker.build("${registry}:${ms_version}")
        docker.withRegistry('https://936603646661.dkr.ecr.us-east-2.amazonaws.com', 'ecr:us-east-2:aws-dev') {
            app.push()
        }
    }

    //stage('Run Image') {
    //    sh "docker stop ${registry}:${ms_version}"
    //    sh "docker run -p 8087:8082 -t ${registry}:${ms_version} &"
    //}
    //stage('Remove Unused docker image') {
    //  steps{
    //    sh "docker rmi $registry:$BUILD_NUMBER"
    //  }
    //}

}
