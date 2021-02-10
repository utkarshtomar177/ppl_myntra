
import com.qainfotech.myntra.PageActions;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;


import res.PageObjects.pageLocator;

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
    // PageObjects pageObjects = new PageObjects();
    String currentBrowser;
    @Parameters("browser")
    @BeforeClass



    public void beforeTest(String browser) {
        this.currentBrowser = browser;
    }

    @Test
    public void startBrowserAndNavigateToUrl(){
       
        Assert.assertTrue(pageAction.startBrowserAndNavigate(this.currentBrowser , pageLocator.Url.get() ));
    }
    
    @Test(dependsOnMethods = {"startBrowserAndNavigateToUrl"})
    public void sortDesc(){
        Assert.assertTrue(pageAction.sort(pageLocator.sortDescending.get()));
    }
    
    @Test(dependsOnMethods = {"sortDesc"})
    public void checkListOrder() throws InterruptedException{
        Assert.assertTrue(pageAction.checkListOrder("desc"));
    }
    

}
