package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BestSellersPage;
import pages.HomePage;
import pages.ProductPage;

import static stepdefinitions.Hooks.driver;

public class BasketStepDefinitions {
    HomePage homePage;
    BestSellersPage bestSellersPage;
    ProductPage productPage;

    @Given("User closes cookies")
    public void userClosesCookies() {
        homePage = new HomePage(driver);
        homePage.closeCookie();
    }

    @When("User clicks on Best Sellers at the home page")
    public void user_clicks_on_best_sellers_at_the_home_page() {
        homePage.clickBestSeller();
    }

    @When("User clicks one of the products at the best seller page")
    public void user_clicks_one_of_the_products_at_the_best_seller_page() {
        bestSellersPage =  new BestSellersPage(driver);
        bestSellersPage.clickOneProduct();
    }

    @When("User add item to the basket at the product page")
    public void user_add_item_to_the_basket_at_the_product_page() {
        productPage = new ProductPage(driver);
        productPage.addToBasket();
    }

    @Then("User should see {string} text")
    public void user_should_see_text(String string) {
        String actualMessage = productPage.checkMessage();
        Assert.assertEquals(string,actualMessage);
    }

}
