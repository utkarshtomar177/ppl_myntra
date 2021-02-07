/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Ark
 */
public class parser {
    public JSONArray returnJSONArrayFromJSONIndex(JSONObject obj , String indexName){
        JSONArray list = (JSONArray) obj.get(indexName);
        return list;
    }
    
    public JSONObject returnJSONObjectFromJSONIndex(JSONObject obj , String indexName){
        JSONObject object = (JSONObject) obj.get(indexName);
        return object;
    }
    
    public long splitStringAndReturnLong(String string , String splitter){
        String[] cityWeather = string.split(splitter);
       return Long.parseLong(cityWeather[1]);
    }
}
