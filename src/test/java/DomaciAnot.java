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

public class DomaciAnot {

    WebDriver driver;
    WebDriverWait wait;

    String username = "testUser" + System.currentTimeMillis();
    String password = "Test12345!";

    @BeforeClass
    public void otvaranjeBrowsera() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void otvaranjeRegisterStranice() {
        driver.get("https://practice.expandtesting.com/register");
    }

    @Test(priority = 1)
    public void registracija() {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        WebElement registerButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", registerButton);

        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();

        wait.until(ExpectedConditions.urlContains("/login"));

        String actualMessage = driver.findElement(By.tagName("body")).getText();

        Assert.assertTrue(actualMessage.contains("Successfully registered, you can log in now."));
    }

    @Test(priority = 2)
    public void login() {

        driver.get("https://practice.expandtesting.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.sendKeys("practice");
        passwordField.sendKeys("SuperSecretPassword!");

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", loginButton);

        wait.until(ExpectedConditions.visibilityOf(loginButton));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", loginButton);

        wait.until(ExpectedConditions.urlContains("/secure"));

        String actualMessage = driver.findElement(By.tagName("body")).getText();

        Assert.assertTrue(actualMessage.contains("You logged into a secure area!"));
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }
}