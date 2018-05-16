parallel(
  "task1": {
  node("master") {
   
   stage('Checkout') { 
      
     checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/endless-qa/webdriver-examples-java.git']]]
  
   }
   stage('Build') {
      // Run the maven build
     bat '''cd AllureTestNGexamples
     mvn -Dmaven.test.failure.ignore=true clean test'''
   }
   stage('Results') {
      allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]
   }
}
}, "task2": {
  node("slave") {
   
   stage('Checkout') { 
      
     checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/endless-qa/webdriver-examples-java.git']]]
  
   }
   stage('Build') {
      // Run the maven build
     bat '''cd AllureTestNGexamples
     mvn -Dmaven.test.failure.ignore=true clean test'''
   }
   stage('Results') {
      allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]
   }
}
})