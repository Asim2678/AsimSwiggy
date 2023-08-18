package SwiggyPO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Collection;

public class VittleBox_PO {

    WebDriver driver;
    public VittleBox_PO(WebDriver driver){this.driver=driver;}
    By SearchButton = By.xpath("//span[normalize-space()='Search']");
    By SearchField = By.xpath("//input[@placeholder='Search for restaurants and food']");

    By VittleBx = By.xpath("//div[contains(text(),'Vittlebox')]");
    By MaxicoanHotPot = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]");
    By ContinueRegular = By.xpath("//span[contains(text(),'Continue')]");
    By AddtoCart = By.xpath("//span[contains(text(),'Add Item')]");


    public void SearchButton (){
        driver.findElement(SearchButton).click();
    }
    public void searchParameters (){
        driver.findElement(SearchField).sendKeys("VittleBox"+ Keys.ENTER);
    }

    public void selctVittleBox (){
        driver.findElement(VittleBx).click();
    }
    public void selectMaxicanHotPot(){
        driver.findElement(MaxicoanHotPot).click();
    }
    public void conontinueWithRegular(){
        driver.findElement(ContinueRegular).click();

    }

    public void AddtoTheCart(){
        driver.findElement(AddtoCart).click();
    }

}
