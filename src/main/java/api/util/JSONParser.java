package api.util;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

public class JSONParser {
    public HashMap<String, String> deserialize(String path) {
        Gson gson = new Gson();
        HashMap<String, String> data = null;
        try (Reader reader = new FileReader(path)) {
            data = gson.fromJson (reader, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
