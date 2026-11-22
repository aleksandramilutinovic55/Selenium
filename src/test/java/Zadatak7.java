import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zadatak7 {


/*Zadatak7 napisite ostale testove na osnovu klase Zadatak6
Testovi mogu biti

Log out
Log in sa nevalidnim username
Log in sa nevalidnim password*/


 WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://practicetestautomation.com/");
    }

        @BeforeMethod
        public void beforeMethod() {
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();

            WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
            testLoginPageButton.click();
        }

        @Test(priority = 1)
    public void userCanLogOut(){
    WebElement usernameField= driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    WebElement submitButton = driver.findElement(By.id("submit"));

    usernameField.sendKeys("student");
    passwordField.sendKeys("Password123");
    submitButton.click();
            String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());

        }



            @Test(priority = 2)
                    public void invalidUsername(){
                WebElement usernameField = driver.findElement(By.id("username"));
                WebElement passwordField = driver.findElement(By.id("password"));
                WebElement submitButton = driver.findElement(By.id("submit"));

                String invalidUsername = "wronguser";
                String validPassword = "Password123";
                usernameField.click();

                usernameField.sendKeys(invalidUsername);
                passwordField.clear();
                passwordField.sendKeys(validPassword);
                submitButton.click();
            WebElement logOutButton= driver.findElement(By.linkText("Log out"));
            Assert.assertTrue((logOutButton.isDisplayed()));
            logOutButton.click();

            WebElement usernameFieldAfterLogOut= driver.findElement(By.id("Username"));
            Assert.assertTrue(usernameFieldAfterLogOut.isDisplayed());
            }

    }


