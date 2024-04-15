package dataTypes;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    public static void main(String[] args) {
        EmployeeLinkedList employeeLinkedList = new EmployeeLinkedList();
        System.out.println("List is - empty or not "+employeeLinkedList.isEmpty());
        employeeLinkedList.addToFront(new Employee("Jane", "Jones", 1));
        employeeLinkedList.addToFront(new Employee("Jane2", "Jones2", 2));
        employeeLinkedList.addToFront(new Employee("Jane3", "Jones3", 3));
        employeeLinkedList.addToFront(new Employee("Jane4", "Jones4", 4));
        employeeLinkedList.printList();
        System.out.println("Size is "+employeeLinkedList.getSize());
        System.out.println("List is - empty or not "+employeeLinkedList.isEmpty());

        System.out.println("\n");
        employeeLinkedList.removeFromFront();
        System.out.println("Size - "+employeeLinkedList.getSize());
        employeeLinkedList.printList();
    }

    public void addToFront(Employee employee) {
        EmployeeNode employeeNode = new EmployeeNode(employee);
        employeeNode.setNext(head);
        head = employeeNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removeNode = head;
        head = head.getNext();
        size --;
        removeNode.setNext(null);
        return removeNode;
    }

    public void printList() {
        EmployeeNode employeeNode = head;
        System.out.println("HEAD -> ");
        while (employeeNode != null) {
            System.out.println(employeeNode.getEmployee().toString());
            System.out.println(" -> ");
            employeeNode = employeeNode.getNext();
        }
    }
}
