package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /*
    This method is used to intialize the  threadlocal driver on the basis of given browser
     */
    public WebDriver init_driver(String browsername){
        System.out.println("browser value is: "+browsername);
        if (browsername.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if(browsername.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else if(browsername.equalsIgnoreCase("safari")){
            tlDriver.set(new SafariDriver());// We do not require any binary for safari. hence ignoring
        }
        else{
            System.out.println("Browser name is provided as "+ browsername + ". Please provide the correct browser name.");
        }

        getDriver().manage().deleteAllCookies();//why can't we use tldrive.get directly here because we are using synchronized keyword in java.
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /*

     */

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
