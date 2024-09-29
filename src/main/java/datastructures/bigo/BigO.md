# Big O
## Big O: Intro
What is Big O?
- Big O is a way of comparing two sets of code.
- lets say code1 and code2 accomplish exactly the same thing.
- BogO is about comparing code1 and code2 mathematically, how efficient they run.
- In a coding interview you will be asked qs about BigO
- if code2 runs a lot longer you would say code1 is better, you can measure it. This is called **Time Complexity**.
- The thing about Time complexity that is interesting is that it is not measured in time because if you took this same code and ran it on a computer that is twice as fast it would compelte twice as fast, but that doesn#t make the code any better, it just measn the computer it better.
- So it is measured in the **number of operations that it takes to complete something**
- In addition to Time Complexity we measure **Space Complexity**
- So let's say that code1 while it runs very fast comparatively lets say it takes up a lot of memory when it runs, and maybe code2 even though it takes a lot longer it takes up a lot less memory. 
- If preserving memory space is your most important priority and you don't mind having some extra time complexity maybe code2 is better.

___

## Big O: Worst Case
- When dealing with time and space complexity you will see these three Greek letters: Omega, Theta, and Omicron.
- Omicron is better known as O as in Big O
- Using a for loop to iterate an array, when looking at how many times we have to iterate, our best case would be looking for number1, worst case looking for number 7, and average case number 4.
- For best case number 1 we use Omega, for average case we use the greek letter Theta, and for worst case we use Greek letter Omicron or O
- One of the things people will say when they talk about your BigO being a particular time complexity is they'll say things like what is your average BigO or best case BigO.
- Technically there is no average case or best case bigO, avergae case would be Theta and best case Omega.
- technically BigO is always worst case

---

## Big O: O(n)

- start with O(n) not because it's the most efficient or least efficient but because it's the easiest to understand.

```java
// O(n)
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }
}
```
-  O(n) on a graph, horizontal axis is n and vertical axis = number of operations
- O(n) on a graph is always going to be a straight line, it is what is called 'proportional'

---

## Big O: Drop Constants

- In Big O we have a few ways we can simplify things. The first thing is 'Drop constants'
- If we have 2 for loops one after the other it would be n + n = 2n, so you might think this would be O(2n) but we simplify this by dropping the constant and it just becomes O(n), and it doesn't matter if the constant is 2 or 10 or 1000, we just remove it and leave it as O(n).
- So our first rule of simplification is 'drop constants'

---

## Big O: O(n^2)

- to make this code O(n^2) all we have to do is make it so that one for loop is inside of the other for loop.

```java
// O(n^2)
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i + " " + j);
        }
    }
}
```
- these for loops ran n * n = n^2.
- So if we passed this a 10 we would have 100 lines output. And that is O(n^2).
- On a graph when compared to O(n), O(n^2) grows much faster, and that means from a Time Complexity perspective it is less efficient.
- So if you have a situation where you have code that is O(n^2) and there is a way of rewriting it where it O(n) that is a huge gain in efficiency.

---

## Drop Non-Dominants

- Another way that we can simplify Big O called Drop Non-Dominants.

```java

class Main {
    // nested for loops above and seperate standalone for loop below
    // nested for loop ran O(n^2)
    public static void printItems(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }

        // O(n)
        for (int k = 0; k < n; k++) {
            System.out.println(k);
        }
    }
    
    public static void main(String[] args) {
        printItems(10);
    }
}
```
- the nested for loop ran O(n^2), and the standalone for loop ran O(n)
- So the total number of operations was n2 + n, so that would be O(n2 + n)
- But as n gets larger the O(n2) grows much faster than the n. even if we only took this to 100 the n2 portion would be 10,000 operations and that standalone n would be a 100 operations.
- So the n2 is the dominant term and the n is the non-dominant term. And as n becomes larger and larger you can see that that standalone n starts becoming irrelevant so we just drop the n, resulting in: O(n2)
- So this rule of simplification is Drop non-dominants.

---
## Big O: O(1)

```java
public static int addItems(int n) {
    return n + n;
}
```
- so it doesn't matter if n is 10 or n is a billion, there is only going to be 1 operation which is the addition, and that is O(1).
- With what we have seen before, as n grows the number of operations grows, in this situation as n grows the number of operations will stay the same.
- So now let's change this from being n + n to being n + n + n

```java
public static int addItems(int n) {
    return n + n + n;
}
```
- now we have 2 operations so we could call this O(2), but we will simplify this and call it O(1)
- O(1) is also called 'constant time'. **It doesn't necessarily mean that there is always going to be one operation. It means that as n grows the number of operations stays constant**
- On a graph O(1) is just going to be a flat line across the bottom. It is the most efficient BigO.
- If you can do something in O(1) time it is always going to be much more efficient than anything else.

---

## Big O: O(log n)

