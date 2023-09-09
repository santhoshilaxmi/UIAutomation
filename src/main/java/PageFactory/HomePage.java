package PageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//*[@class='nav-link'])[1]")
    WebElement Questionarie;

    @CacheLookup
    @FindBy(className = "navbar-brand")
    WebElement MaturityAssessmentLink;

    @FindBy(xpath = "(//a[@id='navBar'][@class='nav-link dropdown-toggle'][contains(text(),'Detailed Reports')])")
    WebElement DetailedReports;

    @FindBy(xpath = "//*[text()='Next']")
    WebElement Next;

    public void ClickQuestionarie() {
        Questionarie.click();
    }

    public void GotoHomepage() {
        MaturityAssessmentLink.click();
    }

    public void clickonDetailedReports() {
        DetailedReports.click();

    }

    public void clickNext() {
        Next.click();
    }


}