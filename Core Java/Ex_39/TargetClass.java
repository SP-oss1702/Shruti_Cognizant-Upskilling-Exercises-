package Ex_39;

public class TargetClass {

    // Fields
    private String name;
    private int    age;
    public  String city;
    private static int count = 0;

    // Constructor 1
    public TargetClass() {
        this.name = "Unknown";
        this.age  = 0;
        count++;
    }

    // Constructor 2
    public TargetClass(String name, int age) {
        this.name = name;
        this.age  = age;
        count++;
    }

    // Public method
    public String greet() {
        return "Hello, I am " + name + "!";
    }

    // Public method with parameter
    public int add(int a, int b) {
        return a + b;
    }

    // Public method with String parameter
    public String sayHello(String person) {
        return "Hi " + person + ", I am " + name + "!";
    }

    // Private method with parameter
    private int multiply(int x, int y) {
        return x * y;
    }

    // Static method
    public static int getCount() {
        return count;
    }

    // Getter
    public String getName() { return name; }
    public int    getAge()  { return age;  }

    // Setter
    public void setName(String name) { this.name = name; }
    public void setAge(int age)      { this.age  = age;  }

    @Override
    public String toString() {
        return "TargetClass{name='" + name
                + "', age=" + age + "}";
    }
}