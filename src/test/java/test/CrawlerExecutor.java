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
        crawlerLogic.navigateToSignInMyAccountLayout();
*/
// ============================================

// https://www.shoebacca.com/

//        crawlerLogic.navigateTargetSite(driver, TargetResourceGenerator.getRandomResource());

        /*
        crawlerLogic.navigateTargetSite(driver, "https://www.shoebacca.com/");
        crawlerLogic.refreshNewlyOpenPage(driver);
        crawlerLogic.navigateToSignInMyAccountLayout();

        */


//       ================
//        http://www.barnesandnoble.com/
        /*crawlerLogic.navigateTargetSite(driver, "http://www.barnesandnoble.com/");
        crawlerLogic.refreshNewlyOpenPage(driver);
        crawlerLogic.navigateToSignInMyAccountLayout();*/





//        crawlerLogic.navigateTargetSite(driver, TargetResourceGenerator.getRandomResource());
        crawlerLogic.refreshNewlyOpenPage(driver);
        crawlerLogic.navigateToSignInMyAccountLayout();
    }


    @AfterClass
    public void shutDown(){
        crawlerLogic.driverShutDown(driver);
    }

}
