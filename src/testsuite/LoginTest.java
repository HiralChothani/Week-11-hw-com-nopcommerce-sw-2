package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find the login link and click on Login Link
        WebElement loginLink = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginLink.click();
        //Verify the text ‘Welcome, Please Sign In!
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not redirected to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        //find the login link and click on Login Link
        WebElement loginLink = driver.findElement(By.xpath("//div[@class='header-links']//a[text()='Log in']"));
        loginLink.click();
        //Find the username Field Element and send username on username field
        driver.findElement(By.id("Email")).sendKeys("freda12345@gmail.com");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("Password")).sendKeys("nsmi12345");
        //Find the Login btn Element and click
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //Verify the ‘Log out’ text is display
        String expectedText = "Log out";
        WebElement actualText = driver.findElement(By.linkText("Log out"));
        String textShown = actualText.getText();
        Assert.assertEquals("Text not displayed", expectedText, textShown);
    }

    @Test
    public void verifyTheErrorMessage() {
        //find the login link and click on Login Link
        WebElement loginLink = driver.findElement(By.xpath("//div[@class='header-links']//a[text()='Log in']"));
        loginLink.click();
        //Find the username Field Element and Enter invalid username
        driver.findElement(By.id("Email")).sendKeys("johnson1234@gmail.com");
        //Find the password Field Element and Enter invalid password
        driver.findElement(By.name("Password")).sendKeys("johnson1234");
        //Click on Login button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //Verify the error message ‘Login was unsuccessful.
        //Please correct the errors and try again. No customer account found’
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Message not found", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

