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