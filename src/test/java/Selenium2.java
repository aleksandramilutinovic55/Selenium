import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {

    public static void main (String[] args){

       /* WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();*/

       /* driver.navigate().to("http://www.google.com");

        JavascriptExecutor js= (JavascriptExecutor) driver;//skrol na neki element ili otvaranje tabova
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        driver.navigate().to("http://www.youtube.com");

        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        System.out.println(" ISTA TABOVA" + listaTabova);

        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("http://www.youtube.com");
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("http://www.joberty.com");
        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("http://www.google.com");

        driver.close(); // zatvara samo trenutni tab
        //driver.quit();//zatvara ceo prozor nevezano za tabove */

        ////Zadatak 2
        ////Otvoriti browser i jos 5 tabova
        ////Na svakom tabu otvoriti URL po zelji
        ////Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.google.com");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        System.out.println(" LISTA TABOVA" + listaTabova);

        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("http://www.netflix.com");
        //npr close ovde
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("http://www.facebook.com");
        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("http://www.udemy.com");
        driver.switchTo().window(listaTabova.get(4));
        driver.navigate().to("http://www.infostud.com");
        driver.switchTo().window(listaTabova.get(5));
        driver.navigate().to("http://www.linkedin.com");
        //driver.close(); // ovde zatvaram peti tab
       /* driver.switchTo().window(listaTabova.get(4));
        driver.close();
        driver.switchTo().window(listaTabova.get(3));
        driver.close();
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();*/

        for ( int i=0; i<listaTabova.size(); i++) {
            driver.switchTo().window(listaTabova.get(i));
            if (!driver.getCurrentUrl().equals("http://www.google.com")){
            driver.close();


        }
    }
    }
}

