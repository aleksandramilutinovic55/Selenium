import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciAutomat2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='start']/button")));
        startButton.click();

        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
        System.out.println("Prikazani tekst: " + helloWorldText.getText());

        Assert.assertTrue(helloWorldText.isDisplayed());
        Assert.assertEquals(helloWorldText.getText(), "Hello World!");


        //Domaci:
    //Koristite https://the-internet.herokuapp.com/dynamic_loading/2, gde se element pojavljuje tek posle klika. Kliknite na dugme Start i sačekajte da se pojavi tekst “Hello World!“.
    //Za ovaj zadatak koristiti asertacije i waitere
    }
}
