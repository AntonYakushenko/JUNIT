import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnit {
    String SITE_URL = "https://yandex.ru/";
    static WebDriver driver;

    @BeforeEach
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //отодвигает контекст просмотра Chrome на задний план.

        Point p = driver.manage().window().getPosition();
        Dimension d = driver.manage().window().getSize();
        driver.manage().window().setPosition(new Point((d.getHeight()-p.getX()), (d.getWidth()-p.getY())));
    }

    //карта мап купить
    @ParameterizedTest
    @ValueSource(strings = {"карта мап купить", "карта мап купить спб","карточка мап купить","карточка мап купить спб"})
    public void firstTest(String text) throws InterruptedException {
        driver.get(SITE_URL);

        WebElement username = driver.findElement(By.xpath("//input[@tabindex='2']"));
        Thread.sleep(2000);

        username.sendKeys(text, Keys.ENTER);

        Thread.sleep(2000);

        WebElement ttcsite = driver.findElement(By.partialLinkText("ttc.com.ru"));
        ttcsite.click();
        Thread.sleep(2000);
        driver.quit();
    }
}