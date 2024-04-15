package dataTypes.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainComparatorClass {
    public static void main(String[] args) {
        List<Student> ar = new ArrayList<Student>();
        ar.add(new Student(100, "Ashish", "Australia"));
        ar.add(new Student(98, "Sim", "India"));
        ar.add(new Student(101, "Rohit", "India"));
        ar.add(new Student(97, "Vandna", "UK"));

        System.out.println("Unsorted");

        for (int i=0; i< ar.size(); i++) System.out.println(ar.get(i));

        System.out.println("Sorted by name");
        Collections.sort(ar, new SortByName());

        for (int i=0; i< ar.size(); i++) System.out.println(ar.get(i));

        System.out.println("Sorted by Roll Number");
        Collections.sort(ar, new SortByRoll());

        for (int i=0; i< ar.size(); i++) System.out.println(ar.get(i));
    }

}
