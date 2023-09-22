package com.assessment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ECommerceTest {
    WebDriver driver;
    HomePage objShp;
    ProductPage objProd;
    CartPage objCart;

    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-application-cache");
        options.addArguments("--disable-cache"); 
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test (priority = 1,description = "This test verify the Homepage and Login functionality")
    public void HomePage_Shopee(){
        objShp = new HomePage(driver);
        driver.get("https://shopee.ph/");
        objShp.pause(2000);

        objShp.BannerPage();

        objShp.pause(3000);

        objShp.ClickLogin();

        objShp.pause(3000);

        objShp.GmailLogin();

        objShp.pause(3000);

        String your_title = "Sign in - Google Accounts";
        String currentWindow = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
                break;
            } 
        }

        objShp.pause(3000);

        objShp.EnterEmail("kennethgomo22@gmail.com");

        objShp.pause(2000);
 
        objShp.EnterPassword("KyzerJace@19");

        objShp.pause(2000);

        driver.switchTo().window(currentWindow);

        objShp.pause(2000);

    }

    @Test (priority = 2, description = "This test verify the search for the item")
    public void SearchResultsPage(){
        objProd = new ProductPage(driver);

        driver.findElement(By.cssSelector(".shopee-searchbar-selector__selected")).click();

        driver.findElement(By.cssSelector(".shopee-searchbar-selector__option:nth-child(2) > .shopee-searchbar-selector__option-label")).click();
        objShp.pause(2000);

        objProd.searchItem("ASUS LAPTOP" + Keys.ENTER);

        WebElement result = objProd.searchResult;
        System.out.println(result.getText());

        WebElement getName = objProd.prodName;
        System.out.println(getName.getText());

    }

    @Test (priority = 3, description = "This test verify add to cart")
    public void ProductDetailsPage(){
        
        driver.findElement(By.cssSelector(".col-xs-2-4:nth-child(1)")).click();

        objShp.pause(2000);

        driver.findElement(By.xpath("//section/div/button[1]")).click();

        objShp.pause(2000);

        driver.findElement(By.xpath("//div[@class='p+UZsF']/button[1]")).click();

        objShp.pause(4000);

    }

    @Test (priority = 4, description = "This test verify that the item was added in the cart")
    public void CartPage(){
        objCart = new CartPage(driver);

        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".ofs-header__right .stardust-popover"))));

        button.click();

        WebElement cartgetName = objCart.verifier;
        System.out.println(cartgetName.getText());

        
    }

    @AfterTest
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
