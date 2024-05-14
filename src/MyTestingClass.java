//import java.util.Random;

public class MyTestingClass {
    private int id;
    //private static final Random RANDOM = new Random();
    private String data;

    public MyTestingClass(int id, String data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public int hashCode() {
        // Простой пример пользовательского метода hashCode
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + (data == null ? 0 : data.hashCode());
        return hash;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }
}

