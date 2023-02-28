package apphooks;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver webDriver;
    private ConfigReader configReader;
    Properties properties;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        properties = configReader.init_properties();

    }

    @Before(order = 1)
    public void launchBrowser(){
        String browsername = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        webDriver = driverFactory.init_driver(browsername);
    }

    @After(order = 0)
    public void quitBrowser(){
        webDriver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario sc){
        if (sc.isFailed()){
            //takeScreenshot
            String screenshotName = sc.getName().replace("", "_");
            byte[] sourcePath = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcePath, "image/png", screenshotName);
        }
    }


}
