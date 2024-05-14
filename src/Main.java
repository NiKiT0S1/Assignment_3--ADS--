//public class Main {
//    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//
//        binaryTree.insert(5);
//        binaryTree.insert(3);
//        binaryTree.insert(4);
//        binaryTree.insert(2);
//        binaryTree.insert(6);
//        binaryTree.insert(7);
//
//        binaryTree.inOrder();
//        System.out.println();
//        System.out.println("Root data before remove: " + binaryTree.root.data);
//        binaryTree.remove(5);
//        System.out.println();
//        binaryTree.inOrder();
//        System.out.println();
//        System.out.println("Root data after remove " + binaryTree.root.data);
//    }
//}
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(rand.nextInt(10000), "Data" + i);
            String value = "Value" + i;
            hashTable.put(key, value);
        }

        BST<Integer, String> binaryTree = new BST<>();

        binaryTree.put(5, "Root");
        binaryTree.put(3, "Left Child");
        binaryTree.put(4, "Left Child of Right Child");
        binaryTree.put(2, "Left Child of Left");
        binaryTree.put(6, "Right Child");
        binaryTree.put(7, "Right Child of Right");

        for (Integer key : binaryTree.iterator()) {
            System.out.println("Key: " + key + ", Value: " + binaryTree.get(key));
        }

        System.out.println("\nRoot data before remove: " + binaryTree.get(5));
        binaryTree.delete(5);
        System.out.println("\nRoot data after remove: ");
        for (Integer key : binaryTree.iterator()) {
            System.out.println("Key: " + key + ", Value: " + binaryTree.get(key));
        }
        System.out.println("\nNew root data: " + binaryTree.get(binaryTree.iterator().iterator().next()));
    }
}