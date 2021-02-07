/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author Ark
 */
public class reader {
    public BufferedReader readFromTxt(String location) throws FileNotFoundException{
        BufferedReader br;
        try{
            File file = new File(location);
            br = new BufferedReader(new FileReader(file)); 
            return br;

        }catch (FileNotFoundException exception) {
            
            System.out.println("File you're trying to locate , doesn't exist!");
            
        }
        return null;
    }
    
    public JSONArray readFromJsonAndReturnJSONArray(String location , String index) throws IOException, org.json.simple.parser.ParseException{
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(location))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray list = (JSONArray) jsonObject.get(index);
            
            return list;
          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
     public JSONObject readFromJSONAndReturnJSONObject(String location , String index) throws IOException, org.json.simple.parser.ParseException{
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(location))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            return (JSONObject)jsonObject.get(index);
          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
}
