package api.util;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JsonTree {

    private static final Logger logger = Logger.getLogger(JsonTree.class);
    public static String convertToJson (Map<String, String> parameters) {
        Map<String, Object> map = new HashMap<>();
        for (String key:parameters.keySet()) {
            map = convertToMaps(key, parameters.get(key), map);
        }
        return JSONValue.toJSONString (map);
    }

    private static Map<String, Object> convertToMaps (String key, String value, Map<String, Object> map) {
        int dotPos=key.indexOf(".");
        if (dotPos== -1) {
            map.put(key, value);
            return map;
        } else {
            String start = key.substring(0, dotPos);
            String rest = key.substring(dotPos + 1);
            Map<String, Object> subMap = new HashMap<>();
            if (map.containsKey(start)) {
                subMap = (Map) map.get(start);
                map.put(start, convertToMaps(rest, value, (Map) subMap));
            }
            map.put(start, convertToMaps(rest, value, (Map) subMap));
        }
        logger.info("The map");
        return map;
    }

    public Map<String, Map<String, Object>> convertJsonToMaps (String filePath) throws IOException {
        String myJson = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
//        JSONObject myJsonObject = new JSONObject(myJson);
        Map<String, Map<String, Object>> map = new Gson().fromJson(myJson, Map.class);
        return map;
    }

}
