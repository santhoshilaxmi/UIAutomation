package PageFactory;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Questionaire extends BaseClass {
    public Questionaire() {
        PageFactory.initElements(driver, this);
    }


    //Yes buttom for ..... availle in 1-02 weeks
    @FindBy(xpath = "//*[@type='radio']/following-sibling::label[@for='S2-Q1-A1']")
    WebElement Yesfor1to2weeks;


    //check boxes for Which of the following are measured by the team (tick all that apply)?
    // /following-sibling::label[@for='S2-Q2-A1']
    // Elapsed lead time to deliver valuable changes (from initial request to production)
    @FindBy(xpath = "//*[@name='S2-Q2-A1'][@for='S2-Q2-A1']")
    WebElement checkbox1;

    // Frequency of deployments into production
    @FindBy(xpath = "//*[@name='S2-Q2-A2'][@for='S2-Q2-A2']")
    WebElement checkbox2;

    // Change failure rate

    @FindBy(xpath = "//*[@name='S2-Q2-A3'][@for='S2-Q2-A3']")
    WebElement checkbox3;

    // Time to restore service after a failure
    @FindBy(xpath = "//*[@name='S2-Q2-A4'][@for='S2-Q2-A4']")
    WebElement checkbox4;

    @FindBy(xpath = "//*[text()='Next']" )
    WebElement Next;

    public void clickcheckbox4() {
        checkbox4.click();
    }

    public void clickcheckbox3() {
        checkbox3.click();
    }
    public void clickYesfor1to2weeks() {
        Yesfor1to2weeks.click();
    }

    public void clickNext() {
        Next.click();
    }





}
