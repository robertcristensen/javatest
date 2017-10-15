node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        app = docker.build("maven-googletest")
    }

    stage('Run Test') {
        /* Ideally, we would run a test framework against our image.
         * For this example, we're using a Volkswagen-type approach ;-) */

        app.inside {
            sh 'mvn test -Dtest=GooglePageTest'
            sh 'pwd'
            sh 'ls -la'
        }
    }
    post {
        always {
            junit 'target/surefire-reports/junitreports/*.xml'
        }
    }
}