- {1,2,3,4,5,6,7,8}
- Bring up a sorted array. To do what we have to do here the data does have to be sorted.
- Let's say we want to find a particular value in this array, say the number 1.
- What is the quickest way to narrow this down to get to that 1?
- The quickest way would be to cut the array in half and see if the array is in the first half or second half. 
- So it is not in the 2nd half so we don't have to look at any of those numbers. 
- That may not seem like a big deal with an array of only 8 numbers in it but if we had an array with a million items in it, that's a half million items that you don't have to even look at. So that is a pretty big deal.
- And then we can take that array and do it again and we know it is not in the 2nd half so we can remove those, and then we do it again and then we'll find the number that we're lookinf for.
- So let's bring back all of the other items in the array and see how many steps it took to find the number 1, it was 3 steps.
- {1,2,3,4} {5,6,7,8} = {1,2} {3,4} = {1} {2} = 1
- Remeber we had 8 items in this array and it just so happens that 2 to 3rd power 2^3 = 8.
- So now we will take this equation and turn it into a log-rhythm. 
-  log base 2 of 8=3 or log _(2)(8)=3
- so what this is basically saying is 2 to the what (?) power = 8? 2 to the 3rd power = 8
- In other words if you took the number 8 and repeatedly divided it by 2 how many times would it take to get down to 1 item, and that is 3 times. 
- But the real power of this is when we're dealing with very large numbers
- log _(2)(1,073,741,824). How many times would you need to cut this number in half to get down to 1 item. The answer is only 31 times.
- So you can have an array with over a billion items in it and find any item in it in only 31 steps.
- And that is the power of O(log n).
- On a graph this is very flat, very efficient. Not as efficient as O(1) of course but it is the next best thing. 
- Everything in this course will be 1 of these 4 excpet for O(nlog n) that is used in some sorting algorithms, like quick sort and merge sort.

---

## Different Terms for Inputs

```java

public static void printItems(int a, int b) {
    // O(n)
    for (int i = 0; i < a; i++) {
        System.out.println(i);
    }

    // O(n)
    for (int j = 0; j < b; j++) {
        System.out.println(i + " " + j);
    }
    // = O(a * b)
}

```
- O(n) + O(n) = O(2n) = (drop constant) = 0(n)
- but that is not correct from an algebraic standpoint, you cannot say that a is equal to n and b is also equal to n. You would have to say that this is O(a) and this is O(b) and when you add them together this becomes O(a + b), and that is as far as you can simplify this. And the reason for that is if a is 1 and b is a billion these would be two very different for loops, and you would have to understand how each one works to understand time complexity of the entire method.
- likewise if we took these 2 for loops and instead of having them one after the other we had them one inside of the other, this would become O(a * b).

```java
public static void printItems(int a, int b) {
    for (int i = 0; i < a; i++) {
        for (int j = 0; j < b; j++) {
            System.out.println(j);
        }
    }
}

```
- we can't just say O(n), we would have to say O(a * b). We have to use different terms for different inputs.

---

## Big O: Array Lists

```java

{11,3,23,7}
ArrayList<int> myList = new ArrayList<>(); // 11, 3, 23, 7
myList.add(17);

```

- When we add somethign to the end of this array list it's a pretty simple process because we don't have any re-indexing. All the way down these indexes do not need to be changed.
- Likewise when we remove this item with te index of 4 and we remove that there is nothing that needs to be re-indexed in the array list, so it is one operation to add something one operation to remove something, so it is O(1)
- This is different if we do something on the other end of the array list. So we say myList.remove(0), when we remove this the probkem that we have is that this is no longer at the correct index so we need to chagne this index of 1 here to be index of 0, and we need to do this all the way down and touch every item in the array list. 
- Also if we add an item at the index of 0, we need to change the indexes of the other items in the array, pushing each up, to make room for the new value to be at the index of 0.
- So in this case n is the number of items in the array list, and because we had to touch each item that means this is O(n). 
- So it is O(1) on this (far) end when you're adding or removing something but it is O(n) to do those things at the near/left end. So if we remove an item at that end we have to reindex everything and if we add an item back in we have to reindex everything back.
- So it's O(1) on one end and O(n) on the other.
- So if we say myList.add(1, 99) - {11, 99, 3, 23, 7} - so you to touch and reindex all items after the insert.
- So you might say that this should be O(1/2 n) because on average this insert is going to be somewhere in the middle and you only have to touch half the items.
- However there are two problems with that logic. First BigO measures worst case not average case.
- But even if O(1/2 n) was our worst case, 1/2 is a constant and we drop constants.
- So likewise when we go to remove that item we're going to have to reindex everything that comes after it again so it doesn't matter if it is an insert or a remove it is O(n)
- Now let's look at finding something by value. 
- Looking for item by value is O(n).
- But it's different if we're looking by index. If we're looking for the index of 3 we do not have to iterate all the way through this we can go directly to this index and that is O(1)

---

## Big 0: Wrap Up

- O(n2) is a loop within a loop
- O(n) is Proportional, it will always be a straight line
- O(log n) is Divide and Conquer, when you hear that it is O(log n)
- O(n) is constant time.

---
- Big O Complexity chart
- O(n), O(log n), O(1) is where we want to stay.
- common data structure operations
- variety of data structures compared by time complexity.
- One of the reasons why we spend all of the time on time complexity over space complexity is that in the entire data structures section all the space complexity is going to be the same.
- 