import java.util.Random;

public class MyTestingClass {
    private int id;
    private static final Random RANDOM = new Random();

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        // Простой пример пользовательского метода hashCode
        int hash = 7;
        hash = 31 * hash + id;
        return hash;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        int buckets = 11; // Количество бакетов в хеш-таблице
        int[] bucketSizes = new int[buckets];

        // Добавление 10000 случайных элементов в хеш-таблицу
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(RANDOM.nextInt(10000));
            String value = "Student" + i;
            table.put(key, value);

            // Увеличение размера соответствующего бакета
            int index = key.hashCode() % buckets;
            bucketSizes[index]++;
        }

        // Вывод количества элементов в каждом бакете
        for (int i = 0; i < buckets; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
    }
}

