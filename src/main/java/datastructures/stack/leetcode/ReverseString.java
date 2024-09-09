package datastructures.stack.leetcode;

public class ReverseString {
    public static String reverseString(String val) {
        Stack stack = new Stack();

        for (char item : val.toCharArray()) {
            stack.push(item);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);



    /*
        EXPECTED OUTPUT:
        ----------------
        olleh
    */

    }

}
