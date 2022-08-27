package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestSellersPage {
    WebDriver driver;

    public BestSellersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ol[@class='a-carousel']/li//a[@class='a-link-normal']")
    WebElement productLink;

    public void clickOneProduct() {
        productLink.click();
    }
}
