package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on the ‘Computers’Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        //Verify the text ‘Computers’
        String expectedText = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found!", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //click on the ‘Electronics’ Tab
        driver.findElement(By.xpath("// ul[@class = 'top-menu notmobile']//a[text() = 'Electronics ']")).click();
        //Verify the text ‘Electronics’
        String expectedText = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']//h1[text()='Electronics']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        // click on the ‘Apparel’ Tab
        driver.findElement(By.xpath("// ul[@class = 'top-menu notmobile']//a[text() = 'Apparel ']")).click();

        // Verify the text ‘Apparel’
        String expectedText = "Apparel";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Apparel']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        // click on the ‘Digital downloads’ Tab
        driver.findElement(By.xpath("// ul[@class = 'top-menu notmobile']//a[text() = 'Digital downloads ']")).click();

        // Verify the text ‘Digital downloads’
        String expectedText = "Digital downloads";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Digital downloads']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        // click on the ‘Books’ Tab
        driver.findElement(By.xpath("// ul[@class = 'top-menu notmobile']//a[text() = 'Books ']")).click();

        // Verify the text ‘Books’
        String expectedText = "Books";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Books']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        // click on the ‘Jewelry’ Tab
        driver.findElement(By.xpath("// ul[@class = 'top-menu notmobile']//a[text() = 'Jewelry ']")).click();

        // Verify the text ‘Jewelry’
        String expectedText = "Jewelry";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Jewelry']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        // click on the ‘Gift Cards’ Tab
        driver.findElement(By.xpath("// ul[@class = 'top-menu notmobile']//a[text() = 'Gift Cards ']")).click();

        // Verify the text ‘Gift Cards’
        String expectedText = "Gift Cards";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Gift Cards']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text not found", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
