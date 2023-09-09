# UIAutomation

Created a BDD framework using maven(3.9.4) and selenium-java(4.12.1),JAVA(17) (Tried to use latest versions ☺)

UI targeted to test - https://do1assessment-e7b0797b1bea.herokuapp.com/about

As part of this Framework tried to cover below 
1.	Create a feature file (Basic scenarios snapshot below)
2.	StepDef File which extends BaseClass, Used Before and After Hooks
3.	Generate Extent Report (latest version 5.0.9)
4.	In BaseClass

  	a) Intialised the driver which is from BaseClass, also intilaised the eventListners, Extenr Reports

  	 b) As part of BaseClass constructor added the Config file setup

  	c)Generate Date and Take Screenshot Methods
6.	In Scenario 0 

  	a) Utilised the intilisation method from BaseClass and configured driver

  	 b) Added the step to Extent Report
8.	In Scenario 1

  	a)Added a SoftAssertion

  	b)While reporting the test step status tried adding a snapshot 

  	c)Added Try/Catch block to capture the exceptions
10.	In Scenario 2

   	a)Used this scenario to come back to the Home page
12.	In Scenario 3

   	a)Clicked on the Detailed Report on home page

   	b) Then using the Passed the data [Downalod CSV] via the step

   	c) Read the latest downladed CSV file from above and tried to print some values from CSV file
14.	Also have created different pages under the PageFactory folder where defined the webElements and related methods (Tried      to use different ways of locating the objects)
15.	Have Created a Utilities folder and created java and defined methods which could be commonly used across the framework.
16.	Added a Runner file

**Feature File Snapshot**

![image](https://github.com/santhoshilaxmi/UIAutomation/assets/38223932/b1d17029-918d-4f95-a2c9-62a75705c2ea)

**Extent Report SnapShot**

![image](https://github.com/santhoshilaxmi/UIAutomation/assets/38223932/410ec068-8cd4-45a4-89c5-bb12ff8e2da5)



