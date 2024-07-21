package linkedlist;

// a linkedlist acts like a set of nested hashmaps: head={"value"=3,"next"={"value"=12,"next"={etc...}}}
public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // technically pointer to the node but can think of it as returning a Node
    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}

/**
 * LL: Constructor
 * Create a constructor for a LinkedList class that initializes a new linked list with a single node.
 *
 * Instructions:
 *
 * Understand the Node Structure:
 *
 * Before writing the constructor, ensure you're familiar with the Node class, which is a nested class within the LinkedList class. Each Node should hold an integer value and a reference to the next node (Node next). For the initial node, next will be null.
 *
 * Constructor Signature:
 *
 * Your constructor should be public and named LinkedList. It will accept a single integer argument, value, which represents the data to store in the list's first node.
 *
 * Create the First Node:
 *
 * Inside the constructor, use the passed value to create a new instance of the Node class. This instance will be the first and only node in your linked list upon creation.
 *
 * Initialize Head and Tail:
 *
 * Assign the newly created node to both the head and tail of the linked list. This is because, initially, the list contains only one node, making it both the beginning and end of the list.
 *
 * Set the List Length:
 *
 * Initialize the length of the linked list to 1, reflecting that the list currently contains a single node.
 *
 *
 *
 * Deliverable:
 *
 * Implement the LinkedList constructor following the above guidelines. This constructor will lay the foundation for further methods you might implement in the LinkedList class, such as adding or removing nodes, searching for values, etc.
 */

/**
 * LL: Append
 * Implement the append method that appends a new node to the end of the linked list.
 *
 * Return type: void
 *
 *
 *
 * The method should perform the following tasks:
 *
 * Accept an integer value as an argument, which will be the value of the new node.
 *
 * Create a new Node object called newNode with the given value.
 *
 * If the length of the linked list is 0, set both the head and tail pointers of the list to the newNode.
 *
 * If the length of the linked list is greater than 0, perform the following tasks:
 *
 * Set the next attribute of the current tail node to the newNode.
 *
 * Update the tail pointer of the list to point to the newNode.
 *
 * Increment the length attribute of the list by 1.
 */

/**
 * LL: Remove Last
 * Implement a method called removeLast that removes the last node from the linked list.
 *
 * Return type: Node (we are returning the Node that is being removed)
 *
 *
 *
 * The method should perform the following tasks:
 *
 * If the length of the linked list is 0, return null.
 *
 * Create two variables that can point to a Node , temp and pre, both initially pointing to the head of the linked list.
 *
 * Traverse the linked list until temp.next is null, performing the following tasks during traversal:
 *
 * Update pre to point to the current temp node.
 *
 * Update temp to point to the next node in the linked list.
 *
 * After traversal, set the tail pointer to pre.
 *
 * Set the next attribute of the tail node to null.
 *
 * Decrement the length attribute of the list by 1.
 *
 * If the length of the linked list becomes 0 after removing the last node, set both the head and tail pointers to null.
 *
 * Return the removed node (pointed to by temp).
 */

/**
 * LL: Prepend
 * Implement a method called prepend that adds a new node at the beginning of the linked list.
 *
 * Return type: void
 *
 *
 *
 * The method should perform the following tasks:
 *
 * Accept an integer value as an argument, which will be the value of the new node.
 *
 * Create a new Node object called newNode with the given value.
 *
 * If the length of the linked list is 0, set both the head and tail pointers of the list to the newNode.
 *
 * If the length of the linked list is greater than 0, perform the following tasks:
 *
 * Set the next attribute of newNode to the current head node.
 *
 * Update the head pointer of the list to point to the newNode.
 *
 * Increment the length attribute of the list by 1.
 */

/**
 * LL: Remove First
 * Implement a method called removeFirst that removes the first node from the linked list and returns it.
 *
 * Return type: Node (the node that is removed)
 *
 *
 *
 * The method should perform the following tasks:
 *
 * If the length of the linked list is 0, return null.
 *
 * Create a temporary Node object called temp and set it to the current head node.
 *
 * Update the head pointer of the list to point to the next node in the list.
 *
 * Set the next attribute of temp to null.
 *
 * Decrement the length attribute of the list by 1.
 *
 * If the length of the list becomes 0 after removing the first node, set the tail pointer to null.
 *
 * Return the removed temp node.
 */

