package dataTypes.comparator;

public class Student {
    int rollNo;
    String name, address;

    public Student(int rollNo1, String name1, String address1) {
        this.rollNo = rollNo1;
        this.name = name1;
        this.address = address1;
    }

    public String toString() {
        return this.rollNo + this.name + this.address;
    }
}
