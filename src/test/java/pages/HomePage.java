package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='nav-xshop']//a[contains(.,'Çok Satanlar')]")
    WebElement bestSellerTab;

    @FindBy(id = "sp-cc-accept")
    WebElement cookieClose;

    public void clickBestSeller() {
        bestSellerTab.click();
    }

    public void closeCookie() {
        cookieClose.click();
    }
}
