
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
public class ProductListDesc {
    PageActions pageAction = new PageActions();
    String currentBrowser;
    @Parameters("browser")
    @BeforeClass

  // Passing Browser parameter from TestNG xml

    public void beforeTest(String browser) {
        this.currentBrowser = browser;
    }

    @Test
    public void startBrowserAndNavigateToTatocAdvanced(){
        Assert.assertTrue(pageAction.startBrowserAndNavigate(this.currentBrowser));
    }
    
    @Test(dependsOnMethods = {"startBrowserAndNavigateToTatocAdvanced"})
    public void sortDesc(){
        Assert.assertTrue(pageAction.sort("//*[@id='desktopSearchResults']/div[1]/section/div[1]/div[1]/div/div/div/ul/li[4]"));
    }
    
    @Test(dependsOnMethods = {"sortDesc"})
    public void checkListOrder() throws InterruptedException{
        Assert.assertTrue(pageAction.checkListOrder("desc"));
    }
    

}
