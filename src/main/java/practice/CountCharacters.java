package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharacters {
    public static void main(String[] args) {
        System.out.println("Please enter String - ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        CountCharacters countCharacters = new CountCharacters();
        Map<String, Integer> countCharactersMap = countCharacters.countCharacters(str);
    }

    public Map<String, Integer> countCharacters(String a) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            String c = String.valueOf(a.charAt(i));
            if (!(c.equals(" "))) {
                if (!(stringIntegerMap.containsKey(c))) {
                    stringIntegerMap.put(c, 1);
                } else {
                    stringIntegerMap.put(c, stringIntegerMap.get(c) + 1);
                }
            }
         }
        for (String str : stringIntegerMap.keySet()) {
            System.out.println("Count for string "+ str + " is - "+stringIntegerMap.get(str));
        }
        return stringIntegerMap;
    }
}

