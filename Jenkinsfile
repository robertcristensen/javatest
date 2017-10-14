node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        app = docker.build("maven-googletest").withRun('-e "SELENIUM_HUB_EP=18.216.8.56:4446" -v /tmp/.m2:/root/.m2')
    }

    stage('Run Test') {
        /* Ideally, we would run a test framework against our image.
         * For this example, we're using a Volkswagen-type approach ;-) */

        app.inside {
            sh 'mvn test -Dtest=GooglePageTest'
        }
    }
}
