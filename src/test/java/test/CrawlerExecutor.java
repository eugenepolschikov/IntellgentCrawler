package test;
import helpers.DriverInit;
import helpers.TargetResourceGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testlogic.BaseAlgorithm;

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

//        get URL from properties file
//        driver.get(crawlerLogic.getEnvironmentData().getLoginbaseUrl());

    }

    @Test
    public void navigateToAnotherOneTargetSite(){

//        WORKING port for online shoes ===============

/*

        crawlerLogic.navigateTargetSite(driver,"https://www.onlineshoes.com/");
//        this action is done to avoid any kinda of modal popUp windows on the page.
        crawlerLogic.refreshNewlyOpenPage(driver);
        crawlerLogic.navigateToSignInOnlineShoes();
*/

// ============================================

        crawlerLogic.navigateTargetSite(driver, TargetResourceGenerator.getRandomResource());
        crawlerLogic.refreshNewlyOpenPage(driver);
        crawlerLogic.refreshNewlyOpenPage(driver);



    }


    @AfterClass
    public void shutDown(){
        crawlerLogic.driverShutDown(driver);
    }

}
