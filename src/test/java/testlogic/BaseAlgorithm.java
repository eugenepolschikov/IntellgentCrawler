package testlogic;

import com.gett.webdrivercrawler.SignInLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by dell on 12.02.2015.
 */
public class BaseAlgorithm  extends  BaseTest {
    public final static Logger log = LoggerFactory.getLogger( BaseAlgorithm.class);



    //    this is local driver, for usage within this class ONLY
    private WebDriver driver;

    //    String variables for logging automation script event(-s) in scope of this class
    private String alertMsg;


    public  BaseAlgorithm(WebDriver newDriver) {

        this.driver = newDriver;

    }


//    INITIAL step  - navigate to sign in section

   public void navigateToSignIn(){
       List<WebElement> headerLinksList=driver.findElements(By.cssSelector(SignInLocators.headerLinksCSS_ID1));

   }
//    onlineshoes

}
