package testlogic;

import com.gett.webdrivercrawler.SignInMyAccountLocators;
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

//= ==================================
//    INITIAL step  - navigate to sign in section
    String signInPattern01="sign";
    String myAccountPattern01="ccount";

    //    onlineshoes
   public void navigateToSignInMyAccountLayout(){
     /*  List<WebElement> headerLinksList=driver.findElements(By.cssSelector(SignInMyAccountLocators.headerLinksCSS_ID1));

       int indexToSearch=-1;
//       if any elements have been found on CSS selector above
       if(headerLinksList.size()>=1) {
       for(int i=0; i<headerLinksList.size(); i++){
           if(headerLinksList.get(i).getText().toLowerCase().trim().contains(signInPattern01)){
               indexToSearch =i;
               break;
           }
       }

       if(indexToSearch>=0){
           headerLinksList.get(indexToSearch).click();
           waitForPageLoad(driver);
       } }  */
       List <WebElement> headerLinksList = driver.findElements(By.xpath(SignInMyAccountLocators.headerLinksXPATH_ID1));
       if (headerLinksList.size()>=1) {
//           @TODO consider two cases: list == 1 element; list >1 elemnt
           headerLinksList.get(0).click();
           waitForPageLoad(driver);
       }

//     trying other selectors in case nothing have been found
       headerLinksList = driver.findElements(By.xpath(SignInMyAccountLocators.headerLinksXPATH_ID2));
        if (headerLinksList.size()>=1){
//           @TODO consider two cases: list == 1 element; list >1 elemnt
            headerLinksList.get(0).click();
            waitForPageLoad(driver);
       }

   }

//    ===============================



}
