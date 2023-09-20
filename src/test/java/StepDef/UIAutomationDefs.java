package StepDef;

import PageFactory.Questionaire;
import base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import PageFactory.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
//import org.

import utilities.FileUtilities;
import utilities.SeleniumActions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.NoSuchElementException;

public class UIAutomationDefs extends BaseClass {

    HomePage homepage = new HomePage();
    Questionaire Ques = new Questionaire();
    FileUtilities ff = new FileUtilities();
    ExtentTest node;


    @Before
    public void setup(){

        System.out.println("I am the Before Tag and I started the Run");

    }

    @Given("I will configure the fireFoxBower")
    public void iWillConfigureTheFireFoxBower() {
        initializaton();


    }

    @Given("Click on the Questionaire Link and take Screenshot")
    public void clickOnTheQuestionaireLinkAndTakeScreenshot() {

        try {
            test = reports.createTest("Click on Questionarie and take Screenshot");
            node = test.createNode("Verify if we are on Questionarie page");
            homepage.ClickQuestionarie();
            System.out.println(softassert.assertThat(driver.findElement(By.xpath(" //*[contains(text(),'your DevOps journey')]")).getText()).contains("Santhoshi").toString());

            if (driver.findElement(By.xpath(" //*[contains(text(),'your DevOps journey')]")).isDisplayed()) {
                node.log(Status.PASS, MarkupHelper.createLabel("We are in next page when clicked on Questionaire ", ExtentColor.GREEN));
                takeScreenShot(driver, "QuesPass.png");
                node.addScreenCaptureFromPath(SCREENSHOT_PATH + "QuesPass.png");
            }
        }catch (NoSuchElementException e){

            System.out.println("No such element is present");
            node.log(Status.FAIL, MarkupHelper.createLabel("We are NOT in next page when clicked on Questionaire ", ExtentColor.RED));
            takeScreenShot(driver, "QuesPass.png");
            node.addScreenCaptureFromPath(SCREENSHOT_PATH + "QuesPass.png");

        }catch (Exception e){

            System.out.println("There is some error");

        }

    }

    @Given("Click on the Maturity Assessment")
    public void clickOnTheMaturityAssessment() {

       homepage.GotoHomepage();

    }


    @Given("Click on the detailed reports")
    public void clickOnTheDetailedReports() {

        homepage.clickonDetailedReports();
    }

    @Then("Click on the {string}")
    public void clickOnThe(String clickOn) {
        driver.findElement(By.xpath("(//*[contains(text(),'Download CSV')])")).click();

    }


    @After
    public void tearDown(){
        System.out.println("I am the After Tag and I completed the RUN");
        reports.flush();

    }


//    @Then("Click on this element")
//    public void clickOnThisElement(DataTable dataTable) {
//        List<Map<String,String>> row = dataTable.asMaps();
//
//        for(Map<String,String> col : row){
//            homepage.clickNext(col.get("ElementNameinHomePage"));
//        }
//
//    }

    @Then("Click on the Next")
    public void clickOnTheNext() {
        homepage.clickNext();
    }

    @And("Fill the details")
    public void fillTheDetails() {

        Ques.clickYesfor1to2weeks();
        Ques.clickcheckbox3();
        Ques.clickcheckbox4();
        Ques.clickNext();

    }

    @And("Read the values from the downloaded excel")
    public void readTheValuesFromTheDownloadedExcel() throws Throwable {
        String LatestFileName = ff.getTheLatestFileName();
        System.out.println("++++ Latest Downlaoded CSV file is at "+LatestFileName+"  ++++++");
        ff.readCSVFile(LatestFileName);

    }

    @Given("Quit the browser")
    public void quitTheBrowser() {

          tearDownMain();
    }
}
