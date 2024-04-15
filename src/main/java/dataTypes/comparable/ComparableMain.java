package dataTypes.comparable;

import java.util.Arrays;

public class ComparableMain {
    public static void main(String[] args) {

        // Set up array with a few Employee classes
        Employee a[] = new Employee[5];
        a[0] = new Employee("Kirk","Douglas");
        a[1] = new Employee("Mel","Brooks");
        a[2] = new Employee("Jane","Fonda");
        a[3] = new Employee("Henry","Fonda");
        a[4] = new Employee("Michael","Douglas");

        // The .sort() method uses the Comparable interface.
        Arrays.sort(a);

        // Print out the sorted Employees
        for (int i=0; i < a.length; i++) {
            System.out.println(a[i]);

        }
    }
}
