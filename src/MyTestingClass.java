/**
 * MyTestingClass represents a simple class used for testing purposes.
 * It contains an integer id and a string data, along with methods to get and set these attributes.
 * Additionally, it overrides the hashCode() method to provide a custom hash code implementation.
 */

public class MyTestingClass {
    private int id; // Integer identifier
    private String data; // String data associated with the identifier

    /**
     * Constructor to create a new instance of MyTestingClass with the given id and data.
     * @param id The integer identifier
     * @param data The string data associated with the identifier
     */
    public MyTestingClass(int id, String data) {
        this.id = id;
        this.data = data;
    }

    /**
     * Overrides the hashCode() method to provide a custom hash code implementation.
     * This method combines the hash codes of the id and data attributes using a simple formula.
     * @return The calculated hash code for the object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + id; // Combining hash code of id
        hash = 31 * hash + (data == null ? 0 : data.hashCode()); // Combining hash code of data
        return hash;
    }

    /**
     * Getter method to retrieve the id of the object.
     * @return The id of the object
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method to retrieve the data associated with the object.
     * @return The data associated with the object
     */
    public String getData() {
        return data;
    }

    /**
     * Setter method to set the id of the object.
     * @param id The new id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter method to set the data associated with the object.
     * @param data The new data to set
     */
    public void setData(String data) {
        this.data = data;
    }
}

