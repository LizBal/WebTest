import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Allita\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.99-bottles-of-beer.net/");

    }
    @AfterMethod
    public void setDown() {
        driver.quit();
    }


    @Test
    public void testFirst() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();


        driver.get(url);
        Thread.sleep(3000);

        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
        driver.close();
        driver.quit();


    }
    @Test

    public void testSecond() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        Thread.sleep(3000);

        WebElement header = driver.findElement(By.xpath("//div[@id='main']/h2"));

        String actualResult = header.getText();
        String expectedResult = "Welcome to 99 Bottles of Beer";
        Assert.assertEquals(actualResult,expectedResult);
        driver.close();
        driver.quit();


    }
}
