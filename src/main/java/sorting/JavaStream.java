package sorting;

import api.util.JSONParser;
import api.util.JsonTree;
import files.util.Globals;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaStream {

    @BeforeGroups(value="java-stream")
    public void beforeJavaStreamGroups() {
        System.out.println("Before Java Stream Groups");
    }


    @BeforeClass
    public void beforeJavaStream() {
        System.out.println("Before Java Stream Class Test");
    }

    @Test (priority = 2, groups = "java-stream")
    public void testJavaStream() {

        System.out.println("Method name is - testJavaStream");

        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        // demonstration of map method
        List<Integer> square = number.stream().map(x -> x * x).
                collect(Collectors.toList());
        System.out.println(square);

        // create a list of String
        List<String> names =
                Arrays.asList("Reflection", "Collection", "Stream");

        // demonstration of filter method
        List<String> result = names.stream().filter(s -> s.startsWith("S")).
                collect(Collectors.toList());
        System.out.println(result);

        // demonstration of sorted method
        List<String> show =
                names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

        // create a list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);
        List<Integer> numbers1 = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(numbers1);

        // collect method returns a set
        Set<Integer> squareSet =
                numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);

        // demonstration of forEach method
        number.stream().map(x -> x * x).forEach(y -> System.out.println(y));

        // demonstration of reduce method
        int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);

        System.out.println(even);
    }

    @Test (priority = 1, groups = "java-stream")
    public void testJsonObject() throws IOException {
        System.out.println("Method name is - testJsonObject");
        Map<String, Map<String, Object>> jsonObject = new JsonTree().convertJsonToMaps(Globals.PROJECT_PATH + "/src/main/java/payload/AddBook.json");
        System.out.println(jsonObject.get("name1").get("author"));
        Map<String, String> map = (Map<String, String>) jsonObject.get("name1").get("author");
        System.out.println(map.get("isbn"));

        Map<String, String> map1 = new JSONParser().deserialize(Globals.PROJECT_PATH + "/src/main/java/payload/AddBook.json");
        System.out.println(map1);
    }

    @AfterClass
    public void afterJavaStream() {
        System.out.println("After Java Stream Class Test");
    }

    @AfterGroups(value = "java-stream")
    public void afterJavaStreamGroups() {
        System.out.println("After Java Stream Groups");
    }


}
