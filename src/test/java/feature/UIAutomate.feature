@UIAutomation

Feature: UI Automation
  Description: This feature file have details


# configure the browser here
  Scenario: : Configure FireFox Browser
    Given I will configure the fireFoxBower

# Scenario 1 Click on the Questionaire link and fill the details in the first page
  Scenario: Click on the Questionaire Link
    Given Click on the Questionaire Link and take Screenshot
    Then Click on the Next
    And Fill the details


# Scenario 2 Come to home page
  Scenario: Click on the Maturity Assessment
    Given Click on the Maturity Assessment


# Scenario 3 click on detailed reports and then click on DownloadCSV
  Scenario: Click on the DetailedReport
    Given Click on the detailed reports
    Then Click on the "Download CSV"
    And Read the values from the downloaded excel


    # Scenario 4 Quit the browser
  Scenario: Quit the browser
    Given Quit the browser