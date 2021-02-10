
import com.qainfotech.myntra.PageActions;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ark
 */
public class ProductListAsc {
    PageActions pageAction = new PageActions();
    String currentBrowser;
    @Parameters("browser")
    @BeforeClass

    public void beforeTest(String browser) {
        this.currentBrowser = browser;
    }


    @Test
    public void startBrowserAndNavigateToTatocAdvanced(){
        Assert.assertTrue(pageAction.startBrowserAndNavigate(this.currentBrowser));
    }
    
    @Test(dependsOnMethods = {"startBrowserAndNavigateToTatocAdvanced"})
    public void sortAsc(){
        Assert.assertTrue(pageAction.sort("//*[@id='desktopSearchResults']/div[1]/section/div[1]/div[1]/div/div/div/ul/li[4]"));
    }
    
    @Test(dependsOnMethods = {"sortAsc"})
    public void checkListOrder() throws InterruptedException{
        Assert.assertTrue(pageAction.checkListOrder("asc"));
    }
    
}
