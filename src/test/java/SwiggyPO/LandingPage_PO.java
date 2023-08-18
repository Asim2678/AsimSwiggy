package SwiggyPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage_PO {

    WebDriver driver;
public LandingPage_PO(WebDriver driver){
    this.driver=driver;
}

By Ahmadabad_location =  By.xpath("//a[normalize-space()='Ahmedabad']");
By Ahmadabad_OnlineFoodTitle = By.xpath("//h1[normalize-space()='Order Food Online in Ahmedabad']");
public void Select_Ahmadabad(){
    driver.findElement(Ahmadabad_location).click();
}

public void AhmadabadOnlineFoodTitle(){
    WebElement PageHeader = driver.findElement(Ahmadabad_OnlineFoodTitle);
    PageHeader.isDisplayed();
}


}
