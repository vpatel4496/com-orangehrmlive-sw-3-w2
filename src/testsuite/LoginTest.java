package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl="https://opensource-demo.orangehrmlive.com/ ";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        sendTextToElement(By.id("txtUsername"),"Admin");

        sendTextToElement(By.id("txtPassword"),"admin123");

        clickOnElement(By.id("btnLogin"));
        String expectedMessage="Welcome";
        String actualMessage=getTextFromElement(By.partialLinkText("Welcome")).substring(0,7);
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void close(){
        closeBrowser();
    }

}
