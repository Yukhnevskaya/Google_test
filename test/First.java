package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static javax.print.attribute.standard.MediaSizeName.D;

public class First {
    private test page;
    private String baseUrl;

    @Before
    public void  setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\maven\\chromedriver.exe");
            page = PageFactory.initElements(new ChromeDriver(), test.class);
        baseUrl = "https://accounts.google.com/signin/v2";
      page.open(baseUrl);

    }
    @Test
    public void googleTest(){
        page.searchFor( "Selenium");
        page.checkSearchResult ("Selenium");

    }
    @After
    public void shutDown(){
        page.close();

    }
}
