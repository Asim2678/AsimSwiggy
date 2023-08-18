package ExtentReporting;



import ITestListners.TestListeners;
import SwiggyPO.Cart_PO;
import SwiggyPO.LandingPage_PO;
import SwiggyPO.PizzaHut_PO;
import SwiggyPO.VittleBox_PO;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
//@Listeners(TestListeners.class)

public class TestExtentSwiggyReport {
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



    // this also be used as Before Test
    @BeforeTest
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

        ExtentTestManager.getTest().log(Status.INFO,"Test has started");
        // User clicks on the 'Ahmadabad' link on the home page, landing page of Swaggy.com
        LandingPage_PO SwiggyHomepage = new LandingPage_PO(driver);
        SwiggyHomepage.Select_Ahmadabad();

        SwiggyHomepage.AhmadabadOnlineFoodTitle();

        ExtentTestManager.getTest().log(Status.INFO,"Test has Ended");

    }

    @Test(priority = 2)
    public void SelectPizaHut() {
        // User clicks on o PIZZA HUT

        ExtentTestManager.getTest().log(Status.INFO,"Test has started");
        PizzaHut_PO PizzaSelection = new PizzaHut_PO(driver);
        PizzaSelection.setSelectPizza();

        PizzaSelection.PizzaHutElementTitle();
        String ActualPizhut = PizzaSelection.PizzaHutTitle();
        System.out.println(ActualPizhut);

        String ExpectedPizahut = "Pizza Hut | Home delivery | Order online | Chandkheda Chandkheda Ahmedabad";
        Assert.assertEquals(ExpectedPizahut, ActualPizhut, "Title of Piza hut does is not verified");

        ExtentTestManager.getTest().log(Status.INFO,"Test has Ended");
    }


    @Test(priority = 3)
    public void SelectMargheritaPiza() throws InterruptedException {

        // on Pizza hut manu user selects Margherita-new
        ExtentTestManager.getTest().log(Status.INFO,"Test has started");
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
        String ExpectedTitle = "Pizza Hut | Home delivery | Order online | Kudasan Road Gandhinagar Ahmedabad";
        softAssert.assertEquals(ExpectedTitle, ActalalTitle);
        System.out.println(driver.getTitle());

        ExtentTestManager.getTest().log(Status.INFO,"Test has Ended");


    }

    @Test(priority = 4)
    public void SelectVittlebox() throws InterruptedException {
        ExtentTestManager.getTest().log(Status.INFO,"Test has started");
        VittleBox_PO VittleBox = new VittleBox_PO(driver);
        VittleBox.SearchButton();
        //driver.findElement(By.xpath("//span[normalize-space()='Search']")).click();

        VittleBox.searchParameters();
       // driver.findElement(By.xpath("//input[@placeholder='Search for restaurants and food']")).sendKeys("VittleBox"+Keys.ENTER);

//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[contains(text(),'Vittlebox')]")).click();

        Thread.sleep(3000);

        System.out.println("select Vittllebox");
        VittleBox.selctVittleBox();
      // driver.findElement(By.xpath("//div[contains(text(),'Vittlebox')]")).click();

        Thread.sleep(2000);
        System.out.println("select Maxican Hot Pot");
        VittleBox.selectMaxicanHotPot();
       // driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")).click();


        Thread.sleep(2000);
        System.out.println("select first Contirue for Regular on jain");
        VittleBox.conontinueWithRegular();
       // driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();

        Thread.sleep(2000);
        System.out.println("select first Add item");
        VittleBox.AddtoTheCart();
        //driver.findElement(By.xpath("//span[contains(text(),'Add Item')]")).click();
        ExtentTestManager.getTest().log(Status.INFO,"Test has Ended");


    }
    @Test(priority = 5)
    public void VerifyCart(){
        ExtentTestManager.getTest().log(Status.INFO,"Test has started");

        System.out.println("select the cart");
        Cart_PO CartVerification = new Cart_PO(driver);
        CartVerification.checktheCart();
        //driver.findElement(By.xpath("//span[normalize-space()='Cart']")).click();


        System.out.println("Maxican Hot Pot present");
        CartVerification.MaxicanHotPotPresent();
        //driver.findElement(By.xpath("//div[@class='_33KRy']")).isDisplayed();
        ExtentTestManager.getTest().log(Status.INFO,"Test has Ended");
    }


    @AfterClass
    public void CloseBrowser() {
        System.out.println("Broser is now Closed");
        driver.close();

    }
}
