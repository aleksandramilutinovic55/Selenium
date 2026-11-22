import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class login {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        String naslov = driver.findElement(By.className("title"))
                .getText();

        if (naslov.equals("Products")) {
            System.out.println("TEST PASSED - Login uspesan!");
        } else {
            System.out.println("TEST FAILED - Login neuspesan!");
        }

        driver.quit();
    }
}