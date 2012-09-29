package concordion.v5_with_synchronisation.tools;

import concordion.Functional.Functor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static concordion.Functional.collect;

public class NeverReadDriver {
    private final WebDriver webDriver;

    public static NeverReadDriver start(String url) {
        return new NeverReadDriver(startWebDriver(url));
    }

    public void addArticle(String url) {
        webDriver.findElement(By.name("url")).sendKeys(url, Keys.ENTER);

        new WebDriverWait(webDriver, 2).until(new ExpectedCondition<Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return "".equals(webDriver.findElement(By.name("url")).getAttribute("value"));
            }
        });
    }

    public List<String> getListOfArticles() {
        return webElementsToTheirTexts(webDriver.findElements(By.cssSelector("li")));
    }

    public void close() {
        webDriver.close();
    }

    public NeverReadDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static WebDriver startWebDriver(String url) {
        WebDriver driver = new HtmlUnitDriver(true);
        driver.get(url);

        return driver;
    }

    private static List<String> webElementsToTheirTexts(List<WebElement> pendingArticles) {
        return collect(pendingArticles, new Functor<WebElement, String>() {
            @Override
            public String execute(WebElement element) {
                return element.getText();
            }
        });
    }
}