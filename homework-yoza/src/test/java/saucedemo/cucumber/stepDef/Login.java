package saucedemo.cucumber.stepDef;

import com.fasterxml.jackson.databind.node.BooleanNode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

//        @Test
    @Given("Buka Halaman Login Swag Labs")
//    @Test
    public void bukaHalamanLoginSwagLabs() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);


       String loginPageAssert = driver.findElement(By.xpath("//input[@id=\"login-button\"]")).getAttribute("value");
       Assert.assertEquals(loginPageAssert, "Login");
//       System.out.println(loginPageAssert); //pengetesan mencari xpath

//        driver.close();
    }

//    @Test
    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        String namaToko = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(namaToko,"Products");
        driver.close();
    }

    @And("Input invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Then("User get Error Message")
    public void userGetErrorMessage() {
        String ErrorLogin  = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @Given("User already Login the Swag Labs site")
//    @Test
    public void userAlreadyLoginTheSwagLabsSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        String namaToko = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(namaToko,"Products");

    }

    @When("User click menu in corner")
//    @Test
    public void userClickMenuInCorner()
    {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }

    @And("User click Logout")
    public void userClickLogout() {
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();

    }

    @Then("Halaman Login Swag Labs")
    public void cekhalamanLoginSwagLabs() {
        String loginPageAssert = driver.findElement(By.xpath("//input[@id=\"login-button\"]")).getAttribute("value");
        Assert.assertEquals(loginPageAssert, "Login");
//        System.out.println(loginPageAssert); //pengetesan mencari xpath

        driver.close();

    }

    @When("User click add to Cart button on one of the product or more")
    public void userClickAddToCartButtnOnOneOfTheProductOrMore() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
    }

    @And("User click Cart icon on the top right side")
    public void userClickCartIconOnTheTopRightSide() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @And("User check the shopping list details & click the Checkout Button")
    public void userCheckTheShoppingListDetailsClickTheCheckoutButton() {
        String judul = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[2]")).getText();
        Assert.assertEquals(judul,"Description");
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @And("User fill the buyer's biodata form & click the Continue button")
    public void userFillTheBuyerSBiodataFormClickTheContinueButton() {
        driver.findElement(By.id("first-name")).sendKeys("NamaDepan");
        driver.findElement(By.id("last-name")).sendKeys("Belakang");
        driver.findElement(By.id("postal-code")).sendKeys("21333");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

    }

    @And("user double check the shopping list & click the Finish Button")
    public void userDoubleCheckTheShoppingListClickTheFinishButton() {
        String judul = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(judul,"Checkout: Overview");
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

    @Then("User succesfully purchased the product & directed to {string} page")
    public void userSuccesfullyPurchasedTheProductDirectedToPage(String arg0) {
        String judul = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(judul,"Checkout: Complete!");

    }

    @And("User can back to Homepage with click the {string} Button")
    public void userCanBackToHomepageWithClickTheButton(String arg0) {
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        driver.close();
    }

    @And("User click the Continue button on the Checkout page")
    public void userClickTheContinueButtonOnTheCheckoutPage() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Then("User Failed to buy product & system will display the warning message the Error: First Name is required")
    public void userFailedToBuyProductSystemWillDisplayTheWarningMessageTheErrorFirstNameIsRequired() {
        String judul = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")).getText();
        Assert.assertEquals(judul,"Error: First Name is required");
        driver.close();

    }

    @When("User sort product by {string} as sortBy")
    public void userSortProductByAsSortBy(String arg0) {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
    }

    @Then("User select cheapest Product to the cart")
    public void userSelectCheapestProductToTheCart() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
        driver.close();
    }
}

