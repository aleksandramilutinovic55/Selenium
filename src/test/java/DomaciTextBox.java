import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DomaciTextBox {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {

        driver.navigate().to("https://demoqa.com/text-box");
    }

    @Test
    public void fillTextBoxForm() {


        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));


        String validName = "Aleksandra Milutinovic";
        String validEmail = "aleksandramilutinovic505@gmail.com";
        String validAddress = "Paracin";


        fullName.sendKeys(validName);
        email.sendKeys(validEmail);
        currentAddress.sendKeys(validAddress);
        permanentAddress.sendKeys(validAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", submitButton);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));

        String actualName = driver.findElement(By.id("name")).getText();
        String actualEmail = driver.findElement(By.id("email")).getText();
        String actualCurrentAddress = driver.findElement(By.cssSelector("p#currentAddress")).getText();
        String actualPermanentAddress = driver.findElement(By.cssSelector("p#permanentAddress")).getText();

        Assert.assertEquals(actualName, "Name:" + validName);
        Assert.assertEquals(actualEmail, "Email:" + validEmail);
        Assert.assertEquals(actualCurrentAddress, "Current Address :" + validAddress);
        Assert.assertTrue(actualPermanentAddress.contains(validAddress));
    }

    @AfterMethod
    public void afterMethod() {

        System.out.println("Test je zavrsen.");
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}

