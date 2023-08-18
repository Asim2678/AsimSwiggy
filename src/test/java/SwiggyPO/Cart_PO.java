package SwiggyPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart_PO {
    WebDriver driver;
    public Cart_PO(WebDriver driver){this.driver=driver;}

    By ClickCart = By.xpath("//span[normalize-space()='Cart']");
    By MaxicanHotPot = By.xpath("//div[@class='_33KRy']");

    public void checktheCart(){
        driver.findElement(ClickCart).click();
    }
    public void MaxicanHotPotPresent(){
        driver.findElement(MaxicanHotPot).click();
    }
}
