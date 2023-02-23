package api.util;

import files.util.Globals;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    private static Globals dataPath = Globals.DOWNLOAD_LOCATION;

    public static JSONObject readJSONArray(String fileName) {
        try {
            File file = new File(dataPath + fileName);
            JSONParser parser = new JSONParser();
            JSONObject jsonArray = (JSONObject) parser.parse(new FileReader(file.getAbsolutePath()));
            return jsonArray;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONArray readFileToJSONArray (String fileName) {
        try {
            File file = new File(dataPath + fileName);
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file.getAbsolutePath()));
            return jsonArray;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
