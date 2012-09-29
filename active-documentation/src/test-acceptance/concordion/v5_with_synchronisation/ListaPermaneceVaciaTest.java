package concordion.v5_with_synchronisation;

import concordion.v5_with_synchronisation.tools.NeverReadDriver;
import org.concordion.integration.junit3.ConcordionTestCase;
import org.junit.After;
import org.junit.Before;
import server.App;
import server.NeverReadServer;

import java.util.List;

import static concordion.Functional.join;

public class ListaPermaneceVaciaTest extends ConcordionTestCase {
    private NeverReadDriver driver;
    private App app;

    @SuppressWarnings(value = "unused")
    public String articleListAfterAdding(String article) throws InterruptedException {
        driver.addArticle(article);
        return convertListOfArticlesToString(driver.getListOfArticles());
    }

    private static String convertListOfArticlesToString(List<String> pendingArticles) {
        String joined = join(pendingArticles, ", ");
        return joined.isEmpty() ? "vacía" : joined;
    }

    @Before
    public void setUp() throws Exception {
//        app = new MaybeReadServer(); // correctly fails
        app = new NeverReadServer();
        app.start(8081);
        driver = NeverReadDriver.start("http://localhost:8081");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        app.stop();
    }
}