package datastructures.hashtables;

public class HashTable {

    private int size = 7;
    private Node[] dataMap; // an array that contains pointers to Nodes

    public class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i]; // asciiValue for letter 'p' = 112
            hash = (hash + asciiValue * 23) % dataMap.length; // multiply by prime number 23, or any other prime number, and number will be more random
            // dataMap.length = 7, when we say modulo 7 it gives us the remainder if you did division. Anything you divide by 7 will have a remainder of 0 at the lowest end, and 6 as the highest number remainder you can have.
            //  so this makes it so that our range is 0 to 6, and our address space just so happens to be 0 through 6.
            // So this equation is always going to return a number that is one of the indexes in this array
        }
        // So after we go through this for loop for all of those characters at the end of this we will return hash, and that hash will always be a number between 0 and 6. 
        return hash;
    }
}
