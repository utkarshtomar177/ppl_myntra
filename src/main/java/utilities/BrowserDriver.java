/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

// import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import java.io.File;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author Ark
 */
public final class BrowserDriver implements WebDriver {

    private WebDriver driver;
    private final String browserName;
    private final int timeout = 30;
    private final String chromeDriverPath = "./src/drivers/chromedriver.exe";
    private final String firefoxDriverPath = "./src/drivers/geckodriver.exe";

    public BrowserDriver(String browserName) {
        this.browserName = browserName;
        this.driver = createDriver(browserName);
    }

    private WebDriver createDriver(String browserName) {
        if (browserName.toUpperCase().equals("FIREFOX")) {
            return firefoxDriver();
        }

        if (browserName.toUpperCase().equals("CHROME")) {
            return chromeDriver();
        }

        throw new RuntimeException("invalid browser name");
    }

    private WebDriver chromeDriver() {
        if (!new File(chromeDriverPath).exists()) {
            throw new RuntimeException("chromedriver.exe does not exist!");
        }

        try {
            System.setProperty("webdriver.chrome.driver",
                    chromeDriverPath);
            return new ChromeDriver();
        } catch (Exception ex) {
            throw new RuntimeException("couldnt create chrome driver");
        }
    }

    private WebDriver firefoxDriver() {
        if (!new File(firefoxDriverPath).exists()) {
            throw new RuntimeException("geckodriver.exe does not exist!");
        }
        try {
            System.setProperty("webdriver.gecko.driver",
                    firefoxDriverPath);
            return new FirefoxDriver();
        } catch (Exception ex) {
            throw new RuntimeException("could not create the firefox driver");
        }
    }
    
    public WebDriver typecastToWebdriver(){
         return this.driver;
    }

    @Override
    public String toString() {
        return this.browserName;
    }

    public WebDriver driver() {
        return this.driver;
    }

    @Override
    public void close() {
        driver().close();
    }

    @Override
    public WebElement findElement(By locator) {
        return driver().findElement(locator);
    }

    @Override
    public List findElements(By arg0) {
        return driver().findElements(arg0);
    }

    public WebElement findVisibleElement(By locator) {
        WebElement element = new WebDriverWait(driver(), timeout)
                .until(visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement findClickableElement(By locator) {
        WebElement element = new WebDriverWait(driver(), timeout)
                .until(elementToBeClickable(locator));
        return element;
    }
    
    public void waitForElementPresent(final By by, int timeout){ 
      WebDriverWait wait = (WebDriverWait)new WebDriverWait(driver,timeout)
                      .ignoring(StaleElementReferenceException.class); 
      wait.until(new ExpectedCondition<Boolean>(){ 
        @Override 
        public Boolean apply(WebDriver webDriver) { 
          WebElement element = webDriver.findElement(by); 
          return element != null && element.isDisplayed(); 
        } 
      }); 
    }

    public WebElement findHiddenElement(By locator) {
        WebElement element = new WebDriverWait(driver(), timeout)
                .until(presenceOfElementLocated(locator));
        return element;
    }

    @Override
    public void get(String arg0) {
//        System.out.println("override character");
        driver().get(arg0);
    }

    @Override
    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }

    @Override

    public String getPageSource() {
        return driver().getPageSource();
    }

    @Override
    public String getTitle() {
        return driver().getTitle();
    }

    @Override
    public String getWindowHandle() {
        return driver().getWindowHandle();
    }

    @Override
    public Set getWindowHandles() {
        return driver().getWindowHandles();
    }

    @Override
    public Options manage() {
        return driver().manage();
    }

    @Override
    public Navigation navigate() {
        return driver().navigate();
    }

    @Override
    public void quit() {
        driver().quit();
    }

    @Override
    public TargetLocator switchTo() {
        return driver().switchTo();
    }
    
    public void waitForLoad(WebDriver driver) throws InterruptedException {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
        Thread.sleep(1000);
    }
    
     public void clearInputAndSendKeys(WebElement element , String input) {
        element.clear();
        element.sendKeys(input);
    }

}
