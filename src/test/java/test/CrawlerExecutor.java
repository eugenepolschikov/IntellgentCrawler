package test;
import helpers.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import testlogic.BaseAlgorithm;
import testlogic.BaseTest;

import java.io.IOException;
import java.net.MalformedURLException;


/**
 * Created by dell on 11.02.2015.
 */
public class CrawlerExecutor {
    private WebDriver driver;
//    private LoginPage loginPage;


    private BaseAlgorithm crawlerLogic;


    @BeforeClass
    public void initDriver() throws MalformedURLException {
        this.driver = DriverInit.driverSetUp(this.driver);
//        loginPage = PageFactory.initElements(this.driver, LoginPage.class);


        crawlerLogic  = new BaseAlgorithm(driver);


    }


    @BeforeMethod
    public void webAdminLoginAndEditVenueNavigate() throws IOException, InterruptedException {


        driver.get(crawlerLogic.getEnvironmentData().getLoginbaseUrl());


    }

    @Test
    public void navigateToAnotherOneTargetSite(){
        driver.get("https://www.tut.by");
        driver.findElement(By.cssSelector("#search_from_str")).sendKeys("check check");
        driver.findElement(By.cssSelector("#search_from_str")).sendKeys("check check");

    }


    @AfterClass
    public void shutDown(){
        crawlerLogic.driverShutDown(driver);
    }

}
