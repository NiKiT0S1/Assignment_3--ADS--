ASSIGNMENT 3 -- DOCUMENTATION

## MyHashTable

MyHashTable - a class that implements a hash table data structure. It uses an array to store chains of linked lists, which represent collision chains.

### Methods:
- `put(K key, V value)`: Adds a key-value pair to the hash table.
- `get(K key)`: Retrieves the value associated with the key.
- `remove(K key)`: Removes the key-value pair by key.
- `contains(V value)`: Checks if the hash table contains a specific value.
- `getKey(V value)`: Retrieves the key for a given value.

### Usage Example:
```java
MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
MyTestingClass key = new MyTestingClass(1, "Data");
hashTable.put(key, "Value");
String value = hashTable.get(key); // Returns "Value"
hashTable.remove(key); // Removes the key-value pair


## MyTestingClass

MyTestingClass - a class used for testing MyHashTable. It contains a custom hashCode method for generating the object’s hash code.

### Methods:
- `getId()`: Retrieves the object’s identifier.
- `getData()`: Retrieves the object’s data.
- `setId(int id)`: Sets the object’s identifier.
- `setData(String data)`: Sets the object’s data.

### Usage Example:
```java
MyTestingClass testObject = new MyTestingClass(1, "Test Data");
int id = testObject.getId(); // Returns 1
String data = testObject.getData(); // Returns "Test Data"


## BST

BST (Binary Search Tree) - a class that implements a binary search tree data structure. It allows for operations such as insertion (put), searching (get), deletion (delete), and traversal (iterator) of tree elements.

## Methods:
- `put(K key, V val)`: Inserts an element into the tree.
- `get(K key)`: Retrieves the value by key.
- `delete(K key)`: Removes an element from the tree by key.
- `iterator()`: Provides an iterator for traversing the tree elements.

### Usage Example:
```java
BST<Integer, String> binaryTree = new BST<>();
binaryTree.put(5, "Root");
binaryTree.put(3, "Left Child");
String rootValue = binaryTree.get(5); // Returns "Root"
binaryTree.delete(5); // Removes the element with key 5


## Main

Main - a class containing a main method that can be used to test implementations of the above collections.

### Usage Example:
```java
// Creating a hash table and adding elements
MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
hashTable.put(new MyTestingClass(1, "Data1"), "Value1");
hashTable.put(new MyTestingClass(2, "Data2"), "Value2");

// Creating a binary search tree and adding elements
BST<Integer, String> binaryTree = new BST<>();
binaryTree.put(5, "Root");
binaryTree.put(3, "Left Child");
binaryTree.put(7, "Right Child");

// Retrieving and removing elements from the binary search tree
String rootValue = binaryTree.get(5); // Returns "Root"
binaryTree.delete(5); // Removes the element with key 5

// Iterating over the binary search tree
for (Integer key : binaryTree.iterator()) {
    System.out.println("Key: " + key + ", Value: " + binaryTree.get(key));
}
