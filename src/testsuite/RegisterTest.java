package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // click on the ‘Register’ link
        driver.findElement(By.xpath("// div[@class = 'header-links']//a[text() = 'Register']")).click();

        // Verify the text ‘Register’
        String expectedText = "Register";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text() = 'Register']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // Generate a random email
        final String randomEmail = randomEmail();

        // click on the ‘Register’ link
        driver.findElement(By.xpath("// div[@class = 'header-links']//a[text() = 'Register']")).click();

        // Select gender radio button
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("gender-female")).click();

        //  Enter First name
        driver.findElement(By.xpath("// div[@class = 'inputs']//input[@id = 'FirstName']")).sendKeys("John");
        // Enter Last name
        driver.findElement(By.xpath("// div[@class = 'inputs']//input[@id = 'LastName']")).sendKeys("Smith");
        // Select Day Month and Year
        driver.findElement(By.xpath("// div[@class = 'date-picker-wrapper']//select[@name = 'DateOfBirthDay']")).sendKeys("19");  // day
        driver.findElement(By.xpath("// div[@class = 'date-picker-wrapper']//select[@name = 'DateOfBirthMonth']")).sendKeys("January");  // month
        driver.findElement(By.xpath("// div[@class = 'date-picker-wrapper']//select[@name = 'DateOfBirthYear']")).sendKeys("1990");  // year
        // Enter Email address
        WebElement email = driver.findElement(By.xpath("// div[@class = 'inputs']//input[@id = 'Email']"));
        email.sendKeys(randomEmail);
        // Enter Password
        driver.findElement(By.xpath("// div[@class = 'inputs']//input[@id = 'Password']")).sendKeys("nsmi12345");
        // Enter Confirm password
        driver.findElement(By.xpath("// div[@class = 'inputs']//input[@id = 'ConfirmPassword']")).sendKeys("nsmi12345");
        // Click on REGISTER button
        driver.findElement(By.xpath("// div[@class = 'buttons']//button[@id = 'register-button']")).click();

        // Verify the text 'Your registration completed’.
        String expectedMessage = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found", expectedMessage, actualText);
    }

    @After
    public void tearDown() {
       // closeBrowser();
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
}
