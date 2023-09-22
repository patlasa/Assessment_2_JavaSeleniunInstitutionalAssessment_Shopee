package com.assessment2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;

    @FindBy (css = ".shopee-searchbar-selector__selected")
    WebElement select;

    @FindBy (css = ".shopee-searchbar-input__input")
    WebElement searchField;

    @FindBy (css = ".shopee-search-result-header__text-highlight")
    WebElement searchResult;

    @FindBy (xpath =  "//div[@data-sqe='item'][1]//div[@class='FDn--+']/div")
    WebElement prodName;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void searchItem(String search){
        // searchField.sendKeys(search);
       WebElement searchItem = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(searchField));
       searchItem.sendKeys(search);
    }

    public void SearchResult(){
        searchResult.getText();
    }

    public void ProductName(){
    prodName.getText();
    }

    


}
