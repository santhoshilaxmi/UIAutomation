package base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utilities.SeleniumActions;
import utilities.WebDriverListener;

public class BaseClass {

    protected static WebDriver driver;
    protected static Properties properties;
    protected static SeleniumActions sele_Actions;

    protected  static ExtentReports reports;
    protected static WebDriverListener eventListener;
    public static EventFiringWebDriver e_driver;

    public static String setReportFileName = "";

    public static final long PAGE_LOAD_TIMEOUT = 100;

    public static final long IMPLICIT_WAIT = 10;

    public static ExtentTest test;
    public static final String WORKSAPCE_PATH = "C://MavenDemoProject";

    public static final String SCREENSHOT_PATH = WORKSAPCE_PATH + "//Screenshot//";
    public static  SoftAssertions softassert;
    public static final String DateFormat = "yyyyMMddHHmmss";

    public BaseClass() {

        try {
            properties = new Properties();
            FileInputStream inputs = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
            properties.load(inputs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("io exception");

        }

    }

    protected static void initializaton() {
        System.out.println("I am in the initialisation method");

        reports = new ExtentReports();
        setReportFileName = System.getProperty("user.dir")+"/result/"+"UI_Automation_Report_"+getDate(DateFormat)+".html";
        System.setProperty("org.freemarker.loggerLibrary","none");
        ExtentSparkReporter htmlreporter = new ExtentSparkReporter(setReportFileName);
        reports.attachReporter(htmlreporter);

        try{

            //craete instance of the firefox webdriver
            driver = getDriver();
            System.out.println("I initialiased driver now ");

            //driver is resposible for triggering the actions
            //EventFiringWebDriver is responsible for the actions
            // we have a listner calss to listen to these EventFiringWebDriver
            // and to listen we need register the listener to EventFiringWebDriver

            ////***** commenting them for now as it prints too much info in console
//            e_driver = new EventFiringWebDriver(driver);
//            eventListener = new WebDriverListener();
//            e_driver.register(eventListener);
//            driver = e_driver;

            //************

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

            driver.get(properties.getProperty("url"));

            sele_Actions = new SeleniumActions();

            softassert = new SoftAssertions();

            test = reports.createTest("FireFox driver is Initialised");
            test.log(Status.PASS, MarkupHelper.createLabel("I am generated ", ExtentColor.GREEN));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }





    }

    private static WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
        return new FirefoxDriver();

    }

    public void tearDownMain() {
        driver.manage().deleteAllCookies();
        driver.close();
    }


    public static String getDate(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    public static void takeScreenShot(WebDriver driver, String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(SCREENSHOT_PATH + name));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
