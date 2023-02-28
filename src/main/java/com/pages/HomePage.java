package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver webDriver;

    //By Locators:
    private By shopLink = By.linkText("Shop");
    private By myAccountLink = By.linkText("My Account");

    //Constructor
    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //PageActions

    public String getPageTitle(){
        return webDriver.getTitle();
    }

    public boolean isHeaderLinkPresent(String text){
        return webDriver.findElement(By.linkText(text)).isDisplayed();
    }

    public void clickOnLink(String text){
        webDriver.findElement(By.linkText(text)).click();
    }
}
