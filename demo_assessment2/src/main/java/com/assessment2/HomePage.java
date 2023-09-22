package com.assessment2;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    @FindBy (className = "home-page")
    WebElement banner_page;

    @FindBy (xpath = "//a[contains(text(), 'Login')]")
    WebElement login;

    @FindBy (css = ".nGTAZw:nth-child(2)")
    WebElement clickGmail;

    @FindBy (id = "identifierId")
    WebElement emailID;

    @FindBy (name = "Passwd")
    WebElement password;
    
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void BannerPage(){
        // Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement close_button = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(banner_page));
        close_button.click();
    }

    public void ClickLogin(){
        login.click();
    }

    public void EnterEmail(String email){
        emailID.sendKeys(email + Keys.ENTER);
    }

    public void EnterPassword(String pass){
        password.sendKeys(pass + Keys.ENTER);
    }

    public void GmailLogin(){
        clickGmail.click();
    }

    public void pause(long milseconds){
        try {
            Thread.sleep(milseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
