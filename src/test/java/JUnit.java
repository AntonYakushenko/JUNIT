import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnit {
    String SITE_URL = "https://yandex.ru/";
    WebDriver driver;

    @BeforeAll
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //карта мап купить
    @ParametrizedTest
    public void firstTest() throws InterruptedException {
        driver.get(SITE_URL);

        WebElement username = driver.findElement(By.xpath("//input[@tabindex='2']"));
        Thread.sleep(5000);

        username.sendKeys("карта мап купить", Keys.ENTER);

        Thread.sleep(5000);

        WebElement ttcsite = driver.findElement(By.partialLinkText("ttc.com.ru"));
        ttcsite.click();
    }
}