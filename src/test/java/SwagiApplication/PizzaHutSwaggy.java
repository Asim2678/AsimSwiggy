package SwagiApplication;

import ITestListners.TestListeners;
import SwiggyPO.LandingPage_PO;
import SwiggyPO.PizzaHut_PO;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
@Listeners(TestListeners.class)

public class PizzaHutSwaggy {
    // ChromeOptions chromeOptions;
    WebDriver driver;
    String appURL;
    @BeforeClass
    public void ExportDucrStrt() {
        System.out.println("Swiggy application Test Has Started");
    }

    @AfterClass
    public void ExportDucrEnd() {
        System.out.println("Swiggy application Test Has Ended");
    }

    @BeforeMethod
    public void testBegins() {
        System.out.println("-------------------New Test Starts--------------------------------------");
    }

    @AfterMethod
    public void testEnds() {
        System.out.println("-------------------Test Execution completes -----------------------------");
    }
    ExtentHtmlReporter htmlReporter;

    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;

    @Parameters({ "OS", "browser" })
    @BeforeTest
    public void startReport(String OS, String browser) {
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", OS);
        extent.setSystemInfo("browser", browser);


        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");

        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }


// this also be used as Before Test
    @BeforeClass
    public void LaunchBrowser() {
        System.out.println("Launch Browser");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mabassra.SCT\\Downloads\\Drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        //WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        appURL = "https://www.swiggy.com/";
        driver.get(appURL);
        driver.getTitle();
        String SwiggyTitle = driver.getTitle();
        System.out.println(SwiggyTitle);

    }

    @Test(priority = 1)
    public void ChooseAhmedabad() {
        test = extent.createTest("ChooseAhmedabad");
        // User clicks on the 'Ahmadabad' link on the home page, landing page of Swaggy.com
        LandingPage_PO SwiggyHomepage = new LandingPage_PO(driver);
        SwiggyHomepage.Select_Ahmadabad();

        SwiggyHomepage.AhmadabadOnlineFoodTitle();
        test.log(Status.INFO,"Ahmandabad location is selected and cicked");

    }

    @Test(priority = 2)
    public void SelectPizaHut() {
        // User clicks on o PIZZA HUT
        test = extent.createTest("SelectPizaHut");
        PizzaHut_PO PizzaSelection = new PizzaHut_PO(driver);
        PizzaSelection.setSelectPizza();

        PizzaSelection.PizzaHutElementTitle();

        String ActualPizhutt = PizzaSelection.PizzaHutTitle();
       System.out.println(ActualPizhutt);
        String ExpectedPizahut = "Pizza Hut | Home delivery | Order online | Chandkheda Chandkheda Ahmedabad";
        Assert.assertEquals(ExpectedPizahut, ActualPizhutt, "Title of Piza hut does is not verified");
        test.log(Status.INFO,"PizaHut Foodstore is selected for order");

    }
@Test(priority = 3)
public void SetLocation() throws InterruptedException {
        //driver.findElement(By.xpath("//span[@class='_3HusE']")).click();
    PizzaHut_PO PizzaSelection = new PizzaHut_PO(driver);

    PizzaSelection.SearchforAhmadabad();

    System.out.println("Ahmadabad is provided in search ");

    Thread.sleep(3000);
    PizzaSelection.AhmadabadLocationSelect();
    Thread.sleep(8000);
    System.out.println(driver.getTitle());

    String ActalalTitle = driver.getTitle();

    SoftAssert softAssert = new SoftAssert();
    String ExpectedTitle = "Pizza Hut | Home delivery | Order online | Chandkheda Chandkheda Ahmedabad";
    softAssert.assertEquals(ExpectedTitle, ActalalTitle );


    test.log(Status.INFO,"Margherita Piza is selected and location Ahmand abad is confirmed");

}

    @Test(priority = 4)
    public void SelectMargheritaPiza() throws InterruptedException {
        test = extent.createTest("SelectMargheritaPiza");
        // on Pizza hut manu user selects Margherita-new
        PizzaHut_PO PizzaSelection = new PizzaHut_PO(driver);
        PizzaSelection.ClickMargritaPizza();

        PizzaSelection.AddMargritaPizza();

        System.out.println("piza is selected");
        PizzaSelection.SetLocationPopUP();

        Thread.sleep(3000);
        System.out.println("Location is selected");

        PizzaSelection.SearchforAhmadabad();

        System.out.println("Ahmadabad is provided in search ");

        Thread.sleep(3000);
        PizzaSelection.AhmadabadLocationSelect();
        Thread.sleep(8000);

        String ActalalTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        String ExpectedTitle = "Pizza Hut | Home delivery | Order online | Chandkheda Chandkheda Ahmedabad";
        softAssert.assertEquals(ExpectedTitle, ActalalTitle );
        System.out.println(driver.getTitle());

        test.log(Status.INFO,"Margherita Piza is selected and location Ahmand abad is confirmed");
    }

    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }
    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            //test.fail(result.getThrowable());

            String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());

            test.fail("<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
                    + "</font>" + "</b >" + excepionMessage.replaceAll(",", "<br>")
                    + " \n");
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    @AfterClass
    public void CloseBrowser() {
        System.out.println("Broser is now Closed");
        driver.close();

    }
}
