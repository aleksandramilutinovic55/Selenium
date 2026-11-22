import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DomaciAutom {

    public static void main (String[] args) throws InterruptedException {


        //pozitivan login

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        Thread.sleep(2000);

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        Thread.sleep(2000);

// Asertacija za uspesan login

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/secure";

        Assert.assertEquals(actualUrl, expectedUrl);
        String actualMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualMessage.contains("You logged into a secure area!"));

// Provera Logout dugmeta

        Assert.assertTrue(driver.findElement(By.className("icon-2x")).isDisplayed());


// NEVALIDAN LOGIN

        driver.navigate().to("https://the-internet.herokuapp.com/login");

        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("pogresnaLozinka");
        driver.findElement(By.className("radius")).click();
        Thread.sleep(2000);

// Asertacija za neuspesan login

        String actualError = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualError.contains("Your password is invalid!"));
        driver.quit();
    }

        //Domaci:
    //Na sajtu https://the-internet.herokuapp.com/login testirati logovanje koristeci validne i nevalidne kredencijale.
    //Koristiti asertacije.
}
