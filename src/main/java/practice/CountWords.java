package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        System.out.println("Please enter String - ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        CountWords countWords = new CountWords();
        Map<String, Integer> countWordsMap = countWords.countWords(str);
    }

    public Map<String, Integer> countWords(String a) {
        String[] splitStr = a.split(" ");
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < splitStr.length; i++) {
            if (!stringIntegerMap.containsKey(splitStr[i])) {
                stringIntegerMap.put(splitStr[i], 1);
            } else {
                stringIntegerMap.put(splitStr[i], stringIntegerMap.get(splitStr[i]) + 1);
            }
         }
        for (String str : stringIntegerMap.keySet()) {
            System.out.println("Count for string "+ str + " is - "+stringIntegerMap.get(str));

        }
        return stringIntegerMap;
    }
}

