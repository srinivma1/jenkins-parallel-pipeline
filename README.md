# jenkins-parallel-pipeline

# Prerequisite:
    Master and Slave node needs to be configured on CI/CD server.
    Allure Jenkins Plugin needs to be installed and configured for allure runtime.
    
# Execution Steps:
  1. Create Jenkins pipeline view. Add the pipelineGroovy script added in this github repo.
  2. Save and apply. Run the build. You will see two builds occuring one on Master and one on Slave.
  
  
  This script will checkout the Automation script from github, run maven test command and then generate allure report using Jenkins Allure PLugin.
