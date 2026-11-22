import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.util.ArrayList;

public class Zadatak3 {

    public static void main (String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();


        driver.navigate().to("https://www.bing.com");
        WebElement searchBoxBing = driver.findElement(By.id("sb_form_q"));
        searchBoxBing.sendKeys("Wikipedia -Ai");

        WebElement searchButtonBing= driver.findElement(By.id("sb_hp_go"));
        searchButtonBing.click();

        WebElement wikipediaLink= driver.findElement(By.linkText("Wikipedia"));
        wikipediaLink.click();

        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        WebElement searchBoxWikipedia= driver.findElement(By.id("searchInput"));
        searchBoxWikipedia.sendKeys("Nikola Tesla");

        WebElement searchButtonWikipedia = driver.findElement(By.cssSelector("button [type='submit']"));
                searchButtonWikipedia.click();















    }


    ///Zadatak 3
    ////Otvoriti bing pretrazivac, pretrazite 'Wikipedia'
    ////otvorite wikipedia stranicu i na njoj uradite pretragu 'Nikola Tesla'
}
