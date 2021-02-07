
import com.qainfotech.advancedtatoc.PageActions;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ark
 */
public class ProductList {
    PageActions pageAction = new PageActions();
    
    @Test
    public void startBrowserAndNavigateToTatocAdvanced(){
        Assert.assertTrue(pageAction.startBrowserAndNavigate());
    }
    
    @Test(dependsOnMethods = {"startBrowserAndNavigateToTatocAdvanced"})
    public void sort(){
        Assert.assertTrue(pageAction.sort());
    }
    
    @Test(dependsOnMethods = {"sort"})
    public void checkListOrder() throws InterruptedException{
        Assert.assertTrue(pageAction.checkListOrder());
    }
    
    // @Test(dependsOnMethods = {"enterCredentialsAndSubmit"})
    // public void restfulTokenProceed() throws ParseException{
    //     Assert.assertTrue(pageAction.registerGeneratedTokenAndProceed("http://10.0.1.86/tatoc/advanced/rest"));
    // }
}
