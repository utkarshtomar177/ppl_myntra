/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qainfotech.myntra;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserDriver;
import utilities.databaseActions;
import utilities.parser;

/**
 *
 * @author Ark
 */
public class PageActions {

     BrowserDriver driver;
    static Boolean isPresent;
    parser parseJSON = new parser();
    
    public Boolean startBrowserAndNavigate(String browser) {
        this.driver = new BrowserDriver(browser);
        this.driver.manage().window().maximize();
        this.driver.get("https://www.myntra.com/men-tshirts");

        return true;
    }
    
    public Boolean sort(String sortOrder){
        Actions action = new Actions(this.driver.typecastToWebdriver());
        WebElement mainMenu = this.driver.findVisibleElement(By.xpath("//*[@id='desktopSearchResults']/div[1]/section/div[1]/div[1]/div/div/div"));
        action.moveToElement(mainMenu); 
        action.build().perform();

        WebElement subMenu = driver.findClickableElement(By.xpath(sortOrder));
        action.moveToElement(subMenu);
        action.click().build().perform();
        // this.failConditionCheck();
        return true;
    }

    public Boolean checkListOrder(String order) throws InterruptedException{
        this.driver.waitForLoad(this.driver.typecastToWebdriver());
        List<Integer> firstFourPrices = new ArrayList<Integer>();
        List<Integer> firstFourPricesSorted = new ArrayList<Integer>();
        List<WebElement> elementlist = this.driver.findElements(By.cssSelector(".results-base .product-base"));
        // System.out.println(elementlist.get(0).getText().substring(elementlist.get(0).getText().indexOf("Rs. ") + 4, elementlist.get(0).getText().length()));
        firstFourPrices.add(Integer.parseInt(elementlist.get(0).getText().substring(elementlist.get(0).getText().indexOf("Rs. ") + 4, elementlist.get(0).getText().length())));
        firstFourPrices.add(Integer.parseInt(elementlist.get(1).getText().substring(elementlist.get(1).getText().indexOf("Rs. ") + 4, elementlist.get(1).getText().length())));
        firstFourPrices.add(Integer.parseInt(elementlist.get(2).getText().substring(elementlist.get(2).getText().indexOf("Rs. ") + 4, elementlist.get(2).getText().length())));
        firstFourPrices.add(Integer.parseInt(elementlist.get(3).getText().substring(elementlist.get(3).getText().indexOf("Rs. ") + 4, elementlist.get(3).getText().length())));
        
        firstFourPricesSorted.add(Integer.parseInt(elementlist.get(0).getText().substring(elementlist.get(0).getText().indexOf("Rs. ") + 4, elementlist.get(0).getText().length())));
        firstFourPricesSorted.add(Integer.parseInt(elementlist.get(1).getText().substring(elementlist.get(1).getText().indexOf("Rs. ") + 4, elementlist.get(1).getText().length())));
        firstFourPricesSorted.add(Integer.parseInt(elementlist.get(2).getText().substring(elementlist.get(2).getText().indexOf("Rs. ") + 4, elementlist.get(2).getText().length())));
        firstFourPricesSorted.add(Integer.parseInt(elementlist.get(3).getText().substring(elementlist.get(3).getText().indexOf("Rs. ") + 4, elementlist.get(3).getText().length())));

        System.out.println( elementlist.get(0).getText().substring(elementlist.get(0).getText().indexOf("Rs. ") + 4, elementlist.get(0).getText().length()));
        System.out.println( elementlist.get(1).getText().substring(elementlist.get(1).getText().indexOf("Rs. ") + 4, elementlist.get(1).getText().length()));
        System.out.println( elementlist.get(2).getText().substring(elementlist.get(2).getText().indexOf("Rs. ") + 4, elementlist.get(2).getText().length()));
        System.out.println( elementlist.get(3).getText().substring(elementlist.get(3).getText().indexOf("Rs. ") + 4, elementlist.get(3).getText().length()));

        if(order == "desc"){
             Collections.sort(firstFourPrices, Collections.reverseOrder()); 
        }else{
            Collections.sort(firstFourPrices, Collections.reverseOrder()); 
        }
       
        
        System.out.println(firstFourPrices.equals(firstFourPricesSorted));
       
        // System.out.println(elementlist.get(0).getText());
        // System.out.println(elementlist.get(1).getText());
        // System.out.println(elementlist.get(2).getText());
        // System.out.println(elementlist.get(3).getText());
        // for (WebElement elem : elementlist) {
        //     // WebElement price = elem.findElement(By.cssSelector(""));
        //     // List<WebElement> prices = elem.findElements(By.xpath("//*[@id='desktopSearchResults']/div[2]/section/ul/li/a/div[2]/div/span[1]/span[1]"));
        //     // System.out.println("here");
        //     // for(var i=0;i<5;i++){
        //     //     System.out.println(prices.get(i).getText());
        //     // }
        //     // prices.get(0).getText();
        //     // for (WebElement price : prices) {
        //     //     System.out.println(price.getText());
        //     // }
            
		// 	// System.out.println(elem.findElement(By.cssSelector(".product-price .product-discountedPrice").getText()));
		// }
        return firstFourPrices.equals(firstFourPricesSorted);
    }
    

}
