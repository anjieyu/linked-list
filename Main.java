import java.util.Scanner;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static ListNode head = null;
    public static void main(String[] args) {
        /**ListNode head = new ListNode();
        ListNode node1 = new ListNode(22);
        ListNode node2 = new ListNode(74);
        ListNode node3 = new ListNode(35);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode pointer = new ListNode();
        pointer = head.next;
        while (pointer != null) {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
        */
        
        // append: a, val
        /** insert: i, val, pos
         * delete: d, pos
         * clear: x
         * create: c
         */
        System.out.println("This is a linked list program where you can make a list of numbers.");
        System.out.println("You can append values, insert them, delete them, clear the list, or create a list.");
        printMainMenu();
        Scanner reader = new Scanner(System.in);
        Boolean running = true;
        String response;
        while (running) {
            System.out.println("What is your choice? ");
            response = reader.next();
            if (response.toUpperCase().equals("E")) {
                System.out.println("Closing program.");
                running = false;
            }
            if (response.toUpperCase().equals("A")) {
                System.out.println("Append");
                System.out.println("What number do you choose?");
                int num = reader.nextInt();
                append(num);
            }
            if (response.toUpperCase().equals("I")) {
                System.out.println("Insert");
                
                System.out.println("What position do you want to insert into the list?");
                int num = reader.nextInt();
                while (num < 0 || num >= getListLength()) {
                    System.out.println("That was not in bounds for the list size");
                    System.out.println("What position do you want to insert into the list?");
                    num = reader.nextInt();
                }
                
                System.out.println("What is the value of the node you want to add?");
                int v = reader.nextInt();
                insert(num, v);
            }
            if (response.toUpperCase().equals("D")) {
                System.out.println("Delete");
                System.out.println("What position node do you want to delete?");
                int num = reader.nextInt();
                while (num < 0 || num >= getListLength()) {
                    System.out.println("That was not in bounds for the list size");
                    System.out.println("What position node do you want to delete?");
                    num = reader.nextInt();
                }
                delete(num);
            }
            if (response.toUpperCase().equals("X")) {
                System.out.println("Clear");
                createHeadNode();
            }
            if (response.toUpperCase().equals("P")) {
                System.out.println("Print");
                printList();
            }
        }
    }
    
    public static void printMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("Append: A");
        System.out.println("Insert: I");
        System.out.println("Delete: D");
        System.out.println("Clear: X");
        System.out.println("Print: P");
        System.out.println("Exit: E");
    }
    
    public static void createHeadNode() {
        head = null;
    }
    
    public static void append(int val) {
        ListNode pointer = new ListNode();
        ListNode newNode = new ListNode(val);
        
        if (head == null) {
            head = newNode;
        } else {
            pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = newNode;
        }
    }
    
    public static void printList() {
        ListNode pointer = new ListNode();
        if (head == null) {
            return;
        }
        pointer = head;
        while (pointer != null) {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }
    
    public static int getListLength() {
        ListNode pointer = new ListNode();
        if (head == null) {
            return 0;
        }
        pointer = head;
        int count = 0;
        while (pointer != null) {
            count ++;
            pointer = pointer.next;
        }
        return count;
    }
    
    public static void insert(int position, int value) {
        ListNode pointer = new ListNode();
        if (head == null && position == 0) {
            ListNode newNode = new ListNode(value);
            head = newNode;
            return;
        } else if (head == null && position != 0) {
            return;
        } else if (head != null && position == 0) {
            ListNode newNode = new ListNode(value);
            newNode.next = head;
            head = newNode;
            return;
        }
        pointer = head;
        for (int i = 0; i < position - 1; i++) {
            pointer = pointer.next;
        }
        ListNode newNode = new ListNode(value);
        // New node's next pointer will point to the current node's next pointer
        // There will be two pointers pointed to the same node at the same time
        newNode.next = pointer.next;
        pointer.next = newNode;
    }
    
    public static void delete(int position) {
        ListNode pointer1 = new ListNode();
        ListNode pointer2 = new ListNode();
        if (head == null) {
            return;
        } else if (head != null && position == 0) {
            pointer1 = head;
            pointer2 = pointer1;
            pointer2 = pointer1.next;
            head = pointer2;
            pointer1 = null;
            return;
        }
        pointer1 = head;
        pointer2 = pointer1;
        for (int i = 0; i < position; i++) {
            pointer2 = pointer1;
            pointer1 = pointer1.next;
        }
        pointer2.next = pointer1.next;
        pointer1 = null;
    }
}
