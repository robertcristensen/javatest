node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }
pipeline {
    agent none

        stage('RunTest') {
            agent {
                docker {
                    image 'maven:3.5.0-jdk-8'
                    args '--rm --network javatest_nw'
        }
    }
            steps {
                sh 'cd /usr/src/mymaven'
                sh 'mvn test -Dtest=GooglePageTest'
            }
        }
    }
}
   
}
