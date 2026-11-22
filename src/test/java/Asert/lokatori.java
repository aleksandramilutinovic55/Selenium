package Asert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class lokatori {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
        Thread.sleep(3000);
        driver.findElement(By.linkText("PRACTICE")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Test Login Page")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("student");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("Password123");
        Thread.sleep(3000);
        driver.findElement(By.id("submit")).click();


        String actualURL=driver.getCurrentUrl();
        String expectedURL= "https://practicetestautomation.com/logged-in-successfully/";
        System.out.println("Trenutni URL:" + "actualLoginURL");
        Assert.assertEquals(actualURL, expectedURL);
        String actualTitle=driver.findElement(By.tagName("h1")).getText();
        String expectedTitle="Logged In Successfully";
        Assert.assertEquals(actualTitle, expectedTitle);




    }

            //Na linku https://practicetestautomation.com/ otici do login stranice, uradite log in i dodajte asertacije
    //fokus asertacija i lokatori
}
