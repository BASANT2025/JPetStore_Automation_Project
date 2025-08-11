package Utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class U03_Data {


    private static final String TEST_DATA_PATH = "src/test/resources/testdata/";

    public static String getJsonData(String jsonFilename, String field) {
        try {
            // Define object of file Reader
            FileReader reader = new FileReader(TEST_DATA_PATH + jsonFilename + ".json");
            // Parse the JSON directly into a JsonElement
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return jsonElement.getAsJsonObject().get(field).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static Object[][] getJsonDataAsObjectArray(String jsonFilename) {
        try {
            FileReader reader = new FileReader(TEST_DATA_PATH + jsonFilename + ".json");
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            Object[][] data = new Object[jsonArray.size()][1];
            for (int i = 0; i < jsonArray.size(); i++) {
                data[i][0] = jsonArray.get(i).getAsJsonObject();
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Object[0][0]; // Return an empty array on failure
    }


    public static String getPropertyValue(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(TEST_DATA_PATH + fileName + ".properties"));
        return properties.getProperty(key);
    }
}
