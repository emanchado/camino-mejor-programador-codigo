package concordion.v3_pagedriver.tools;

import concordion.Functional;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static concordion.Functional.collect;

public class PageDriver {
    private final WebDriver webDriver;

    public PageDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static PageDriver start(String url) {
        return new PageDriver(startWebDriver(url));
    }

    public static WebDriver startWebDriver(String url) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get(url);
        return driver;
    }

    public void enterIntoNewArticlesTextBox(String url) {
        webDriver.findElement(By.name("url")).sendKeys(url, Keys.ENTER);
    }

    public List<String> getArticlesInListOfArticles() {
        return collect(webDriver.findElements(By.cssSelector("li")), new Functional.Functor<WebElement, String>(){
            @Override
            public String execute(WebElement element) {
                return element.getText();
            }
        });
    }

    public void close() {
        webDriver.close();
    }
}
