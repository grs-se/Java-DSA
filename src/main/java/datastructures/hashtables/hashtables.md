## Hash Tables

### Intro
- key-value pairs
- {"nails" = 1000}
- we run the hash on the key of the key value pair
- every letter has an ACSI text numerical value
- so we run a calculation on all of the numbers that are associated with these letters, so we run it through the hash
- we do get the key-value pair back
- the hash gives us an address. That address will be on eof the indexes of the array and that's where we store our key-value pai
- the hash is 'one way' - you can't do it the other way.
- Hash method is "Deterministic" which means every single time we run "nails" through this we will always get the same address;
- So the Hash method is both of these things: 'One-way' and 'Deterministic'.
- can get 'collisions' - don't want to just overwrite address, you want to be able to keep both.
- there are multiple ways of storing multiple items at a particular address 
---

### Collisions
- one way of dealing with collision is that you put the next key-bvalue pair at the same address even if there is already one there
- this method is called 'Separate Chaining'
- Another common wya of doing this is if there is already an item where you want to put somethign yo u just go to ther next open spot and put it there, and if you're going to add another item you jsut keep going until you find another open spot
- This is called 'Linear Probing' - this is one of the types of 'open addressing'
- 'separate chaining' and 'linear probing' are the most common ways of dealing with 'collisions'
- in this course the way in which we will deal with collisions is with 'separate chaining'
- we will have a LinkedList at eahc one of these addresses
- A linkedList is a common way of implementing seperate chaining and putting multiple items at a particular address
- we have fewer collisions if our table has a prime number of addresses

---
### Hash Method

```java
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
```

---
### HT: Big O
- hash method itself is O(1) because it goes through the same number of operations to determine a hash regardless of the number of items that are already in the hash table.
- set = run through hash method, gives us index of 0, add an item with that in single step, = o(1)
- get = get("screws"), run it through hash method, gives us index of 6, find it in 1 step.
- but what if our hashtable doesn't have values at each table index but one table index has a list of lots of values (i.e. is a LinkedList)? This would be O(n)
- However, when creating a hashtable the assumption is that your hash will create very random addresses and that you'll have a larger address space, a very good hash method that will randomize where these things are put, and becayse of that we treat getting and setting an item in a hashtable as O(1)  