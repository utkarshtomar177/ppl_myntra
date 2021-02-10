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
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserDriver;
import utilities.databaseActions;
import utilities.parser;

import res.PageObjects.pageLocator;


/**
 *
 * @author Ark
 */
public class PageActions {

    BrowserDriver driver;
    static Boolean isPresent;
    parser parseJSON = new parser();
    
    public Boolean startBrowserAndNavigate(String browser , String url) {
        this.driver = new BrowserDriver(browser);
        this.driver.manage().window().maximize();
        this.driver.get(url);

        return true;
    }
    
    public Boolean sort(String sortOrder){
        Actions action = new Actions(this.driver.typecastToWebdriver());
        WebElement mainMenu = this.driver.findVisibleElement(By.xpath( pageLocator.filterMenu.get()));
        action.moveToElement(mainMenu); 
        action.build().perform();

        WebElement subMenu = driver.findClickableElement(By.xpath(sortOrder));
        action.moveToElement(subMenu);
        action.click().build().perform();
        
        return true;
    }

    public Boolean checkListOrder(String order) throws InterruptedException{
        this.driver.waitForLoad(this.driver.typecastToWebdriver());
        List<Integer> firstFourPrices = new ArrayList<Integer>();
        
        List<WebElement> elementlist = this.driver.findElements(By.cssSelector(pageLocator.productPrice.get()));
        // Iterator<WebElement> itr = elementlist.iterator();

        // while(itr.hasNext()) {
            
        //     WebElement row = itr.next();
        //     System.out.println(row.getText());
        //     firstFourPrices.add(Integer.parseInt(row.getText().substring(row.getText().indexOf("Rs. ") + 4, row.getText().length())));
            
        // }
        

        for(var i=0;i<4;i++){
            System.out.println(elementlist.get(i).getText().substring(elementlist.get(i).getText().indexOf("Rs. ") + 4, elementlist.get(i).getText().length()));

            firstFourPrices.add(Integer.parseInt(elementlist.get(i).getText().substring(elementlist.get(i).getText().indexOf("Rs. ") + 4, elementlist.get(i).getText().length())));
        }
        System.out.println(firstFourPrices);
       

       List<Integer> firstFourPricesSorted = new ArrayList<Integer>(firstFourPrices);
        if(order == "desc"){
            Collections.sort(firstFourPricesSorted, Collections.reverseOrder()); 
        }else{
            Collections.sort(firstFourPricesSorted); 
        }
       
        
        System.out.println(firstFourPrices.equals(firstFourPricesSorted));
       

        return firstFourPrices.equals(firstFourPricesSorted);
    }
    

}
