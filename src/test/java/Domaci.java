import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci {

    public static void main (String[] args) throws InterruptedException {

        //Otvoriti youtube i pustiti pesmu po izboru

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com");

        Thread.sleep(3000);
        driver.findElement(By.name("search_query")).sendKeys("Perfect Ed Sheeran", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.id("video-title")).click();





    }
}