/**
 *
 LL: Get
 Implement a method called get that retrieves a node from the linked list by its index.

 Return type: Node



 The method should perform the following tasks:

 Accept an integer index as an argument, which will be the index of the node to be retrieved.

 If the index is less than 0 or greater than or equal to the length of the linked list, return null.

 Create a temporary Node object called temp and set it to the current head node.

 Iterate through the linked list by updating temp to its next node until the desired index is reached.

 Return the node located at the specified index.

 */

/**
 * LL: Set
 * Implement a method called set that updates the value of a node in the linked list by its index.
 *
 * Return type: boolean
 *
 * Method signature: public boolean set(int index, int value)
 *
 *
 *
 * The method should perform the following tasks:
 *
 * Accept an integer index as an argument, representing the index of the node to be updated.
 *
 * Accept an integer value as an argument, representing the new value to set for the node at the specified index.
 *
 * Call the get method with the provided index to obtain a pointer to the node at the specified index.
 *
 * If the node exists (i.e., the get method returns a non-null value), update the node's value with the provided value and return true.
 *
 * If the node does not exist (i.e., the get method returns null), return false.
 */

/**
 * LL: Insert
 * Implement a method called insert that inserts a new node at a specified index in the linked list.
 *
 * Return type: boolean
 *
 * Method signature: public boolean insert(int index, int value)
 *
 *
 *
 * The method should perform the following tasks:
 *
 * Accept an integer index as an argument, representing the index at which the new node should be inserted.
 *
 * Accept an integer value as an argument, representing the value of the new node.
 *
 * If the index is less than 0 or greater than the length of the list, return false.
 *
 * If the index is 0, call the prepend method with the provided value and return true.
 *
 * If the index is equal to the length of the list, call the append method with the provided value and return true.
 *
 * Create a new Node object called newNode with the provided value.
 *
 * Call the get method with the index minus 1 to obtain the node before the specified index.
 *
 * Update the next attribute of the newNode to point to the next attribute of the node before the specified index.
 *
 * Update the next attribute of the node before the specified index to point to the newNode.
 *
 * Increment the length attribute of the list by 1.
 */

/**
 * LL: Remove
 * Implement a method called remove that removes a node at a specified index in the linked list.
 *
 * Return type: Node (the node that has been removed)
 *
 *
 *
 * The method should perform the following tasks:
 *
 * Accept an integer index as an argument, representing the index of the node to be removed.
 *
 * If the index is less than 0 or greater than or equal to the length of the list, return null.
 *
 * If the index is 0, call the removeFirst method and return its result.
 *
 * If the index is equal to the length of the list minus 1, call the removeLast method and return its result.
 *
 * Call the get method with the index minus 1 to obtain the node before the specified index.
 *
 * Create a temporary Node object called temp and set it to the next attribute of the node before the specified index.
 *
 * Update the next attribute of the node before the specified index to point to the next attribute of the temporary Node object.
 *
 * Set the next attribute of the temporary Node object to null.
 *
 * Decrement the length attribute of the list by 1.
 */

/**
 * LL: Reverse
 * Implement a method called reverse that reverses the order of the nodes in the linked list.
 *
 * When solving the reverse() method, students are not allowed to create a new list or use any additional data structures besides the linked list itself.
 *
 * They must reverse the nodes in the existing linked list by manipulating the pointers between them.
 *
 * Return type: void
 *
 *
 *
 * The method should perform the following tasks:
 *
 * The process of reversing the linked list should be done in one pass of the linked list.
 *
 * Create a temporary Node object called temp and set it to the head attribute of the list.
 *
 * Set the head attribute of the list to the current tail attribute.
 *
 * Set the tail attribute of the list to the temporary Node object.
 *
 * Create a Node object called after and set it to the next attribute of the temporary Node object.
 *
 * Create a Node object called before and initialize it to null.
 *
 * Loop through the linked list using a for loop with a counter variable i, starting from 0 and ending at the length attribute of the list. a. Set the after attribute to the next attribute of the temporary Node object. b. Set the next attribute of the temporary Node object to the before attribute. c. Set the before attribute to the temporary Node object. d. Set the temporary Node object to the after attribute.
 *
 * The method has no return value.
 */