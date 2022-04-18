/*3. Write down the following test into ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully
* click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’
2. verifyTheErrorMessage
* click on the ‘Sign In’ link
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘Invalid email
 or password.'*/

package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String BaseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find SingIn and click on the ‘Sign In’ link
        WebElement SignIn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        SignIn.click();

        //This requirement is from document
        String ExceptedMsg = "Welcome Back!";
        WebElement ActualMsgEl = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String ActualMsg = ActualMsgEl.getText();
        System.out.println("Actual Message:" +ActualMsg);

        //Validate actual and expected message
        Assert.assertEquals("Message is not excepted:",ExceptedMsg,ActualMsg);
    }
    @Test
    public void verifyTheErrorMessage()
    {
        //Find SingIn and click on the ‘Sign In’ link
        WebElement SignIn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        SignIn.click();

        //Find the username text and Enter the invalid username
        WebElement username = driver.findElement(By.id("user[email]"));
        username.sendKeys("Prime Testing");

        //Find the password text and Enter the invalid password
        WebElement password = driver.findElement(By.name("user[password]"));
        password.sendKeys("Prime123");

        //Find the signin button and click on
        WebElement SigninButton = driver.findElement(By.cssSelector("input.button"));
        SigninButton.click();

        //This Requirement is from document
        String ExpectedMsg = "Invalid email or password.";
        WebElement ActualMsgEl = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String ActualMsg = ActualMsgEl.getText();
        System.out.println("Actual Message =" +ActualMsg);

        //Validate actual and expected message
        Assert.assertEquals("Message is not expected:",ExpectedMsg,ActualMsg);
    }
    @After
    public void closedown()
    {
       closeBrowser();
    }
}