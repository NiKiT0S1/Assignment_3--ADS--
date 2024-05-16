/**
 * BST (Binary Search Tree) is a data structure that maintains a set of keys in a tree structure.
 * It allows efficient insertion, deletion, and retrieval operations.
 * This implementation supports generic key-value pairs.
 */

import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root; // Root node of the binary search tree

    // Node represents a node in the binary search tree containing a key-value pair.
    private class Node {
        private K key; // Key of the node
        private V val; // Value associated with the key
        private Node left, right; // References to the left and right child nodes

        /**
         * Constructor to create a new Node with the given key and value.
         * @param key The key of the node
         * @param val The value associated with the key
         */
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Inserts a key-value pair into the binary search tree.
     * If the key already exists, updates the corresponding value.
     * @param key The key to insert
     * @param val The value associated with the key
     */
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    /**
     * Recursive helper method to insert a key-value pair into the binary search tree.
     * @param node The root of the subtree
     * @param key The key to insert
     * @param val The value associated with the key
     * @return The root of the updated subtree
     */
    private Node put(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        }
        else if (cmp > 0) {
            node.right = put(node.right, key, val);
        }
        else {
            node.val = val;
        }
        return node;
    }

    /**
     * Retrieves the value associated with the given key from the binary search tree.
     * @param key The key whose value is to be retrieved
     * @return The value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        return get(root, key);
    }

    /**
     * Recursive helper method to retrieve the value associated with the given key from the binary search tree.
     * @param node The root of the subtree
     * @param key The key whose value is to be retrieved
     * @return The value associated with the key, or null if the key is not found
     */
    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        }
        else if (cmp > 0) {
            return get(node.right, key);
        }
        else {
            return node.val;
        }
    }

    /**
     * Deletes the key-value pair associated with the given key from the binary search tree.
     * @param key The key to delete
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    /**
     * Recursive helper method to delete the key-value pair associated with the given key from the binary search tree.
     * @param node The root of the subtree
     * @param key The key to delete
     * @return The root of the updated subtree
     */
    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        }
        else if (cmp > 0) {
            node.right = delete(node.right, key);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    /**
     * Finds the minimum key in the binary search tree.
     * @param node The root of the subtree
     * @return The node with the minimum key
     */
    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        else {
            return min(node.left);
        }
    }

    /**
     * Deletes the node with the minimum key from the binary search tree.
     * @param node The root of the subtree
     * @return The root of the updated subtree
     */
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    /**
     * Performs an in-order traversal of the binary search tree and returns the keys in sorted order.
     * @return An iterable containing the keys in sorted order
     */
    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }

    /**
     * Recursive helper method to perform an in-order traversal of the binary search tree.
     * @param node The root of the subtree
     * @param keys The list to store the keys
     */
    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }
}
