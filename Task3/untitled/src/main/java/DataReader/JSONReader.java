package DataReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JSONReader {
    public static String testDataPath = "src/main/resources/TestData/";
    public static Object[][] readJsonFile(String jsonFileName, String dataType){
        Object[][] data = null ;
        try {
            JSONParser parser= new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(testDataPath + jsonFileName + ".json"));
            System.out.println(jsonObject+"\n");
            JSONArray jsonArray = (JSONArray)  jsonObject.get(dataType);
            data = new Object[jsonArray.size()][1];
            System.out.println(jsonArray);
            for (int i =0 ; i< jsonArray.size();i++){
                HashMap<String,String> map = jsonObjectToHashMap((JSONObject)jsonArray.get(i));
                data[i][0]= map;
                System.out.println(data[i][0] +"\n");
            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return  data;
    }

    private static HashMap<String, String> jsonObjectToHashMap(JSONObject jsonObject) {
        HashMap<String,String> x = new HashMap<>();
        jsonObject.forEach((key,value) -> x.put(key.toString(),value.toString()));
                return x;
    }
    public static void main (String arg []){
       readJsonFile("RegisterTestData","validRegisterData");
    }

}
