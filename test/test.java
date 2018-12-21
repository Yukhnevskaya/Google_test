package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {



    WebDriver driver;
    By q = By.name("q");
    By list = By.cssSelector("div[class='rc'] h3");
    public test (WebDriver driver) { this.driver = driver; }
    void open( String url) {
        driver.get(url);
    }

    void searchFor (String text) {
        driver.findElement(q).sendKeys(text);
        driver.findElement(q).submit();
    }
    void  checkSearchResult ( String text){
        List<WebElement> searchResults = driver.findElements(list);
        WebElement first  = searchResults.get(0);

        Assert.assertEquals( "Selenium - Поиск Google", driver.getTitle());

        if (first.getText().contains("Selenium")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fall");
        }

    }


        void close(){
        driver.quit();
        }

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","D:\\maven\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }




    @Test
    public void googleTest() {





    }

    @After
    public void shutDown() {
        driver.quit();
    }
}
