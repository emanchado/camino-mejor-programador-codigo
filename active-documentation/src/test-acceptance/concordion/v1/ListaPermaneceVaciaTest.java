package concordion.v1;

import org.concordion.integration.junit3.ConcordionTestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import server.NeverReadServer;

import java.util.List;

public class ListaPermaneceVaciaTest extends ConcordionTestCase {
    private WebDriver webDriver;
    private NeverReadServer neverread;

    @SuppressWarnings(value = "unused")
    public String articleListAfterAdding(String url) throws InterruptedException {
        webDriver.findElement(By.name("url")).sendKeys(url, Keys.ENTER);
        List<WebElement> pendingArticles = webDriver.findElements(By.cssSelector("li"));

        return convertListOfArticlesToString(pendingArticles);
    }

    private static String convertListOfArticlesToString(List<WebElement> pendingArticles) {
        if (pendingArticles.isEmpty()) {
            return "vacía";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(pendingArticles.get(0).getText());

            for (int i = 1; i < pendingArticles.size(); i++) {
                stringBuilder.append(", ").append(pendingArticles.get(i).getText());
            }
            return stringBuilder.toString();
        }
    }

    @Before
    public void setUp() throws Exception {
        neverread = new NeverReadServer();
        neverread.start(8081);

        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8081");
        webDriver = driver;
    }

    @After
    public void tearDown() throws Exception {
        webDriver.close();
        neverread.stop();
    }
}