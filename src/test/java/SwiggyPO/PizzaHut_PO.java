package SwiggyPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class PizzaHut_PO {
    WebDriver driver;
public PizzaHut_PO(WebDriver driver){this.driver=driver;}


    By SelectPizzaHut = By.xpath("//a[@class='RestaurantCard__RestaurantAnchor-sc-160d8pf-0 kakAMc']//img[@alt='Pizza Hut']");
    By MargrittaPizza =  By.xpath("//div[@id='cid-Recommended']//div[@class='main_container__3QMrw']//div//div//button[@aria-label='See more information about Schezwan Margherita - New']");
    By AddMrgrittaButton = By.cssSelector("body.OverflowHidden_hideOverflow__2xfDr:nth-child(2) div.BaseModal_content__Ish-9.styles_dwebCard__33Ylm.BaseModal_content__show__2WOyH div.styles_itemContainer__39Ry3 div.styles_addBtnWrapper__34B3L:nth-child(2) div:nth-child(1) div._3L1X9._211P0.main_buttonInner__z6Jz0.main_button__3gpqi.styles_addBtnDwebReset__3-z94 > div._1RPOp");
    By SetLocation = By.xpath("//button[contains(text(),'Set location')]");
    By LocationDatafiled = By.xpath("//input[@placeholder='Search for area, street name..']");
    By AhmadabladLocationSelect =  By.xpath("//body/div[@id='overlay-sidebar-root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]");
    By PizzaHut = By.xpath("//p[@class='RestaurantNameAddress_name__2IaTv']");

    public void setSelectPizza (){
        driver.findElement(SelectPizzaHut).click();
    }
    public String PizzaHutTitle() {
        String PizzaHutTitle = driver.getTitle();
        return PizzaHutTitle;
    }

    public void PizzaHutElementTitle() {
        WebElement PizzahutElement = driver.findElement(PizzaHut);
        PizzahutElement.isDisplayed();

    }
    public void ClickMargritaPizza(){
        driver.findElement(MargrittaPizza).click();
    }
    public void AddMargritaPizza(){
        driver.findElement(AddMrgrittaButton).click();
    }
    public void SetLocationPopUP(){
        driver.findElement(SetLocation).click();
    }
    public void SearchforAhmadabad(){
        WebElement txtnam =driver.findElement(LocationDatafiled);
        txtnam.sendKeys("Ahmadabad");

    }
    public void AhmadabadLocationSelect(){
        driver.findElement(AhmadabladLocationSelect).click();
    }

}
