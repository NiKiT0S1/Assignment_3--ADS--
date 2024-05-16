/**
 * MyHashTable is a custom implementation of a hash table in Java.
 * It allows storing key-value pairs and provides methods for insertion, retrieval, removal,
 * and checking for the existence of values in the table.
 */

import java.util.Random;

public class MyHashTable<K, V> {

    // HashNode represents a node in the hash table, containing a key-value pair.
    private class HashNode<K, V> {
        private K key; // Key of the node
        private V value; // Value associated with the key
        private HashNode<K, V> next; // Reference to the next node in case of collisions

        /**
         * Constructor to create a new HashNode with the given key and value.
         * @param key The key of the node
         * @param value The value associated with the key
         */
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Overrides the toString() method to provide a string representation of the HashNode.
         * @return String representation of the HashNode
         */
        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray; // Array of linked lists to handle collisions
    private int M = 11; // Default size of the hash table
    private int size; // Number of key-value pairs in the hash table

    // Default constructor to initialize the hash table with default size.
    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    /**
     * Constructor to initialize the hash table with a specified size.
     * @param M The size of the hash table
     */
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    /**
     * Hash function to calculate the index for a given key.
     * @param key The key for which the index is to be calculated
     * @return The index calculated using the hash function
     */
    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }

    /**
     * Inserts a key-value pair into the hash table.
     * If the key already exists, updates the corresponding value.
     * @param key The key to insert
     * @param value The value associated with the key
     */
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    /**
     * Retrieves the value associated with the given key from the hash table.
     * @param key The key whose value is to be retrieved
     * @return The value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * Removes the key-value pair associated with the given key from the hash table.
     * @param key The key to remove
     * @return The value associated with the removed key, or null if the key is not found
     */
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = node.next;
                }
                else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    /**
     * Checks if the hash table contains the specified value.
     * @param value The value to check for existence in the hash table
     * @return True if the value exists in the hash table, otherwise false
     */
    public boolean contains(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    /**
     * Retrieves the key associated with the specified value from the hash table.
     * @param value The value for which the associated key is to be retrieved
     * @return The key associated with the specified value, or null if the value is not found
     */
    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
}