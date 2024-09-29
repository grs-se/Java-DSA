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