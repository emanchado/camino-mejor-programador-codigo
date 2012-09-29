package purejava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import server.NeverReadServer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListaPermaneceVaciaTest {
    private WebDriver webDriver;
    private NeverReadServer neverread;

    @Test
    public void articleListStaysEmptyWhenAddingNewArticle() {
        webDriver.findElement(By.name("url")).sendKeys("art.culo/interesante.html", Keys.ENTER);
        assertThat(webDriver.findElements(By.cssSelector("li")).size(), is(0));
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