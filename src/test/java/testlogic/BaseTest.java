package testlogic;


import com.google.common.base.Function;
import helpers.ConfigPropertiesLoader;
import helpers.GetCurrentClassName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by dell on 11.02.2015.
 * <p/>
 * base selenium Web Driver framework methods
 */
public class BaseTest {

    private final static Logger log = LoggerFactory.getLogger(BaseTest.class);


    protected ConfigPropertiesLoader environmentData;

    public BaseTest() {

        try {
            environmentData = new ConfigPropertiesLoader();


//            init class-helpers instances
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }


    public ConfigPropertiesLoader getEnvironmentData() {
        return environmentData;
    }


    public WebElement fluentWait(WebDriver driver, final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                        // .pollingEvery(5, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                        // .ignoring(NoSuchElementException.class);
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        WebElement foo = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                    }
                }
        );
        return foo;
    }

    public WebElement waitForElementGetsVisible(WebDriver driver, By locatorKey) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locatorKey)
        );
        return element;
    }

    public boolean isElementPresent(WebDriver driver, By locatorKey) {
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void checkElementPresent(WebDriver driver, String cssLocator, String alertMsg) {
        if (!isElementPresent(driver, By.cssSelector(cssLocator))) {
            Assert.fail(alertMsg);
        }
    }


    public void driverShutDown(WebDriver driver) {
        driver.quit();
    }


    /**
     * method providing boolean response on checkbox checked/unchecked
     *
     * @param driver
     * @param locator
     * @return
     */

    public boolean isChecked(WebDriver driver, By locator) {
        boolean result = false;
        result = driver.findElement(locator).isSelected();
        return result;
    }


    public void printTestSuiteNameOnceExecFinished(Class classParam) {
        log.info(GetCurrentClassName.getCurrentClassName(classParam) +
                "test execution finished\n");


    }

}
