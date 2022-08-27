package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "add-to-cart-button")
    WebElement addBasket;

    @FindBy(xpath = "//div[@class='a-section a-spacing-none a-padding-none']/span")
    WebElement addBasketMessage;

    public void addToBasket() {
        addBasket.click();
    }

    public String checkMessage() {
        return addBasketMessage.getText();
    }
}
