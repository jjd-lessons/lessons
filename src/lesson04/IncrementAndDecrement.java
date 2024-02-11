package lesson04;

public class IncrementAndDecrement {
    public static void main(String[] args) {
        // I. Инкремент (++) / Декремент (--)
        int a = 1;
        // Инкремент (постфиксная форма)
        System.out.println(a++); // 1
        System.out.println(a); // 2

        a = 1;
        // Инкремент (префиксная форма)
        System.out.println(++a); // 2
        System.out.println(a); // 2

        a = 1;
        // Декремент (постфиксная форма)
        System.out.println(a--); // 1
        System.out.println(a); // 0

        a = 1;
        // Декремент (префиксная форма)
        System.out.println(--a); // 0
        System.out.println(a); // 0

    }
}