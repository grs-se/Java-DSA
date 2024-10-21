# Graph

## Graph: Intro
- Vertex or Node. Proper word is Vertex.
- plural vertices. 
- between the vertices is an Edge of Connection
- No limit to how many other vertices that a vertex can connect to.
- With graphs one of the things you can have is 'weighted edges'
- So where you would use something like this is a maps app, so a road between 76 and 82 has a lot of traffic so you'd go this weigh because it has a cost of 5 whereas this way has a cost of 15
- ANother place you'd see this in use is in Network Routing Protocols. It would be a better to have an extra router hop and two very fast links than go the way with the very slow link.
- Another concept with graphs, explained with a Facebook connection between you and a friend, your friend is friends with you and you are friends with your friend. It is a bidirectional relationship. Whereas in Twitter or Instagram you follow a celebrity, they don't follow you back, that is directional.
- So the edges can be weighted or non-weighted, directional or non-directional.
- Also, we have seen a graph in this course. It was a tree. Trees a form of graph, but they have the limitation of each Node only being able to point to two other Nodes.
- And when we studied trees we mentioned that we had seen a tree before which was a LinkedList.
- So a LinkedList is a form of a Tree, and a Tree is a form of Graph, therefore a LinkedList is a form of a Graph, with the limitation that they can only point to one other Node.

---

## Graph: Adjacency Matrix

- There are two ways we can look at being able to represent a graph. 
- The first one is an Adjacency Matrix. 
- The second one is an Adjacency List.
- Weight values can be stored in adjaceny matrix

## Graph: Adjaceny List

- In a hashmap we would represnt this as a key value pair
- the vertex itself is the key and then the value is going to be am array list with all the edges.
- B has edges with A and C.
- C has edges with B and D.
- etc
- this hashmap on the right is another way of representing this graph on the left.

```json
[
  {
    "A" : ["B", "E"],
    "B" : ["A", "C"],
    "C" : ["B", "D"],
    // ...
  }
]

```

---

## Graph: Big O
- We've looked at 2 way of representing this graph: an adjacency matrix and an adjacency list.
- We'll look at the BigO of both. 
- First we'll look at space completexity
- If we have a vertex like A with an adjacency list we're going to store that vertex and then we're going ot store each one of the edges 
- In an adjaceny matrix we store those edges but we also but we also have to store everuything that it is not connected to. All of these 0s. And that is a big advatnage of the adjaceny list.
- So for space complexity the adjacency matrix is O of the number of vertices squared.
  - O ( |V|²)
- In the adjacency list its the number of vertices plus the number of edges
  - O ( |V|+|E| )
- So from a space complexity perspective the adjacency list is better.
- The adjaceny matrix is going to be stored in a 2-dimensional array, as soon as you make those arrays bigger you have to create new arrays that are bigger/
  - And creating those new arrays is very inefficint
  - So from a BigO pserpexitce the adjaceny matrix is the number of vertices squyared everyt ime youadd a vertex, whereas in a adjceny list it is O(1) every time you add a vertex. So an adjancey list is much more efficient at doing this.
- Both the matrix and the list are 0(1) to add an edge
- To remove an edge the matrix outperforms the list. The matriux is O(1) but the lsit you have to go threough all the edges and a particular vertex might have a 1000 edges
- 
  - 