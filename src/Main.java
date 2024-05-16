import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Creating an instance of MyHashTable with keys of type MyTestingClass and values of type String
        MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
        Random rand = new Random();

        // Adding 10000 random elements to the hash table
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(rand.nextInt(10000), "Data" + i);
            String value = "Value" + i;
            hashTable.put(key, value);
        }

        // Creating an instance of BST with keys of type Integer and values of type String
        BST<Integer, String> binaryTree = new BST<>();

        // Adding elements to the binary search tree
        binaryTree.put(5, "Root");
        binaryTree.put(3, "Left Child");
        binaryTree.put(4, "Left Child of Right Child");
        binaryTree.put(2, "Left Child of Left");
        binaryTree.put(6, "Right Child");
        binaryTree.put(7, "Right Child of Right");

        // Printing all elements of the binary search tree
        for (Integer key : binaryTree.iterator()) {
            System.out.println("Key: " + key + ", Value: " + binaryTree.get(key));
        }

        // Printing the value of the root element before removal
        System.out.println("\nRoot data before remove: " + binaryTree.get(5));
        // Deleting the root element
        binaryTree.delete(5);
        // Printing all elements of the binary search tree after removal
        System.out.println("\nRoot data after remove: ");
        for (Integer key : binaryTree.iterator()) {
            System.out.println("Key: " + key + ", Value: " + binaryTree.get(key));
        }
        // Printing the value of the new root element
        System.out.println("\nNew root data: " + binaryTree.get(binaryTree.iterator().iterator().next()));
    }
}