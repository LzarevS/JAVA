public class Arithmetic {
    public int a;
    public int b;

    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic(8, 12);
        System.out.println("Результат сложения: " + arithmetic.amount());
        System.out.println("Результат умножения: " + arithmetic.square());
        System.out.println("Какое число больше? " + arithmetic.compareMax());
        System.out.println("Какое число меньше? " + arithmetic.compareMin());
    }

    public int amount() {
        return a + b;
    }

    public int square() {
        return a * b;
    }

    public int compareMax() {
        int max = Math.max(a, b);
        return max;

    }

    public int compareMin() {
        int min = Math.min(a, b);
        return min;

    }


}



