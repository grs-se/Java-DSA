package datastructures.trees;

public class BinarySearchTree {

    Node root; // Need this public during development, otherwise mark as private

    class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value); // Create a new Node object called newNode with the given integer value.
        if (root == null) { // If the root node is null, set the root to the newNode and return true.
            root = newNode;
            return true;
        }
        Node temp = root; // Create a temporary node called temp and set it to the root node.
        while (true) { // Use a while loop to traverse the tree:
            if (newNode.value == temp.value) return false; // If the newNode value is equal to the temp node value, return false (no duplicates allowed).
            if (newNode.value < temp.value) { // If the newNode value is less than the temp node value:
                if (temp.left == null) { // If the left child of temp is null, set the left child to newNode and return true.
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left; // Otherwise, set temp to its left child.
            } else { // If the newNode value is greater than the temp node value:
                if (temp.right == null) { // If the right child of temp is null, set the right child to newNode and return true.
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right; // Otherwise, set temp to its right child.
            }
        }
    }

    public boolean contains(int value) {
        // If the root node is null, return false.
        Node temp = root; // Create a temporary node called temp and set it to the root node.
        while (temp != null) { // Use a while loop to traverse the tree:
            if (value < temp.value) { // If the given value is less than the temp node value, set temp to its left child.
                temp = temp.left;
            } else if (value > temp.value) { // If the given value is greater than the temp node value, set temp to its right child.
                temp = temp.right;
            } else { // If the given value is equal to the temp node value, return true.
                return true;
            }
        }
        return false; // If the loop exits without finding a match, return false.
    }
}
