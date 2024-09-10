## Trees

### Intro and Terminology
- A lInkedList is just a tree that doesn't fork
- binary tree node
- can only point to left and right, can only point to 2 other nodes, that's what makes it a binary tree, but there is no rule that says it has tobe a binary tree, yopu can have each node point to 3 nodes or 10 or 100 nodes.
- and the 2 node weve added can also point to 2 nodes themselves.
- a 'full' tree is where every node either points to 2 nodes or 0 nodes 
- with a 'perfect tree' any level of the tree that has any nodes is completely filled all the wya across, but if we remove these 2 it is no longer perfect but it is still 'full'.
- a 'perfect' tree is also something else, it is 'complete' - so with a complete tree you are fuilling the tree from left to right with no gaps.
- so if we add a node down ehre it is still competle because we are filling the tree from left to right, but it is no longer full and it is no longer perfect
- a tree can be full, perfect, and complete
- Parent and Child nodes, if 2 child nodes share the same parent node they are also called siblings
- every node can only have 1 parent
- if you see that a node has more than 1 parent then it is not a tree
- child nodes can also be parents

### Binary Search Tree
- if a number is greater than it goes on the right and if less than goes on the left.
- if you take any node in a binary search tree, all nodes below it to the right are going to be greater than thsat node, everythign to the elf tis going to be less than.

### BST: Big O
- 2²-1
- 2²
- we have 2 to the 4 nodes and it took 4 steps. 4 steps to find something. 4 steps to remove something, because yo uhave to iterate throught rhe list find it and then remove it. It's also 4 steps if we want to add a Node.
- that means all of these are O(log n). 
- O(log n) is very efficient - it is acheived by 'divide and conquer'.
- so we have made it so we never have to look t antyhing that is on the lef tof the 47. So we are effectively removing these from the search.
- that snot a big deal when you have small tree but with a million items in the tree you've just made it so that there are half  million items you dont have to look at.
- and from there we go left and now we have it so that half the reminaing node dont have to be looked at
- this is caleld 'divide and conquer'.
- a 'perfect' tree will give you your best possible scenario - and remember we measured best possible scenario with Omega.
- You'rwe mre likely to see a tree that is imperfect, not full, not complete, but even in this scitation you would say that it is roughly O(log n).
- Our worst case scenario would be if each next node is greater than the last and so keeps going in a straight line. Of a tree never forks it is essentially a LinekdList.
- So if we wanted 91 it woul still be 4 steps, and if we have 4 nodes in the tree, that is O(n)
- So the Big O of a binary search tree technically is O(n) not O(log n)
- what we assume with a binary search tree is it's not going to be a straight line, we're not going to have that worse possible sceneario, and we treat it as if it is O(log n) we don't treat it as an O(n) data structure
- so with lookup() insert() remove() we treat this as O(log n)

---
#### LinkedList vs BST
- insert is faster for a LinkedList because we can just add an item to the end and it is O(1) whereas inserting in aBST is O(log n)
- lookup is faster with a BST becuse it's O(log n) instead of O(n)
- and removing an item is also faster in  BST
- These comparison also apply to an ArrayList
- LinkedList and BST are both dynamically sized data structures
- so if you're keepng your arraulist unsorted then you jsut add a node tot he end, that's o(n), better than bst
- but if looking up or removing by value, not by index, then it's o(n)